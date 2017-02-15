/*======================================
  class MergeSortTester
  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>
      
  Merge Sort
  1.	Take list, split it in two.  Hand those two smaller lists to other computars
  2.	If the list is one element long, hand it back to the person who gave it to you.  This is because a one element list is always sorted.
  3.	Merge the sorted lists that are handed back to you into one sorted list. To do this, first check the first element of each list, and make the smaller one the first element of the new sorted list.  Continue until all the cards are sorted, then hand it back to the person who gave you the list.
  4.	Repeat until you get one sorted list!!! Yea!!!!   
 
 
  -----------------------------------------------------------------

  BIG-OH CLASSIFICATION OF ALGORITHM:
  MergeSort runs in N log(N) time. An array of n elements will need to be subdivided into arrays of half its size, and this will take log(N) time (Since its how many powers of 2 go into n).
  Next the array will have to be reassembled. Assuming the computar just starts placing from the other array once runs out (since they're both individually sorted), the worst case scenario has you making 1 comparison to return an array of size 2, 3 comparison to return an array of size 4, etc. The amount of comparisons you end up making relies on n.

  log n splits followed by n comparisons gives an n log n runtime.

  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester 
{
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
    
    public static void populate(int []  a){
 int al = a.length;
 for (int i = 0; i < al; i++){
     a[i] = (int) Math.random() * 101;
 }
    }
    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...
     *  Taking System.nanoTime() before and after calling a merge sort operation.
     ******************************/
    public static void main( String[] args ) 
    {
	//==================================================================
	//n = 1
	//=================================================================
	System.out.println("n=1");
       	int[] n1 ={1};
	//1 run
       	long startTime = System.nanoTime();
	sort(n1);
       	long endTime = System.nanoTime();
       	System.out.println("The average time for 1 run is " + (endTime - startTime) + " nanoseconds. There was 1 run.");	
	//10 runs
	startTime=System.nanoTime();
	for(int i = 0;i<10;i++){
	    sort(n1);
	}
	endTime=System.nanoTime();
	System.out.println("The average time for 1 run is " +( (endTime - startTime)/10) + " nanoseconds. There were 10 runs.");
	//100 runs
	startTime=System.nanoTime();
	for(int i = 0;i<100;i++){
	    sort(n1);
	}
	endTime=System.nanoTime();
	System.out.println("The average time for 1 run is " + ( (endTime - startTime)/100) + " nanoseconds. There were 100 runs.");
	//1000 runs
	startTime=System.nanoTime();
	for(int i = 0;i<1000;i++){
	    sort(n1);
	}
	endTime=System.nanoTime();
	System.out.println("The average time for 1 run is " + ( (endTime - startTime)/1000) + " nanoseconds. There were 1000 runs.");
	System.out.println("------------------------------------------");

	//=============================================================================

	//==================================================================
	//n = 10
	//=================================================================
	System.out.println("n=10");
       	int[] n10 ={1,7,3,8,6,4,9,21,2,14};
	//1 run
        startTime = System.nanoTime();
	sort(n10);
        endTime = System.nanoTime();
       	System.out.println("The average time for 1 run is " + (endTime - startTime) + " nanoseconds. There was 1 run.");	
	//10 runs
	startTime=System.nanoTime();
	for(int i = 0;i<10;i++){
	    sort(n10);
	}
	endTime=System.nanoTime();
	System.out.println("The average time for 1 run is " +( (endTime - startTime)/10) + " nanoseconds. There were 10 runs.");
	//100 runs
	startTime=System.nanoTime();
	for(int i = 0;i<100;i++){
	    sort(n10);
	}
	endTime=System.nanoTime();
	System.out.println("The average time for 1 run is " + ( (endTime - startTime)/100) + " nanoseconds. There were 100 runs.");
	//1000 runs
	startTime=System.nanoTime();
	for(int i = 0;i<1000;i++){
	    sort(n10);
	}
	endTime=System.nanoTime();
	System.out.println("The average time for 1 run is " + ( (endTime - startTime)/1000) + " nanoseconds. There were 1000 runs.");
	System.out.println("------------------------------------------");

	//=============================================================================

	//==================================================================
	//n = 100
	//=================================================================
	System.out.println("n=10");
       	int[] n100 = new int[100];
	populate(n100);
	//1 run
        startTime = System.nanoTime();
	sort(n100);
        endTime = System.nanoTime();
       	System.out.println("The average time for 1 run is " + (endTime - startTime) + " nanoseconds. There was 1 run.");	
	//10 runs
	startTime=System.nanoTime();
	for(int i = 0;i<10;i++){
	    sort(n100);
	}
	endTime=System.nanoTime();
	System.out.println("The average time for 1 run is " +( (endTime - startTime)/10) + " nanoseconds. There were 10 runs.");
	//100 runs
	startTime=System.nanoTime();
	for(int i = 0;i<100;i++){
	    sort(n100);
	}
	endTime=System.nanoTime();
	System.out.println("The average time for 1 run is " + ( (endTime - startTime)/100) + " nanoseconds. There were 100 runs.");
	//1000 runs
	startTime=System.nanoTime();
	for(int i = 0;i<1000;i++){
	    sort(n100);
	}
	endTime=System.nanoTime();
	System.out.println("The average time for 1 run is " + ( (endTime - startTime)/1000) + " nanoseconds. There were 1000 runs.");
	System.out.println("------------------------------------------");

	//=============================================================================

       	//==================================================================
	//n = 1000
	//=================================================================
	System.out.println("n=1000");
       	int[] n1000 = new int[1000];
	populate(n1000);
	//1 run
        startTime = System.nanoTime();
	sort(n1000);
        endTime = System.nanoTime();
       	System.out.println("The average time for 1 run is " + (endTime - startTime) + " nanoseconds. There was 1 run.");	
	//10 runs
	startTime=System.nanoTime();
	for(int i = 0;i<10;i++){
	    sort(n1000);
	}
	endTime=System.nanoTime();
	System.out.println("The average time for 1 run is " +( (endTime - startTime)/10) + " nanoseconds. There were 10 runs.");
	//100 runs
	startTime=System.nanoTime();
	for(int i = 0;i<100;i++){
	    sort(n1000);
	}
	endTime=System.nanoTime();
	System.out.println("The average time for 1 run is " + ( (endTime - startTime)/100) + " nanoseconds. There were 100 runs.");
	//1000 runs
	startTime=System.nanoTime();
	for(int i = 0;i<1000;i++){
	    sort(n1000);
	}
	endTime=System.nanoTime();
	System.out.println("The average time for 1 run is " + ( (endTime - startTime)/1000) + " nanoseconds. There were 1000 runs.");
	System.out.println("------------------------------------------");

	//=============================================================================
    }//end main

}//end class
