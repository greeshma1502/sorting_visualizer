package sortassignment;

import java.util.Scanner;

public class QuickSort extends AbstractSortComponent {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws InterruptedException {
		int a[] = new int[8];
		QuickSort q = new QuickSort();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the numbers");

		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();

		}
		in.close();

		q.sort(a);

	}

	@Override
	public void sort(int[] input) throws InterruptedException {
		int low = 0;
		int high = input.length - 1;
		quickSort(input, low, high);
		
	}

	public void quickSort(int[] b, int low, int high)
			throws InterruptedException {
		Thread.sleep(2);
		repaint();

		if (b == null || b.length == 0)
			return;

		if (low >= high)
			return;

		int middle = low + (high - low) / 2;
		int pivot = b[middle];

		int i = low, j = high;
		Thread.sleep(2);
		repaint();
		while (i <= j) {
			Thread.sleep(5);
			repaint();
			while (b[i] < pivot) {
				i++;
				Thread.sleep(2);
				repaint();
			}

			while (b[j] > pivot) {
				j--;
				Thread.sleep(2);
				repaint();
			}

			if (i <= j) {
				int temp = b[i];
				b[i] = b[j];
				b[j] = temp;
				i++;
				j--;
				Thread.sleep(2);
				repaint();
			}
		}

		if (low < j) {
			Thread.sleep(2);
			repaint();
			quickSort(b, low, j);

		}

		if (high > i) {
			Thread.sleep(2);
			repaint();
			quickSort(b, i, high);

		}

	}

	@Override
	public String sortName() {
		return this.getClass().getName();
	}

	public static void printArray(int b[]) {
		System.out.println("-------- Quick Sort ------------\n");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
