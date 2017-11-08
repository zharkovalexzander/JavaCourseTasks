package ua.nure.zharkov.Task4;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part2 {

	private static final InputStream STD_IN = System.in;

	public static void main(String[] args) {
		Thread thread = new Thread() {
			public void run() {
				try {
					Spam.main(new String[] {});
				} catch (InterruptedException | IOException e) {
					Logger loger = Logger.getLogger(Part2.class.getName());
					loger.log(Level.ALL, "Exception occur", e);
				}
			}
		};
		thread.start();
		try {
			Thread.sleep(2000);
			System.setIn(new SuspendedMessagesStream(System.lineSeparator()));
			thread.join();
			System.setIn(STD_IN);
		} catch (InterruptedException e) {
			Logger loger = Logger.getLogger(Part2.class.getName());
			loger.log(Level.ALL, "Exception occur", e);
		}

	}

}
