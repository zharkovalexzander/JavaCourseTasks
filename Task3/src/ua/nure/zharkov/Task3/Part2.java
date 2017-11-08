package ua.nure.zharkov.Task3;

import java.io.*;

public class Part2 {
	private static final String FILE_NAME = "part2.txt";
	private static final String CODING = "Cp1251";

	public void readWords() throws IOException {
		InputStream inputStream = new FileInputStream(FILE_NAME);
		Reader reader = new InputStreamReader(inputStream, CODING);
		BufferedReader br = new BufferedReader(reader);
		String line;
		StringBuilder text = new StringBuilder();
		while ((line = br.readLine()) != null) {
			String[] words = line.split(" ");
			boolean flag = false;
			if(line.charAt(line.length() - 1) == ' ') {
				flag = true;
			}
			text.append(arrange(words, flag));
		}
		String temp = text.toString();
		if(temp.lastIndexOf(' ') == temp.length() - 2) {
			System.out.print(temp.substring(0, temp.length() - 1));
		} else {
			System.out.print(temp);
		}
		System.out.print("\n");
		br.close();
		reader.close();
		inputStream.close();
	}

	private boolean charsMatches(String elem) {
		for (int i = 0; i < elem.length(); ++i) {
			for (int j = i + 1; j < elem.length(); ++j) {
				if (elem.charAt(i) == elem.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean action(String elem) {
		if (charsMatches(elem)) {
			return true;
		}
		return false;
	}

	private String arrange(String[] words, boolean flag) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < words.length; ++i) {
			if(action(words[i])) {
				str.append(words[i]);
			}
			if(i < words.length - 1) {
				str.append(" ");
			}
		}
		if(flag) {
			str.append(" \n");
		} else {
			str.append("\n");
		}
		return str.toString();
	}

	public static void main(String[] args) throws IOException {
		Part2 example = new Part2();
		example.readWords();
	}
	
}
