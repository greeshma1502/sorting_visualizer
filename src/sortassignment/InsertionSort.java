package sortassignment;

import java.util.Scanner;

public class InsertionSort extends AbstractSortComponent {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws InterruptedException {

		int a[] = new int[5];
		InsertionSort q = new InsertionSort();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the numbers");

		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();

		}
		in.close();
		long startTime = System.currentTimeMillis();
		q.sort(a);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Time taken is:" + elapsedTime);

	}

	@Override
	public void sort(int[] b) throws InterruptedException {
		for (int j = 1; j < b.length; j++) {
			Thread.sleep(2);
			repaint();
			int i = j - 1;
			int key = b[j];
			while (i >= 0 && b[i] > key) {
				b[i + 1] = b[i];
				i--;
				Thread.sleep(2);
				repaint();

			}
			b[i + 1] = key;
		}

	}

	@Override
	public String sortName() {
		return this.getClass().getName();
	}

	public static void printArray(int b[]) {
		System.out.println("--------- Insertion Sort -------- \n");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
