package rox.warpstone.util;

public class Octree {
	
	//The root node of the tree.
	private OctreeNode root;
	
	/**
	 * Constructor for an Octree. We want the dimensions of the area and it's center point.
	 * @param xwidth
	 * @param yheight
	 * @param zdepth
	 * @param origin
	 */
	public Octree(int xwidth, int yheight, int zdepth, Location origin) {
		root = new OctreeNode(xwidth, yheight, zdepth, origin);
	}
	
	/**
	 * Wrapper method to insert into the tree.
	 * @param loc
	 */
	public void insert(Location loc) {
		root.insert(loc);
	}
	
	/**
	 * Wrapper method to find the nearest point to the one supplied.
	 * @param loc
	 * @return
	 */
	public Location findNearest(Location loc) {
		return root.findNearest(loc);
	}
	
	/*
	 * Private class that makes up the tree itself. This is hidden from outside
	 * code, with only what's in the Octree class exposed.
	 */
	private class OctreeNode {
		
		//Data held by the node
		private Location data;
		//This node's parent. Null if root node.
		private OctreeNode parent;
		//This node's children. 8 elements long.
		private OctreeNode children[];
		
		//Dimensions of the bounding box.
		private double xwidth;
		private double yheight;
		private double zdepth;
		
		//Only for making a root node
		public OctreeNode(double xwidth, double yheight, double zdepth, Location origin) {
			this.xwidth = xwidth;
			this.yheight = yheight;
			this.zdepth = zdepth;
			this.data = origin;
			this.children = new OctreeNode[8];
			
			//Make empty children so that the root node is considered an interior node.
			for (int i=0; i<8; i++) {
				this.children[i] = new OctreeNode(this, false);
			}
		}
		
		public OctreeNode(OctreeNode parent, boolean interior) {
			this(null, parent, interior);
		}
		
		public OctreeNode(Location loc, OctreeNode parent, boolean interior) {
			this.data = loc;
			this.parent = parent;
			this.xwidth = parent.xwidth/2.0;
			this.yheight = parent.yheight/2.0;
			this.zdepth = parent.zdepth/2.0;
			
			this.children = new OctreeNode[8];
			
			if(interior) {
				//Make empty children so that the node is considered an interior node.
				for (int i=0; i<8; i++) {
					this.children[i] = new OctreeNode(this, false);
				}
			}
		}
		
		/**
		 * Determines if a node is a leaf node. A leaf node is a node that has no children.
		 * @return true if a leaf node, false if an interior node.
		 */
		public boolean isLeaf() {
			//If children are null, this is a leaf node, else it's an interior node.
			//Given we have either no children or all children initialized, only
			//one check is needed.
			return (this.children[0] == null)? true : false;
		}
		
		/**
		 * Recursive method for inserting a location into the tree.
		 * @param loc The location being inserted.
		 */
		public void insert(Location loc) {
			//If we aren't in a leaf node.
			if (!isLeaf()) {
				//determine the index to run the insert on.
				int index = pickIndex(loc);
				
				//If the child isn't initialized do so and insert.
				if (this.children[index] == null) {
					this.children[index] = new OctreeNode(loc, this, false);
				}
				//Else recurse in and insert.
				else {
					this.children[index].insert(loc);
				}
			}
			//Else if this leaf node has data
			else if (this.data != null) {
				//Back up, make a new interior node, place this as a child of the new interior node, and then insert the loc in the new parent.
				
				//Get the index of this node in relation to the parent. 
				int index = parent.pickIndex(this.data);
				
				//Create the interior center point for this new interior child.
				Location inLoc = new Location(0,((index&0x1)!=0)?parent.data.getX()+(parent.xwidth/4.0):parent.data.getX()-(parent.xwidth/4.0),
											((index&0x2)!=0)?parent.data.getY()+(parent.yheight/4.0):parent.data.getY()-(parent.yheight/4.0),
											((index&0x4)!=0)?parent.data.getZ()+(parent.zdepth/4.0):parent.data.getZ()-(parent.zdepth/4.0));
				
				//Make the new interior child
				parent.children[index] = new OctreeNode(inLoc, parent, true);
				//Insert this node back into the tree.
				parent.children[index].insert(data);
				//Insert a new node on the parent.
				parent.children[index].insert(loc);
			}
			//else if it doesn't have data
			else {
				this.data = loc;
			}
		}

		/**
		 * Find the nearest point to the given point.
		 * @param loc The location that we want the nearest point to.
		 * @return The nearest point
		 */
		public Location findNearest(Location loc) {
			
			Location out = null;
			
			//If we are in a leaf node, return the location. We found it!
			if (isLeaf()) {
				out = this.data;
			}
			//If we are in an interior node, find our way down toward the closest point.
			else {
				//Get the index of the closest child. Check if it's not null.
				//If null, check indexes that are one quadrant off.
				//If those are null, check the remaining quadrants.
				
				//Grab the index of the closest child.
				int index = pickIndex(loc);
				
				//If not null, call find nearest in that node.
				if (this.children[index] != null) {
					out = this.children[index].findNearest(loc);
				}
				//Else spread out and check other nodes.
				else {
					
					int nearestIndex = 0;
					double distanceToChild = Double.MAX_VALUE;
					
					//Check neighboring quadrants.
					if (this.children[(index^0x1)] != null) {
						
						double distanceTo = this.children[(index^0x1)].data.quickDistanceTo(loc);
						
						if (distanceTo < distanceToChild) {
							nearestIndex = index^0x1;
							distanceToChild = distanceTo;
						}
					}
					else if (this.children[(index^0x2)] != null) {
						double distanceTo = this.children[(index^0x2)].data.quickDistanceTo(loc);						
						
						if (distanceTo < distanceToChild) {
							nearestIndex = index^0x2;
							distanceToChild = distanceTo;
						}
					}
					else if (this.children[(index^0x4)] != null) {
						double distanceTo = this.children[(index^0x4)].data.quickDistanceTo(loc);
						
						if (distanceTo < distanceToChild) {
							nearestIndex = index^0x4;
							distanceToChild = distanceTo;
						}
					}
					
					//Check non-neighboring quadrants if we didn't find a child yet.
					if (distanceToChild == Integer.MAX_VALUE) {
						if (this.children[(index^0x3)] != null) {
							double distanceTo = this.children[(index^0x3)].data.quickDistanceTo(loc);
							
							if (distanceTo < distanceToChild) {
								nearestIndex = index^0x3;
								distanceToChild = distanceTo;
							}
						}
						else if (this.children[(index^0x5)] != null) {
							double distanceTo = this.children[(index^0x5)].data.quickDistanceTo(loc);
							
							if (distanceTo < distanceToChild) {
								nearestIndex = index^0x5;
								distanceToChild = distanceTo;
							}
						}
						else if (this.children[(index^0x6)] != null) {
							double distanceTo = this.children[(index^0x6)].data.quickDistanceTo(loc);
							
							if (distanceTo < distanceToChild) {
								nearestIndex = index^0x6;
								distanceToChild = distanceTo;
							}
						}
						else if (this.children[(index^0x7)] != null) {
							double distanceTo = this.children[(index^0x7)].data.quickDistanceTo(loc);
							
							if (distanceTo < distanceToChild) {
								nearestIndex = index^0x7;
								distanceToChild = distanceTo;
							}
						}
					}
					
					out = this.children[nearestIndex].findNearest(loc);
				}
				
			}
			
			return out;
		}
		
		/**
		 * Picks the children index a given location points toward.
		 * @param loc The location
		 * @return The index
		 */
		private int pickIndex(Location loc) {
			int index = 0;
			//If the x value of the node is smaller than the x value of the
			//provided point, set the 1's place bit
			index = (((int)(this.data.getX() - loc.getX())) >> 31 ) & 0x1;
			//If the y value of the node is smaller than the y value of the
			//provided point, set the 2's place bit
			index = ((((int)(this.data.getY() - loc.getY())) >> 30 ) & 0x2 ) ^ index;
			//If the z value of the node is smaller than the z value of the
			//provided point, set the 4's place bit
			index = ((((int)(this.data.getZ() - loc.getZ())) >> 29 ) & 0x4 ) ^ index;
			
			return index;
		}
		
	}
	
}
