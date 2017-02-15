/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>
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
  BIG-OH CLASSIFICATION OF ALGORITHM:
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

    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/
    public static void main( String[] args ) 
    {

    }//end main

}//end class
