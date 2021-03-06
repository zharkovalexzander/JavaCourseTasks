package ua.nure.zharkov.Task3;

import java.util.*;
import java.io.Serializable;

public class WordContainer {

	private List<Word> words;

	public WordContainer() {
		words = new ArrayList<Word>();
	}

	public static class Word implements Comparable<Word>, Serializable {

		private static final long serialVersionUID = -2804098246113125128L;
		private String content;
		private int frequency;

		public Word(String content) {
			this.content = content;
			this.frequency = 1;
		}

		public void addFrequency() {
			frequency++;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			} else {
				if (obj == this) {
					return true;
				} else {
					if (obj.getClass() == this.getClass()) {
						Word word = (Word) obj;
						if (word.content.equals(content)) {
							return true;
						}
					}
				}
			}
			return false;
		}
		
		public boolean areEqual(Object obj) {
			if (obj instanceof String) {
				return content.equals(obj);
			} else {
				return equals(obj);
			}
		}

		@Override
		public int hashCode() {
			return content.hashCode();
		}

		@Override
		public int compareTo(Word another) {
			return frequency < another.frequency ? 1
					: frequency == another.frequency ? content.compareTo(another.content) : -1;
		}
	}

	static class WordComparator implements Comparator<Word>, Serializable {
		private static final long serialVersionUID = 617479232823917052L;

		@Override
		public int compare(Word a, Word b) {
			return a.compareTo(b);
		}
	}

	public boolean contains(String s) {
		for (Word word : words) {
			if (word.areEqual(s)) {
				return true;
			}
		}
		return false;
	}

	public int indexOf(String s) {
		for (int i = 0; i < words.size(); ++i) {
			if (words.get(i).areEqual(s)) {
				return i;
			}
		}
		return -1;
	}

	public void add(String s) {
		if (contains(s)) {
			words.get(indexOf(s)).addFrequency();
		} else {
			words.add(new Word(s));
		}
		Collections.sort(words, new WordComparator());
	}

	public void print() {
		System.out.print(this);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < words.size(); ++i) {
			builder.append(words.get(i).content);
			builder.append(':');
			builder.append(words.get(i).frequency);
			if (i < words.size() - 1) {
				builder.append('\n');
			}
		}
		return builder.toString();
	}

}
