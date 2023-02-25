package de.tum.in.ase;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class Shopping {
	private final Item[] shoppingList;
	private int bagCapacity;

	public Shopping(Item[] shoppingList, int bagCapacity) {
		this.shoppingList = shoppingList;
		this.bagCapacity = bagCapacity;
	}

	// TODO: implement search(String itemName)

	public int search(String itemName){

		// empty cases
		if (this.shoppingList == null || this.shoppingList.length == 0) {
			return -1;
		}

		// loop to search for string
		int index = -1;
		for (int i = 0 ; i < this.shoppingList.length ; i++) {
			if (shoppingList[i] != null) {
				if (this.shoppingList[i].getName().equals(itemName)) {
					index = i;
					break;
				}
			}

		}
		return index;
	}

	// TODO: implement findMin()

	public int findMin(){
		// empty cases
		if (this.shoppingList == null || this.shoppingList.length == 0){
			return -1;
		}

		//take item at i=0 and compare to each element to find smaller value
		int index = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < shoppingList.length; i++){
			if (shoppingList[i] != null) {
				if (shoppingList[i].getValue() < min){
					min = shoppingList[i].getValue();
					index = i;
				}
			}

		}
		return index;
	}

	// TODO: implement findMax()

	public int findMax(){
		// empty cases
		if (this.shoppingList == null || this.shoppingList.length == 0){
			return -1;
		}


		//take item at i=0 and compare to each element to find bigger value
		int index = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < shoppingList.length; i++){
			if (shoppingList[i] != null) {
				if (shoppingList[i].getValue() >= max){
					max = shoppingList[i].getValue();
					index = i;
				}
			}

		}
		return index;

	}


	// TODO: implement fillBagMax()

	public Item[] fillBagMax(){

		// empty cases
		if (this.shoppingList == null || this.shoppingList.length == 0){
			return null;
		}

		// remove null items
		Item[] removedNull = Arrays.stream(shoppingList)
				.filter(Objects::nonNull
				)
				.toArray(Item[]::new);

		// insertion sort
		Item[] sorted = new Item[removedNull.length];
		for (int i = 0; i<removedNull.length; i++){
			int j = 0;
			while ( j<i && removedNull[i].getValue() > sorted[j].getValue() ){

				j++;
			}
			for ( int k = i-1; k>=j; k--){
				sorted[k+1] = sorted[k];
			}
			sorted[j] = removedNull[i];
		}

		// loop the sorted array to find which items fit in the bag
		int wt = 0;
		List<Integer> indices = new ArrayList<Integer>();

		for (int i = (sorted.length-1) ; i>=0; i--){
			if(bagCapacity >= sorted[i].getWeight() + wt ){
				wt += sorted[i].getWeight();
				indices.add(i);

			}
		}

		// create new array with only the items that fit in the bag
		Item[] solution = new Item[indices.size()];

		for(int i =0; i < indices.size(); i++){
			solution[i]= sorted[indices.get(i)];
		}

		return solution;

	}



	// TODO: implement calValue()

	public int calValue(){

		// empty cases
		if (this.shoppingList == null || this.shoppingList.length == 0){
			return 0;
		}

		// remove null items
		Item[] removedNull = Arrays.stream(this.shoppingList)
				.filter(Objects::nonNull
				)
				.toArray(Item[]::new);

		// insertion sort
		Item[] sorted = new Item[removedNull.length];
		for (int i = 0; i<removedNull.length; i++){
			int j = 0;
			while ( j<i && removedNull[i].getValue() > sorted[j].getValue()){
				j++;
			}
			for ( int k = i-1; k>=j; k--){
				sorted[k+1] = sorted[k];
			}
			sorted[j] = removedNull[i];
		}

		//find which items fit in the bag
		int wt = 0;
		List<Integer> indices = new ArrayList<Integer>();

		for (int i = (sorted.length-1) ; i>=0; i--){
			if(this.bagCapacity >= sorted[i].getWeight() + wt ){
				wt += sorted[i].getWeight();
				indices.add(i);

			}
		}

		// create new array with only the items that fit in the bag
		Item[] solution = new Item[indices.size()];

		for(int i =0; i < indices.size(); i++){
			solution[i]= sorted[indices.get(i)];
		}

		// sum the values of the items
		int value = 0;

		for (Item item : solution) {
			value += item.getValue();
		}

	return value;
	}


	public static void main(String[] args) {
		//you can test your code here by creating your own shopping object

		Item a = new Item("Apple",5,10);
		Item b = new Item("Banana", 1,10);
		Item c = new Item("Cherry", 2,3);
		Item d = new Item("Dye", 3,3);
		Item e = null;
		Item[] list = {a,b,c,d};
		Shopping shop = new Shopping(list,15);

		//Item[] f = shop.fillBagMax();
		//System.out.println(f[0].getName());
		//System.out.println(shop.calValue());
		//System.out.println(shop.findMax());

	}
}
