package sortassignment;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortAnalyser extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private List<AbstractSortComponent> sortingTechniques;

	public SortAnalyser() {

		// Initialize sorting techniques to analyze
		sortingTechniques = new ArrayList<AbstractSortComponent>();

		sortingTechniques.add(new BubbleSort());
		sortingTechniques.add(new InsertionSort());
		sortingTechniques.add(new SelectionSort());
		sortingTechniques.add(new MergeSort());
		sortingTechniques.add(new QuickSort());

	}

	public static void main(String[] args) throws IOException,
			InterruptedException {

		if (args != null && args.length > 0) {
			String fileName = args[0];

			// Initialize dataSet Generator
			GenerateDataSets generateDataSets = new GenerateDataSets();
			SortAnalyser sortAnalyser = new SortAnalyser();
			List<Integer> weights = new ArrayList();
			weights.add(1);

			for (Integer integer : weights) {
				for (AbstractSortComponent sort : sortAnalyser.sortingTechniques) {

					generateDataSets.generateDateSets(
							GenerateDataSets.DataSetTypes.RANDOM, fileName, 16);

					File file = new File(fileName);

					Scanner scanner = null;
					List<Integer> input = new ArrayList<Integer>();
					try {
						scanner = new Scanner(file);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

					while (scanner.hasNext()) {
						input.add(Integer.parseInt(scanner.next()));
					}

					int[] sortInput = convertIntegers(input);

					long startTime = System.currentTimeMillis();

					sort.setInput(sortInput);
					System.out.println("Weight" + integer
							+ "--- Starting ---- : " + sort.sortName() + "\n");

					sortVisualizer(sort);

					long endTime = System.currentTimeMillis();
					long userMemoryAfterSort = usedMem();

					printSortingTime(endTime - startTime);
					printMemoryUsage(userMemoryAfterSort);
				}
			}
		}

	}

	public static int[] convertIntegers(List<Integer> integers) {
		int[] ret = new int[integers.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = integers.get(i).intValue();
		}
		return ret;
	}

	public static void printListOfIntegers(List<Integer> output) {
		for (Integer next : output) {
			System.out.println(next);
		}
	}

	public static long usedMem() {
		return Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
	}

	public static void printSortingTime(long timeInMilliSeconds) {

		System.out.print(String.valueOf(timeInMilliSeconds) + "\n");

	}

	public static void printMemoryUsage(long bytes) {

		System.out.print(String.valueOf(bytes / 1024) + "\n");

	}

	public static void sortVisualizer(AbstractSortComponent sort) {
		JFrame application = new JFrame();

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(sort);
		application.setTitle(sort.sortName());
		application.setBackground(Color.lightGray);

		application.setSize(500, 500);
		application.setVisible(true);

		sort.run();
	}

}
