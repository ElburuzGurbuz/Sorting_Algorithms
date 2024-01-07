package Algorithm_Analysis;

public class Sort extends main
{

	//public static int counter = 0;

	static int InsertationSort(int arr[], int k)
	{
		int n = arr.length;
		for (int i = 1; i < n; ++i)
		{
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one
			 * position ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) 
			{
				;
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return arr[k];

	}

	static void merge(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2)
		{
			if (L[i] <= R[j])
			{
				arr[k] = L[i];
				i++;
			} else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1)
		{
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2)
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	static int Mergesort(int arr[], int l, int r, int k)
	{
		if (l < r)
		{
			// Find the middle point
			int m = (l + r) / 2;
			;
			// Sort first and second halves
			Mergesort(arr, l, m, k);
			Mergesort(arr, m + 1, r, k);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
		return arr[k];
	}
	
	static int a, b; 
	  
    // Utility function to swapping of element 
    static int[] swap(int[] arr, int i, int j) 
    { 
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
        return arr; 
    } 
  
    // Returns the correct position of 
    // pivot element 
    static int Partition(int arr[], int l, int r) 
    { 
        int lst = arr[r], i = l, j = l; 
        while (j < r)  
        { 
            if (arr[j] < lst) 
            { 
                arr = swap(arr, i, j); 
                i++; 
            } 
            j++; 
        } 
        arr = swap(arr, i, r); 
        return i; 
    } 
  
    // Picks a random pivot element between 
    // l and r and partitions arr[l..r] 
    // around the randomly picked element 
    // using partition() 
    static int randomPartition(int arr[], int l, int r) 
    { 
        int n = r - l + 1; 
        int pivot = (int) (Math.random() % n); 
        arr = swap(arr, l + pivot, r); 
        return Partition(arr, l, r); 
    } 
  
    // Utility function to find median 
    static int MedianUtil(int arr[], int l, int r, int k)  
    { 
  
        // if l < r 
        if (l <= r)  
        { 
  
            // Find the partition index 
            int partitionIndex = l; 
            ;
            // If partion index = k, then 
            // we found the median of odd 
            // number element in arr[] 
            if (partitionIndex == k) 
            { 
                b = arr[partitionIndex]; 
                if (a != -1) 
                    return Integer.MIN_VALUE; 
            } 
  
            // If index = k - 1, then we get 
            // a & b as middle element of 
            // arr[] 
            else if (partitionIndex == k - 1) 
            { 
                a = arr[partitionIndex]; 
                if (b != -1) 
                    return Integer.MIN_VALUE; 
            } 
  
            // If partitionIndex >= k then 
            // find the index in first half 
            // of the arr[] 
            if (partitionIndex >= k) 
                return MedianUtil(arr, l, partitionIndex - 1, k); 
  
            // If partitionIndex <= k then 
            // find the index in second half 
            // of the arr[] 
            else
                return MedianUtil(arr, partitionIndex + 1, r, k); 
        } 
  
        return Integer.MIN_VALUE; 
    } 
    
    static int MedianUtil3(int arr[], int l, int r, int k)  
    { 
  
        // if l < r 
        if (l <= r)  
        { 
  
            // Find the partition index 
            int partitionIndex = medianOf3(arr, l, r); 
            ;
            // If partion index = k, then 
            // we found the median of odd 
            // number element in arr[] 
            if (partitionIndex == k) 
            { 
                b = arr[partitionIndex]; 
                if (a != -1) 
                    return Integer.MIN_VALUE; 
            } 
  
            // If index = k - 1, then we get 
            // a & b as middle element of 
            // arr[] 
            else if (partitionIndex == k - 1) 
            { 
                a = arr[partitionIndex]; 
                if (b != -1) 
                    return Integer.MIN_VALUE; 
            } 
  
            // If partitionIndex >= k then 
            // find the index in first half 
            // of the arr[] 
            if (partitionIndex >= k) 
                return MedianUtil(arr, l, partitionIndex - 1, k); 
  
            // If partitionIndex <= k then 
            // find the index in second half 
            // of the arr[] 
            else
                return MedianUtil(arr, partitionIndex + 1, r, k); 
        } 
  
        return Integer.MIN_VALUE; 
    } 
  
    // Function to find Median 
    static void findMedian(int arr[], int n) 
    { 
        int ans; 
        a = -1; 
        b = -1; 
  
        // If n is odd 
        if (n % 2 == 1)  
        { 
            MedianUtil(arr, 0, n - 1, n / 2); 
            ans = b; 
        } 
  
        // If n is even 
        else 
        { 
            MedianUtil(arr, 0, n - 1, n / 2); 
            ans = (a + b) / 2; 
        } 
  
        // Print the Median of arr[] 
        //System.out.print("Median = " + ans); 
    } 
    
    static void findMedian3(int arr[], int n) 
    { 
        int ans; 
        a = -1; 
        b = -1; 
  
        // If n is odd 
        if (n % 2 == 1)  
        { 
            MedianUtil3(arr, 0, n - 1, n / 2); 
            ans = b; 
        } 
  
        // If n is even 
        else 
        { 
            MedianUtil3(arr, 0, n - 1, n / 2); 
            ans = (a + b) / 2; 
        } 
  
        // Print the Median of arr[] 
        //System.out.print("Median = " + ans); 
    } 

	public static int medianOf3(int[] intArray, int left, int right)
	{
		int center = (left + right) / 2;

		if (intArray[left] > intArray[center])
		{
			swap(intArray, left, center);
			;
		}
		if (intArray[left] > intArray[right])
		{
			swap(intArray, left, right);
			;
		}
		if (intArray[center] > intArray[right])
		{
			swap(intArray, center, right);
			;
		}
		swap(intArray, center, right - 1);
		return intArray[right - 1]; 
	}

	public static int partitionIt(int[] intArray, int left, int right,int pivot)
	{
		int leftPtr = left;
		int rightPtr = right - 1;

		while (true)
		{
			while (intArray[++leftPtr] < pivot);
			while (intArray[--rightPtr] > pivot);
			if (leftPtr >= rightPtr)
				break;
			else
				swap(intArray, leftPtr, rightPtr);
		}
		swap(intArray, leftPtr, right - 1);
		return leftPtr;
	}

	public static void manualSort(int[] intArray, int left, int right)
	{
		;
		int size = right - left + 1;
		if (size <= 1)
		{
			;
			return;
		}
		if (size == 2)
		{
			if (intArray[left] > intArray[right])
				swap(intArray, left, right);
			
			;
			return;
		} 
		else
		{
			;
			if (intArray[left] > intArray[right - 1])
				swap(intArray, left, right - 1);
			
			if (intArray[left] > intArray[right])
				;
			
			swap(intArray, left, right);
			
			if (intArray[right - 1] > intArray[right])
				;
			
			swap(intArray, right - 1, right);
		}
	}

}
