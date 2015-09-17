package rox.warpstone.util;

public class Octree {
	
	//The root node of the tree.
	private OctreeNode root;
	
	
	public Octree(int xwidth, int yheight, int zdepth, Location origin) {
		root = new OctreeNode(xwidth, yheight, zdepth, origin);
	}
	
	public void insert(Location loc) {
		root.insert(loc);
	}
	
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
		private int xwidth;
		private int yheight;
		private int zdepth;
		
		//Only for making a root node
		public OctreeNode(int xwidth, int yheight, int zdepth, Location origin) {
			this.xwidth = xwidth;
			this.yheight = yheight;
			this.zdepth = zdepth;
			this.children = new OctreeNode[8];
			
			//Make empty children so that the root node is considered an interior node.
			for (int i=0; i>8; i++) {
				this.children[i] = new OctreeNode(this);
			}
		}
		
		public OctreeNode(OctreeNode parent) {
			this(null, parent);
		}
		
		public OctreeNode(Location loc, OctreeNode parent) {
			this.data = loc;
			this.parent = parent;
			this.xwidth = parent.xwidth/2;
			this.yheight = parent.yheight/2;
			this.zdepth = parent.zdepth/2;
			
			this.children = new OctreeNode[8];
		}
		
		public boolean isLeaf() {
			//If all children are null, this is a leaf node, else it's an interior node.
			return (this.children[0] == null 
					&& this.children[1] == null 
					&& this.children[2] == null 
					&& this.children[3] == null 
					&& this.children[4] == null 
					&& this.children[5] == null 
					&& this.children[6] == null 
					&& this.children[7] == null)? true : false;
		}
		
		public boolean hasData() {
			return (this.data != null)? true : false;
		}
		
		public void insert(Location loc) {
			if (!isLeaf()) {
				//determine the index to run the insert on.
				int index = pickIndex(loc);
				
				//If the child isn't initialized do so and insert.
				if (this.children[index] == null) {
					this.children[index] = new OctreeNode(loc, this);
				}
				//Else recurse in and insert.
				else {
					this.children[index].insert(loc);
				}
			}
			else if (hasData()) {
				//Back up, make a new interior node, place this as a child of the new interior node, and then insert the loc in the new parent.
				
				//Get the index of this node in relation to the parent. 
				int index = parent.pickIndex(this.data);
				
				//Create the interior center point for this new interior child.
				Location inLoc = new Location(0,((index&0x1)==0x1)?parent.data.getX()+(xwidth/2):parent.data.getX()-(xwidth/2),
											((index&0x2)==0x2)?parent.data.getY()+(yheight/2):parent.data.getY()-(yheight/2),
											((index&0x4)==0x4)?parent.data.getZ()+(zdepth/2):parent.data.getZ()-(zdepth/2));
				
				//Make the new interior child
				parent.children[index] = new OctreeNode(inLoc, parent);
				//grab the new node to use as a parent.
				parent = parent.children[index];
				//Attach this node as a new leaf of the new parent.
				parent.children[parent.pickIndex(this.data)] = this;
				//Insert a new node on the parent.
				parent.insert(loc);
			}
			else {
				this.data = loc;
			}
		}

		public Location findNearest(Location loc) {
			
			Location out = null;
			
			if (isLeaf()) {
				out = this.data;
			}
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
					int distanceToChild = Integer.MAX_VALUE;
					
					//Check neighboring quadrants.
					if (this.children[(index^0x1)] != null) {
						
						int distanceTo = this.children[(index^0x1)].data.quickDistanceTo(loc);
						
						
						if (distanceTo < distanceToChild) {
							nearestIndex = index^0x1;
							distanceToChild = distanceTo;
						}
					}
					else if (this.children[(index^0x2)] != null) {
						int distanceTo = this.children[(index^0x2)].data.quickDistanceTo(loc);						
						
						if (distanceTo < distanceToChild) {
							nearestIndex = index^0x2;
							distanceToChild = distanceTo;
						}
					}
					else if (this.children[(index^0x4)] != null) {
						int distanceTo = this.children[(index^0x4)].data.quickDistanceTo(loc);
						
						
						if (distanceTo < distanceToChild) {
							nearestIndex = index^0x4;
							distanceToChild = distanceTo;
						}
					}
					
					
					//Check non-neighboring quadrants if we didn't find a child yet.
					if (distanceToChild == Integer.MAX_VALUE) {
						if (this.children[(index^0x3)] != null) {
							int distanceTo = this.children[(index^0x3)].data.quickDistanceTo(loc);
							
							
							if (distanceTo < distanceToChild) {
								nearestIndex = index^0x3;
								distanceToChild = distanceTo;
							}
						}
						else if (this.children[(index^0x5)] != null) {
							int distanceTo = this.children[(index^0x5)].data.quickDistanceTo(loc);
							
							
							if (distanceTo < distanceToChild) {
								nearestIndex = index^0x5;
								distanceToChild = distanceTo;
							}
						}
						else if (this.children[(index^0x6)] != null) {
							int distanceTo = this.children[(index^0x6)].data.quickDistanceTo(loc);
							
							
							if (distanceTo < distanceToChild) {
								nearestIndex = index^0x6;
								distanceToChild = distanceTo;
							}
						}
						else if (this.children[(index^0x7)] != null) {
							int distanceTo = this.children[(index^0x7)].data.quickDistanceTo(loc);
							
							
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
			index = ((this.data.getX() - loc.getX()) >> 31 ) & 0x1;
			//If the y value of the node is smaller than the y value of the
			//provided point, set the 2's place bit
			index = ((((this.data.getY() - loc.getY()) >> 31 ) & 0x1 ) << 1 ) ^ index;
			//If the z value of the node is smaller than the z value of the
			//provided point, set the 4's place bit
			index = ((((this.data.getZ() - loc.getZ()) >> 31 ) & 0x1 ) << 2 ) ^ index;
			
			return index;
		}
		
	}
	
}
