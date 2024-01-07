package Algorithm_Analysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main
{
	static ArrayList<Long> timesInsertion = new ArrayList<Long>();
	static ArrayList<Integer> comparetionInsertion = new ArrayList<Integer>();
	static ArrayList<Long> timesMerge = new ArrayList<Long>();
	static ArrayList<Integer> comparetionMerge = new ArrayList<Integer>();
	static ArrayList<Long> timesQuickSelect = new ArrayList<Long>();
	static ArrayList<Integer> comparetionQuickSelect = new ArrayList<Integer>();
	static ArrayList<Long> timesMedian = new ArrayList<Long>();
	static ArrayList<Integer> comparetionMedian = new ArrayList<Integer>();
	static ArrayList<Integer> size = new ArrayList<Integer>();
	static ArrayList<Long> timesMaxHeap = new ArrayList<Long>();
	static ArrayList<Integer> comparetionMaxHeap = new ArrayList<Integer>();
	public static int counter = 1000;
	public static void main(String[] args)
	{
		for (int f = 1000; f <= 100000; f += 5000)
		{
			calculation(f);
		    size.add(f);
		}
		 generateStatistic();

	}

	public static void calculation(int a)
	{
		int arr[] = RandomArray(a);
		// int arr[] = Ascending(a);
		// int arr[] = Descending(a);
		// int arr[] = Same(a);
		// printArray(arr);

		// System.out.println("\n");

		int Insertation[] = arr.clone();
		int Merge[] = arr.clone();
		int QuickSelectPartitioning[] = arr.clone();
		int MedianOfThree[] = arr.clone();
		int MaxHeap[] = arr.clone();
		double startTime;
		double finishTime;
		double time;
		printFile(arr);

		startTime = System.nanoTime();

		insertationSort(Insertation, Insertation.length / 2);
		Insertation = arr.clone();

		finishTime = System.nanoTime();
		time = finishTime - startTime;
		timesInsertion.add((long) time);

		// --------------------------------------------------------------------------------
		startTime = System.nanoTime();

		mergeSort(Insertation, Merge.length / 2);
		Merge = arr.clone();

		finishTime = System.nanoTime();
		time = finishTime - startTime;
		timesMerge.add((long) time);

		// --------------------------------------------------------------------------------
		MaxHeap maxHeap = new MaxHeap(a);
		for (int i = 0; i < MaxHeap.length; i++)
		{
			maxHeap.insert(MaxHeap[i]);

		}

		int n = MaxHeap.length;

		startTime = System.nanoTime();

		for (int j = 0; j < Math.floor(MaxHeap.length / 2); j++)
		{
			maxHeap.extractMax();
		}

		finishTime = System.nanoTime();
		time = finishTime - startTime;

		timesMaxHeap.add((long) time);
		comparetionMaxHeap.add(maxHeap.counterMaxHeap);

		maxHeap.counterMaxHeap = 0;
		// --------------------------------------------------------------------------------
		startTime = System.nanoTime();
		
		Sort.findMedian(QuickSelectPartitioning,QuickSelectPartitioning.length / 2);
		QuickSelectPartitioning = arr.clone();

		finishTime = System.nanoTime();
		time = finishTime - startTime;
		timesQuickSelect.add((long) time);

		// --------------------------------------------------------------------------------
		startTime = System.nanoTime();

		Sort.findMedian3(MedianOfThree, MedianOfThree.length / 2);
		MedianOfThree = arr.clone();

		finishTime = System.nanoTime();
		time = finishTime - startTime;
		timesMedian.add((long) time);

	}
	public static int mergeSort(int[] array, int n)
	{
		return Sort.Mergesort(array, 0, array.length - 1, n);
	}

	public static int insertationSort(int[] array, int k)
	{
		return Sort.InsertationSort(array, k);
	}

	public static int[] RandomArray(int length)
	{
		int arr[] = new int[length];
		Random randNumGenerator = new Random();
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (randNumGenerator.nextInt(length));
		}
		return arr;
	}

	public static int[] Ascending(int length)
	{
		int arr[] = new int[length];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = i;
		}
		return arr;
	}

	public static int[] Descending(int length)
	{
		int arr[] = new int[length];
		int y = arr.length;
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = y;
			y--;
		}
		return arr;
	}

	public static int[] Same(int length)
	{
		int arr[] = new int[length];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = 1;
		}
		return arr;
	}

	public static void printArray(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (i % 10 == 0)
			{
				System.out.println("");
			}
			System.out.print(arr[i] + " ");
		}
	}

	public static String returnPrint(int[] arr)
	{
		String print = "";
		for (int i = 0; i < arr.length; i++)
		{
			print += (arr[i] + "-") + "";
		}
		return print;
	}

	public static void writeToFile(String url, String text)
	{
		try
		{
			File file = new File(url);
			if (!file.exists())
				file.createNewFile();
			PrintWriter writer = new PrintWriter(url, "UTF-8");
			writer.println(text);
			writer.close();

		} catch (IOException e)
		{
			System.err.println("The text cannot printed to txt file!");
		}
	}

	public static void printFile(int[] arr)
	{
		String input = returnPrint(arr);
		writeToFile("C:/Users/ElburuzGurbuz/Desktop/HW2_txt/"
				+ "Random_Order_Array_Size_" + counter + ".txt", input);
		counter += 5000;
	}

	public static void generateStatistic()
	{
		// --------------------------------------------------------------------------------
		String Insert = "";
		Insert += "Time";
		for (int y = 0; y < timesInsertion.size(); y++)
		{
			Insert += "\n" + timesInsertion.get(y) / 10000 * (0.001);
		}
		writeToFile("C:/Users/ElburuzGurbuz/Desktop/HW2_txt/Insert.txt",
				Insert);
		// --------------------------------------------------------------------------------
		String MaxHeap = "";
		MaxHeap += "Time";
		for (int y = 0; y < timesMaxHeap.size(); y++)
		{
			MaxHeap += "\n" + timesMaxHeap.get(y) / 10000 * (0.001);
		}
		writeToFile("C:/Users/ElburuzGurbuz/Desktop/HW2_txt/MaxHeap.txt",
				MaxHeap);
		// --------------------------------------------------------------------------------
		String Merge = "";
		Merge += "Time";

		for (int y = 0; y < timesMerge.size(); y++)
		{
			Merge += "\n" + timesMerge.get(y) / 10000 * (0.001);
		}
		writeToFile("C:/Users/ElburuzGurbuz/Desktop/HW2_txt/Merge.txt", Merge);
		// --------------------------------------------------------------------------------
		String Quick = "";
		Quick += "Time";

		for (int y = 0; y < timesQuickSelect.size(); y++)
		{
			Quick += "\n" + timesQuickSelect.get(y) / 10000 * (0.001);
		}
		writeToFile("C:/Users/ElburuzGurbuz/Desktop/HW2_txt/Quick.txt", Quick);
		// --------------------------------------------------------------------------------
		String Median = "";
		Median += "Time";

		for (int y = 0; y < timesMedian.size(); y++)
		{
			Median += "\n" + timesMedian.get(y) / 10000 * (0.001);
		}
		writeToFile("C:/Users/ElburuzGurbuz/Desktop/HW2_txt/Median.txt",
				Median);
		// --------------------------------------------------------------------------------
	}

}
