package ua.nure.zharkov.Task3;

import java.io.*;
import java.util.Iterator;
import java.util.regex.*;

class Parser implements Iterable<String> {

	private String text;

	public Parser(String fileName, String encoding) throws IOException {
		text = readFile(fileName, encoding);
	}

	private String readFile(String fileName, String encoding) throws IOException {
		StringBuilder fileCont = new StringBuilder();
		InputStream inputStream = new FileInputStream(fileName);
		Reader reader = new InputStreamReader(inputStream, encoding);
		BufferedReader br = new BufferedReader(reader);
		String line;
		while ((line = br.readLine()) != null) {
			fileCont.append(line);
			fileCont.append('\n');
		}
		br.close();
		reader.close();
		inputStream.close();
		return fileCont.toString().substring(0, fileCont.length() - 1);
	}

	private class Itr implements Iterator<String> {
		private Matcher match = Pattern.compile("([A-Za-z0-9�-��-�����]{1,})").matcher(text);

		public boolean hasNext() {
			return (match.find());
		}

		public String next() {
			return match.group(1);
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public Iterator<String> iterator() {
		return new Itr();
	}
	
}