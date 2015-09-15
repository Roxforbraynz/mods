package rox.warpstone.util;

public class Octree {
	
	//The root node of the tree.
	private OctreeNode root;
	private int xmin;
	private int xmax;
	private int ymin;
	private int ymax;
	private int zmin;
	private int zmax;
	
	public Octree(int xmin, int xmax, int ymin, int ymax, int zmin, int zmax) {
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
		this.zmin = zmin;
		this.zmax = zmax;
		
		root = new OctreeNode();
	}
	
	public void insert(Location loc) {
		root.insert(loc);
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
		
		public OctreeNode() {
			this.children = new OctreeNode[8];
		}
		
		public OctreeNode(OctreeNode parent) {
			this(null, parent);
		}
		
		public OctreeNode(Location loc, OctreeNode parent) {
			this.data = loc;
			this.parent = parent;
		}
		
		public boolean isLeaf() {
			//If all children are null, this is a leaf node, else it's an interior node.
			return (children[0] == null 
					&& children[1] == null 
					&& children[2] == null 
					&& children[3] == null 
					&& children[4] == null 
					&& children[5] == null 
					&& children[6] == null 
					&& children[7] == null)? true : false;
		}
		
		public boolean hasData() {
			return (data != null)? true : false;
		}
		
		public void insert(Location loc) {
			if (!isLeaf()) {
				//determine the index to run the insert on.
				int index = 0;
				index = (data.getX() > loc.getX())? index ^ 0x1 : index;
				index = (data.getY() > loc.getY())? index ^ 0x2 : index;
				index = (data.getZ() > loc.getZ())? index ^ 0x4 : index;
				
				//If the child isn't initialized do so and insert.
				if (children[index] == null) {
					children[index] = new OctreeNode(loc, this);
				}
				//Else recurse in and insert.
				else {
					children[index].insert(loc);
				}
			}
			if (!hasData()) {
				data = loc;
			}
		}
	}
	
}
