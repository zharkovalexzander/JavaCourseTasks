package ua.nure.zharkov.Task4;

import java.io.*;

public class SuspendedMessagesStream extends InputStream {

	private char[] linesep;
	private int pos;

	public SuspendedMessagesStream(String input) {
		this.linesep = input.toCharArray();
		this.pos = 0;
	}

	@Override
	public int read() throws IOException {
		if (pos <= linesep.length - 1) {
			return (int) linesep[pos++];
		} else {
			return -1;
		}
	}

	public void setDataAvailable() {
		synchronized (this) {
			notify();
		}
	}

}
