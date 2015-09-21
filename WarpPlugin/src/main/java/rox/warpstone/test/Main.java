package rox.warpstone.test;

import java.util.Collection;
import java.util.Iterator;

import rox.warpstone.util.Location;
import rox.warpstone.util.Octree;

public class Main {

	public static void main(String[] args) {
		
		//indexFindingTest();
		octreeTest();
	}
	
	public static void indexFindingTest() {
		//Number of pairs of points to compare
		int testSize = 100000;
		
		//Test data
		Location dataVals[] = new Location[testSize];
		Location locVals[] = new Location[testSize];
		
		//Generate the data. Dimension ID doesn't matter here.
		for ( int i = 0; i < testSize; i++) {
			dataVals[i] = new Location(0, (int) (Math.random()*100)%100, (int) (Math.random()*100)%100, (int) (Math.random()*100)%100);
			locVals[i] = new Location(0, (int) (Math.random()*100)%100, (int) (Math.random()*100)%100, (int) (Math.random()*100)%100);
		}
		
		//Print out the results of both methods. They should produce the same result.
		for (int i = 0; i < testSize; i++) {
			//Method 1: conditional + xor
			int test1 = 0;
			test1 = (dataVals[i].getX() < locVals[i].getX())? test1 ^ 0x1 : test1;
			test1 = (dataVals[i].getY() < locVals[i].getY())? test1 ^ 0x2 : test1;
			test1 = (dataVals[i].getZ() < locVals[i].getZ())? test1 ^ 0x4 : test1;
			
			//Method 2: All math/bitwise
			int test2 = 0;
			test2 = (((int)(dataVals[i].getX() - locVals[i].getX())) >> 31 ) & 0x1;
			test2 = ((((int)(dataVals[i].getY() - locVals[i].getY())) >> 30 ) & 0x2 ) ^ test2;
			test2 = ((((int)(dataVals[i].getZ() - locVals[i].getZ())) >> 29 ) & 0x4 ) ^ test2;
			
			//Print the results
			System.out.println("Test " + i);
			System.out.println("Method 1: " + test1);
			System.out.println("Method 2: " + test2);
		}
		
		//Begin timing method 1.
		long time1Start = System.currentTimeMillis();
		
		//Run through all test data with method 1
		for (int i = 0; i < testSize; i++ ) {
			int test1 = 0;
			test1 = (dataVals[i].getX() < locVals[i].getX())? test1 ^ 0x1 : test1;
			test1 = (dataVals[i].getY() < locVals[i].getY())? test1 ^ 0x2 : test1;
			test1 = (dataVals[i].getZ() < locVals[i].getZ())? test1 ^ 0x4 : test1;
		}
		
		//Finish timing method 1
		long time1End = System.currentTimeMillis();
		
		//Print how long method 1 took to complete
		System.out.println("Method 1 time: " + (time1End-time1Start) + "ms" );
		
		//Begin timing method 2
		long time2Start = System.currentTimeMillis();
		
		//Run through all test daya with method 2
		for (int i = 0; i < testSize; i++ ) {
			int test2 = 0;
			test2 = (((int)(dataVals[i].getX() - locVals[i].getX())) >> 31 ) & 0x1;
			test2 = ((((int)(dataVals[i].getY() - locVals[i].getY())) >> 30 ) & 0x2 ) ^ test2;
			test2 = ((((int)(dataVals[i].getZ() - locVals[i].getZ())) >> 29 ) & 0x4 ) ^ test2;
		}
		
		//Finish timing method 2
		long time2End = System.currentTimeMillis();
		
		//Print how long method 2 took to complete
		System.out.println("Method 2 time: " + (time2End-time2Start) + "ms" );
	}
	
	public static void octreeTest() {
		Location octreePoints[] = new Location[10];
		Location testPoints[] = new Location[10];
		
		//Test points to go in the octree
		octreePoints[0] = new Location(0,5,4,1);
		octreePoints[1] = new Location(0,0,-5,3);
		octreePoints[2] = new Location(0,-5,1,8);
		octreePoints[3] = new Location(0,10,10,10);
		octreePoints[4] = new Location(0,-2,-2,-2);
		octreePoints[5] = new Location(0,0,0,0);
		octreePoints[6] = new Location(0,5,-5,5);
		octreePoints[7] = new Location(0,1,2,3);
		octreePoints[8] = new Location(0,-4,-3,-8);
		octreePoints[9] = new Location(0,-2,5,-1);
		
		//Declare and initialize the Octree.
		Octree tree = new Octree(20,20,20,new Location(0,0,0,0));
		
		//Insert points into the Octree.
		for (int i=0; i<10; i++)
			tree.insert(octreePoints[i]);
		
		
		//Check to make sure all points are in there.
		Collection<Location> points = tree.getPoints();
		Iterator<Location> i = points.iterator();
		System.out.println("Insert and Point Retrieval Test");
		
		while (i.hasNext()) {
			System.out.println(i.next().toString());
		}
		
		
		//Test points to test against the octree
		testPoints[0] = new Location(0,0,0,1);
		testPoints[1] = new Location(0,-3,4,-2);
		
		System.out.println("Find Nearest Test");
		
		System.out.println(tree.findNearest(testPoints[0]).toString());
		System.out.println(tree.findNearest(testPoints[1]).toString());
	}
}
