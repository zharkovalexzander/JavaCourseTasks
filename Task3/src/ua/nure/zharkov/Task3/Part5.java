package ua.nure.zharkov.Task3;

import java.io.*;

public class Part5 {
	
	private static final String FILE_NAME = "part5.txt";
	private static final String CODING = "Cp1251";
	
	private Parser parser;
	private WordContainer words;
	
	public Part5() throws IOException {
		parser = new Parser(FILE_NAME, CODING);
		words = new WordContainer();
	}
	
	public void action() {
		for(String x : parser) {
			words.add(x);
		}
	}
	
	public void print() {
		System.out.print(this);
	}
	
	public String toString() {
		return words.toString();
	}

	public static void main(String[] args) throws IOException {
		Part5 example = new Part5();
		example.action();
		example.print();
	}

}
