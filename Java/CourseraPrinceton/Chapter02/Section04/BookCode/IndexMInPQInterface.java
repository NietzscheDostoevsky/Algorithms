public interface IndexMinPQInterface<Item extends Comparable<Item>> {
	// Index Priority Queue 

	/*	Index priority queue. 
		In many applications, it makes sense to allow clients to refer
		to items that are already on the priority queue. 
		One easy way to do so is to associate
		a unique integer index with each item. 
		Moreover, it is often the case that clients have
		a universe of items of a known size N and 
		perhaps are using (parallel) arrays to store
		information about the items, 
		so other unrelated client code might already be using an
		integer index to refer to items
	*/


	/*
	* Implementing class to provide folloing constructor 
	* IndexMinPQ(int maxN){
		// create a priority queue of capacity maxN with possible
		// indices between 0 and maxN -1
		}
	*/

	// insert item, associate it with k
	void insert(int k, Item item); 

	// change the item associated with k to item
	void change(int k, Item item); 

	// is k associated with some item
	boolean contains(int k); 

	// 
}