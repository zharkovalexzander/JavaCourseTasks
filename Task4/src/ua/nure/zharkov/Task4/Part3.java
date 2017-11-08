package ua.nure.zharkov.Task4;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part3 {

	private static final int PAUSER = 1;
	private static final String LS = System.lineSeparator();
	private static final String FILE_NAME = "part3.txt";
	private static final int N = 20;
	private static final int K = 10;
	private static final int LEN = 20 + LS.length();
	private List<Thread> threads;
	private RandomAccessFile randomFile;

	public Part3() throws IOException {
		threads = new ArrayList<Thread>();
		prepareFile();
	}

	static class ThreadWriter extends Thread {
		private RandomAccessFile threadRandomFile;
		private long index;

		public ThreadWriter(RandomAccessFile ran, long i) {
			index = i;
			threadRandomFile = ran;
		}

		@Override
		public void run() {
			synchronized (threadRandomFile) {
				try {
					threadRandomFile.seek(index * LEN);
					for (int i = 0; i < N; ++i) {
						threadRandomFile.write('0' + (int) index);
						Thread.sleep(PAUSER);
					}
					threadRandomFile.writeBytes(LS);
				} catch (InterruptedException | IOException e) {
					Logger loger = Logger.getLogger(Part3.class.getName());
					loger.log(Level.ALL, "Exception occur", e);
				}
			}
		}
	}

	public void start() throws InterruptedException, IOException {
		for (int i = 0; i < K; ++i) {
			Thread thread = new ThreadWriter(randomFile, i);
			thread.start();
			threads.add(thread);
		}

		for (Thread thread : threads) {
			thread.join();
		}

	}

	private void prepareFile() throws IOException {
		if (!new File(FILE_NAME).delete()) {
			Logger loger = Logger.getLogger(Part3.class.getName());
			loger.log(Level.ALL, "File was not found. Creating.");
		}
		randomFile = new RandomAccessFile(new File(FILE_NAME), "rw");
	}

	public static void main(String[] args) {
		try {
			Part3 example = new Part3();
			example.start();
			try (BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream("part3.txt"), "UTF-8"))) {
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				Logger loger = Logger.getLogger(Part3.class.getName());
				loger.log(Level.ALL, "Exception occur", e);
			}
		} catch (IOException | InterruptedException e) {
			Logger loger = Logger.getLogger(Part3.class.getName());
			loger.log(Level.ALL, "Exception occur", e);
		}
	}

}
