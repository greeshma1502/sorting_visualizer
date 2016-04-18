package sortassignment;

import java.util.Scanner;

public class SelectionSort extends AbstractSortComponent {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws InterruptedException {
		int a[] = new int[5];
		SelectionSort s = new SelectionSort();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the numbers");

		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();

		}
		in.close();

		s.sort(a);

	}

	public void sort(int[] b) throws InterruptedException {
		int min = 0;
		int temp = 0;
		for (int j = 0; j < b.length - 1; j++) {
			Thread.sleep(2);
			repaint();
			min = j;
			for (int i = j + 1; i < b.length; i++) {
				if (b[min] > b[i]) {
					min = i;
				}
				Thread.sleep(2);
				repaint();
			}

			if (b[min] != b[j]) {
				temp = b[j];
				b[j] = b[min];
				b[min] = temp;
				Thread.sleep(2);
				repaint();
			}
		}

	}

	@Override
	public String sortName() {
		return this.getClass().getName();
	}

	public static void printArray(int b[]) {
		System.out.println("------ Selection Sort ------------- \n");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

}
