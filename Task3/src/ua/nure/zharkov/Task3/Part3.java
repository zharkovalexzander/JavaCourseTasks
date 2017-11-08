package ua.nure.zharkov.Task3;

import java.io.*;
import java.util.regex.*;
import java.util.*;

public class Part3 {

	private static final String FILE_NAME = "part3.txt";
	private static final String CODING = "Cp1251";

	private List<Pair<Action, String>> regers;
	private List<String> ints = new ArrayList<String>();
	private List<String> dbls = new ArrayList<String>();
	private List<String> strings = new ArrayList<String>();

	public Part3() {
		regers = new LinkedList<Pair<Action, String>>();
		regers.add(new Pair<Action, String>(Action.DOUBLE, "^([0-9]{0,}[.][0-9]{1,})|([0-9]{1,}[.][0-9]{0,})$"));
		regers.add(new Pair<Action, String>(Action.INT, "^([1-9]{1}[0-9]{0,})|[0]$"));
		regers.add(new Pair<Action, String>(Action.STRING, "^[A-Za-zÀ-ßà-ÿ³¿ºý]{1,}$"));

	}

	public Action compare(String lines) {
		for (Pair<Action, String> x : regers) {
			Pattern pattern = Pattern.compile(x.getValue());
			Matcher matcher = pattern.matcher(lines);
			if (matcher.matches()) {
				return x.getKey();
			}
		}
		return Action.NONE;
	}

	private void arrange(String[] words) {
		for (String x : words) {
			Action temp = compare(x);
			if (Action.DOUBLE == temp) {
				dbls.add(x);
			} else {
				if (Action.INT == temp) {
					ints.add(x);
				} else {
					if (Action.STRING == temp) {
						strings.add(x);
					}
				}
			}
		}
	}

	private void outPrint() throws IOException {
		int b;
		StringBuilder word = new StringBuilder();
		while (!word.toString().equals("stop")) {
			b = System.in.read();
			if ((char) b == '\n' || b == -1) {
				if (decide(word.toString())) {
					return;
				}
				word.setLength(0);
			} else {
				if ((char) b == '\r') {
					continue;
				}
				word.append((char) b);
			}
		}
	}

	private boolean decide(String s) {
		if (s.equals("string")) {
			printcoll(strings);
			return false;
		} else {
			if (s.equals("int")) {
				printcoll(ints);
				return false;
			} else {
				if (s.equals("double")) {
					printcoll(dbls);
					return false;
				} else {
					return true;
				}
			}
		}
	}

	private void printcoll(List<String> list) {
		for (int i = 0; i < list.size(); ++i) {
			System.out.print(list.get(i));
			if (i < list.size() - 1) {
				System.out.print(' ');
			}
		}
		System.out.print("\n");
	}

	public void mainAction() throws IOException {
		InputStream inputStream = new FileInputStream(FILE_NAME);
		Reader reader = new InputStreamReader(inputStream, CODING);
		BufferedReader br = new BufferedReader(reader);
		String line;
		while ((line = br.readLine()) != null) {
			String[] words = line.split(" ");
			arrange(words);
		}
		outPrint();
		br.close();
		reader.close();
		inputStream.close();
	}

	enum Action {
		DOUBLE, INT, STRING, NONE
	}

	public static class Pair<A, B> {
		private A key;
		private B value;

		public Pair(A a, B b) {
			this.key = a;
			this.value = b;
		}

		public A getKey() {
			return key;
		}

		public B getValue() {
			return value;
		}
	}

	public static void main(String[] args) throws IOException {
		Part3 example = new Part3();
		example.mainAction();
	}

}
