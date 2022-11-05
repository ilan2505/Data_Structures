package tirgoul_9_hash;
import java.util.LinkedList;
public class LinkedListHash {
	// A Node of chains
		class HashNode {
			Integer key;
			Student value;
			// Constructor
			public HashNode(Integer key, Student value) {
				this.key = key;
				this.value = value;
			}
		}
		
		LinkedList<HashNode>[] A;
//		private double r;
		
		// Constructor
		public LinkedListHash(int capacity)
		{
			A = new LinkedList[capacity];  
			//initialize Array list elements(objects of LinkedList)
			for (int i=0; i<A.length; i++)
			    A[i] = new LinkedList<HashNode>();
			
//			r = Math.random() * A.length;
		}
		// Copy Constructor
		public LinkedListHash(LinkedListHash other)  {
			
			this.A = new LinkedList[other.A.length];
//			this.r = other.r; 
			
			for(int i=0; i<other.A.length; i++) {
				for(int j=0; j<A[i].size(); j++) {
					A[i].add(other.A[i].get(j));
				}
			}
		}
		public void insert(int key, Student value)
		{
			int h = Hash(key);
			
	        // Check if key is already present 
			if(get(key) != null) {
				for(int i=0; i<A[h].size(); i++)
					if(A[h].get(i).key.equals(key))
						A[h].get(i).value = value;
			}
			else {
				A[h].add(new HashNode(key,value));
			}
		}
		public Student get(int key)
		{
			int h = Hash(key);
			for(int i=0; i<A[h].size(); i++)
				if(A[h].get(i).key.equals(key))
					return A[h].get(i).value;
			
	        // If key not found 
			return null;
		}
		public void remove(int key)
		{
			if(get(key) == null) return;
			int h = Hash(key);
			for(int i=0; i<A[h].size(); i++)
				if(A[h].get(i).key.equals(key))
					A[h].remove(i);
			
		}
		private int Hash(int x)
		{
			// return x % a.length;
//			return (int)(x * r) % A.length;	
			return (int)(x) % A.length;	

		}
		public String toString() {
			String s = "";
			for(int i=0; i<A.length; i++) {
				s += i + ": ";
				for(int j=0;j<A[i].size(); j++)
					s += A[i].get(j).value + " -> ";
				s += "null";
				s += "\n";
			}
			return s;
		}
}
