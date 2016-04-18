package sortassignment;

import java.util.Scanner;

public class BubbleSort extends AbstractSortComponent {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws InterruptedException {
		int a[] = new int[5];
		BubbleSort b = new BubbleSort();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the numbers");

		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();

		}
		in.close();

		b.sort(a);
	}

	public void sort(int[] input) throws InterruptedException {

		setInput(input);
		int n = input.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				Thread.sleep(2);
				repaint();
				if (input[j - 1] > input[j]) {
					temp = input[j - 1];
					input[j - 1] = input[j];
					input[j] = temp;
					Thread.sleep(2);
					repaint();
				}

			}
		}
	}

	@Override
	public String sortName() {
		return this.getClass().getName();
	}

	public static void printArray(int b[]) {
		System.out.println("-------- Bubble Sort ------------\n");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

}
