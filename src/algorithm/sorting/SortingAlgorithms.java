/**
 * 
 */
package algorithm.sorting;
import java.util.Arrays;
import java.util.Random;
/**
 * @author shen
 *
 */
public class SortingAlgorithms {
	/**
	 * worst O(N^2) comparisons, O(N^2) swaps, O(N^2) time
	 * best O(N) comparisons, O(1) swaps, O(N) time
	 * average O(N^2) comparisons, O(N^2) swaps, O(N^2) time
	 * worst O(N) total, O(1) auxiliary space
	 * @param a array
	 */
	public static void bubbleSort(int[] a){
		int i,j,len=a.length;
		int tmp;
		for(i = 0; i<len-1;++i){
			for(j=0;j<len-1-i;++j){
				if(a[j]>a[j+1]){
					tmp = a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
//					System.out.println(Arrays.toString(a));
				}
			}
		}
	}
	
	/**
	 * worst O(N^2) comparisons, O(N^2) swaps, O(N^2) time
	 * best O(N) comparisons, O(1) swaps, O(N) time
	 * average O(N^2) comparisons, O(N^2) swaps, O(N^2) time
	 * worst O(N) total, O(1) auxiliary space
	 * @param a array
	 * @return sorted array
	 */
	public static void insertionSort(int[] a){
		int j,len=a.length;
		int tmp;
		for(int p = 1; p < len; ++p){
			tmp = a[p];
			for(j=p;j>0&&tmp<a[j-1];--j)
				a[j]=a[j-1];
			a[j]=tmp;
//			System.out.println(Arrays.toString(a));
		}
	}
	/**
	 * worst O(N^2) time
	 * best O(NlogN) time
	 * average depends on the gap sequence
	 * worst O(N) total, O(1) auxiliary space
	 * @param a array
	 */
	public static void shellSort(int[] a){
		int j;
		int tmp;
		for(int gap = a.length >>> 1;gap>0;gap>>>=1){
			for(int i = gap; i < a.length;++i){
				tmp = a[i];
				for(j=i;j>=gap&&tmp<a[j-gap];j-=gap)
					a[j]=a[j-gap];
				a[j]=tmp;
			}
//			System.out.println(Arrays.toString(a));
		}
	}
	/**
	 * average O(NlogN) time,
	 * worst O(NlogN) time,
	 * best O(NlogN) time,
	 * worst O(N) total, O(1) auxiliary space (temporary variable)
	 * @param a array
	 */
	public static void heapSort(int[] a){
		// build heap
        for( int i = (a.length >>> 1) - 1; i >= 0; i-- )  // length/2-1 important !!
            percDown( a, i, a.length );
        // delete
        int tmp;
        for( int i = a.length - 1; i > 0; i-- )
        {
        	tmp = a[0];
        	a[0] = a[i];
        	a[i] = tmp;
            percDown( a, 0, i );
        }
	}
	
	/**
	 * 
	 * @param a array
	 * @param i index
	 * @param n length
	 */
	private static void percDown(int[] a, int i, int n){
        int child;
        int tmp;
        for( tmp = a[ i ]; leftChild( i ) < n; i = child )
        {
            child = leftChild( i );
            // compare left child and right child
            if( child != n - 1 && a[ child ]< a[ child + 1 ]  )
                child++;
            if( tmp<a[child])
                a[i] = a[child];
            else
                break;
        }
        a[ i ] = tmp;
	}

	private static int leftChild(int i) {
		return 2*i+1;
	}
	
	public static void mergeSort(int[] a){
		// TODO merge sort
	}
	
	private static void mergeSort(int[] a, int[] tmpArray, int left, int right ){
		// TODO merge sort
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int LEN = 1000;
		long startTime,endTime;
		int[] arr = new int[LEN];
		int[] tmp;
		Random rand = new Random();
		for(int i = 0 ; i < LEN ; ++i )
			arr[i] = rand.nextInt(1000);
		tmp = arr.clone();
		startTime = System.nanoTime();
		bubbleSort(tmp);
		endTime = System.nanoTime();
//		System.out.println(Arrays.toString(tmp));
		System.out.println((endTime-startTime)/1000.0+"microseconds");
		tmp = arr.clone();
		startTime = System.nanoTime();
		insertionSort(tmp);
		endTime = System.nanoTime();
//		System.out.println(Arrays.toString(tmp));
		System.out.println((endTime-startTime)/1000.0+"microseconds");
		tmp = arr.clone();
		startTime = System.nanoTime();
		shellSort(tmp);
		endTime = System.nanoTime();
//		System.out.println(Arrays.toString(tmp));
		System.out.println((endTime-startTime)/1000.0+"microseconds");
		tmp = arr.clone();
		startTime = System.nanoTime();
		heapSort(tmp);
		endTime = System.nanoTime();
//		System.out.println(Arrays.toString(tmp));
		System.out.println((endTime-startTime)/1000.0+"microseconds");


	}

}
