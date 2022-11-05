package Ex4;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

public class UnionFind {
	double angle;
	int[] id;
	int[] height;
	Point[] elements; 
	Point relative = new Point(50, 50); // relative point to compare other points with
	HashSet<Integer> uniqueGroups = new HashSet<Integer>();
	
	public UnionFind(int size, double angle) {
		this.angle = 0;
		this.height = new int[size];
		this.id = new int[size];
		this.doisJoin();
		elements = Ex4Utils.generateRandomArray(size);
		increaseAngle(angle);
	}
	
	public int Find(int p) {
		if(id[p] != p)
			p = Find(id[p]);
		return p;
	}
	
	public void doisJoin() {
		uniqueGroups.clear();
		for (int i = 0; i < height.length; i++) {
			height[i] = 1;
		}
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
			uniqueGroups.add(i);
		}
	}
	
	public void Union(int ind1, int ind2) {
		int ind1Parent = Find(ind1);
		int ind2Parent = Find(ind2);
		if(ind1 == ind2)
			return;
		//move the smaller height to be the son of the other
		if(height[ind1Parent] < height[ind2Parent]){
			id[ind1Parent] = ind2Parent;
			uniqueGroups.remove(ind1Parent);
		}
		else if (height[ind1Parent] > height[ind2Parent]){
			id[ind2Parent] = ind1Parent;
			uniqueGroups.remove(ind2Parent);
		}
		//if they are the same height
		//the root of set ind1 will be the root of set ind2 and will be higher
		else{
			id[ind2Parent] = ind1Parent;
			uniqueGroups.remove(ind2Parent);
			height[ind1Parent]++;
		}
		 
	}

	public void increaseAngle(double d) {
		this.angle += d;
		UnionByAngularDist(relative);
	}
	
	public void UnionByAngularDist(Point p) {
		ArrayList<Integer> temp = new ArrayList<Integer>(uniqueGroups);
		for (int i = 0; i < temp.size(); i++) {
			int i1Root = Find(temp.get(i));
			for (int j = i+1; j < temp.size(); j++) {
				int i2Root = Find(temp.get(j));
				double i1Angle = Ex4Utils.angleFrom(p, elements[i1Root]);
				double i2Angle = Ex4Utils.angleFrom(p, elements[i2Root]);
				int i1Ratio =  (int) (i1Angle / angle);
				int i2Ratio  = (int)(i2Angle / angle);
				if(i1Ratio == i2Ratio){
					Union(i1Root, i2Root);
				}
			}
		}
		
	
	}
	
}
