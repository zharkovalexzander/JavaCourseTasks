package ua.nure.zharkov.Task4;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part1 {

	private static final String FILE_NAME = "part1.txt";

	private int rows;
	private int cols;
	private List<ArrayList<Integer>> matrix;

	public Part1() {
		matrix = new ArrayList<ArrayList<Integer>>();
	}

	public void readFile() {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME), "UTF-8"))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] nums = line.split(" ");
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (String str : nums) {
					temp.add(Integer.parseInt(str));
				}
				matrix.add(temp);
			}
			rows = matrix.size();
			cols = matrix.get(0).size();
		} catch (IOException e) {
			Logger loger = Logger.getLogger(Part1.class.getName());
			loger.log(Level.ALL, "Exception occur", e);
		}
	}

	public int findMaxNonThreadable() throws InterruptedException {
		int value = Integer.MIN_VALUE;
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				int elem = matrix.get(i).get(j);
				Thread.sleep(1);
				if (value < elem) {
					value = elem;
				}
			}
		}
		return value;
	}

	public int findMaxThreadable() throws InterruptedException {
		List<Integer> values = Collections.synchronizedList(new ArrayList<Integer>());
		List<Thread> threads = new ArrayList<Thread>();

		class RowThread extends Thread {
			private int index;
			private List<ArrayList<Integer>> myNums;
			private List<Integer> numers;

			public RowThread(int i, List<ArrayList<Integer>> adder, List<Integer> toadd) {
				index = i;
				myNums = adder;
				numers = toadd;
			}

			@Override
			public void run() {
				try {
					int value = myNums.get(index).get(0);
					for (int i = 1; i < myNums.get(index).size(); ++i) {
						int elem = myNums.get(index).get(i);
						Thread.sleep(1);
						if (value < elem) {
							value = elem;
						}
					}
					numers.add(value);
				} catch (InterruptedException e) {
					Logger loger = Logger.getLogger(Part1.class.getName());
					loger.log(Level.ALL, "Exception occur", e);
				}
			}
		}

		for (int i = 0; i < rows; ++i) {
			Thread thread = new RowThread(i, matrix, values);
			thread.start();
			threads.add(thread);
		}

		for (Thread thread : threads) {
			thread.join();
		}

		Integer toFind = Integer.MIN_VALUE;
		for (Integer element : values) {
			Thread.sleep(1);
			if (toFind < element) {
				toFind = element;
			}
		}
		return toFind;
	}

	public static void main(String[] args) {
		Part1 example = new Part1();
		example.readFile();
		try {
			long startTime1 = System.currentTimeMillis();
			Integer timesecond;
			timesecond = example.findMaxThreadable();
			long stopTime1 = System.currentTimeMillis();
			System.out.println(timesecond);
			System.out.println(stopTime1 - startTime1);
			long startTime = System.currentTimeMillis();
			Integer timefirst = example.findMaxNonThreadable();
			long stopTime = System.currentTimeMillis();
			System.out.println(timefirst);
			System.out.println(stopTime - startTime);
		} catch (InterruptedException e) {
			Logger loger = Logger.getLogger(Part1.class.getName());
			loger.log(Level.ALL, "Exception occur", e);
		}

	}

}
