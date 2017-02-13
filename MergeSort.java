//Maria Acuna
//APCS2 pd3
//HW06 -- Step 1: Split.  Step 2: ?.  Step 3: Sorted.
//2017-02-11

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 

  Merge Sort

  1.	Take list, split it in two.  Hand those two smaller lists to other computars
  2.	If the list is one element long, hand it back to the person who gave it to you.  This is because a one element list is always sorted.
  3.	Merge the sorted lists that are handed back to you into one sorted list. To do this, first check the first element of each list, and make the smaller one the first element of the new sorted list.  Continue until all the cards are sorted, then hand it back to the person who gave you the list.
  4.	Repeat until you get one sorted list!!! Yea!!!!

  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	//declaring variables
	int alength = a.length;
	int blength = b.length;
	int clength = a.length + b.length;
	int[] c = new int[clength];
	//checks if last element in list a is greater than the last element in list b.
	//if so, it adds the element to the last index of list c.
	//decrements.
	for(int x = clength; x > 0; x --){
	    if(alength <= 0){
		c[x-1] = b[blength-1];
		blength--;
	    }
	    else if(blength <= 0){
		c[x-1] = a[alength-1];
		alength--;
	    }
	    else if(a[alength-1] >= b[blength-1]){
		c[x-1] = a[alength-1];
		alength --;
	    }
	    else{
		c[x-1] = b[blength-1];
		blength--;
	    }
	}
	return c;

    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	//a list of length 1 is always sorted.
	if(arr.length <= 1){
	    return arr;
	}
	//ha -> shorter list of the two the original list is split into.
	//lf -> larger list of the two the original list is split into.
	int[] ha = new int[arr.length/2];
	int[] lf = new int[arr.length-ha.length];
	//splits the array in half and places half of its elements in ha and half in lf.
	for(int thing = arr.length-1; thing >= 0; thing--){
	    if(thing < ha.length){
		ha[thing]=arr[thing];
	    }
	    else{
		lf[thing-ha.length]=arr[thing];
		    }
	}
	return merge(sort(ha), sort(lf));
	
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr2 and arr4: ");
	printArray( merge(arr2,arr4) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
    }//end main()

}//end class MergeSort

