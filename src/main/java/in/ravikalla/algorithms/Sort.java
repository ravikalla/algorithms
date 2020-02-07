package in.ravikalla.algorithms;

import org.apache.commons.lang3.time.StopWatch;

public class Sort {
	public static void main(String[] args) {
		StopWatch watch = new StopWatch();

		int arrBubbleSort[] = {3, 5, 2, 4, 1};
		watch.start();
		bubbleSort(arrBubbleSort);
		watch.stop();
		System.out.println("ElapsedTime for BubbleSort : " + watch.getTime());
		print(arrBubbleSort);

		watch.reset();

		int arrQuickSort[] = {3, 5, 2, 4, 1};
		watch.start();
		quickSort(arrQuickSort, 0, arrQuickSort.length - 1);
		watch.stop();
		System.out.println("ElapsedTime for Quick Sort : " + watch.getTime());
		print(arrQuickSort);
	}

	private static void quickSort(int[] arr, int start, int end) {
		int temp;
		int startLocal = start;
		int endLocal = end;
		int pivot = arr[start + (end - start)/2];
		while (startLocal <= endLocal) {
			while (arr[startLocal] < pivot)
				startLocal++;
			while (arr[endLocal] > pivot)
				endLocal--;
			if (startLocal <= endLocal) {
				temp = arr[startLocal];
				arr[startLocal] = arr[endLocal];
				arr[endLocal] = temp;

				startLocal++;
				endLocal--;
			}
		}

		if (start < endLocal)
			quickSort(arr, start, endLocal);
		if (startLocal < end)
			quickSort(arr, startLocal, end);
	}

	private static void bubbleSort(int[] arr) {
		int temp;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	private static void print(int[] arrBubbleSorted) {
		for (int i = 0; i < arrBubbleSorted.length; i++) {
			System.out.print(" : " + arrBubbleSorted[i]);
		}
		System.out.println("");
	}
 }
