package ua.nure.zharkov.Task2;

public class ListImpl implements List {

	protected Object[] innerList;

	protected int sizeList;

	private static final int DEFSIZE = 10;

	public ListImpl() {
		innerList = new Object[DEFSIZE];
		sizeList = 0;
	}

	@Override
	public int size() {
		return sizeList;
	}

	@Override
	public void add(Object el) {
		checkSize(sizeList + 1);
		innerList[sizeList++] = el;
	}

	private void checkSize(int size) {
		if (size - innerList.length > 0) {
			int oldsize = innerList.length;
			int newsize = oldsize + (oldsize >> 1);
			if (newsize - size < 0) {
				newsize = size;
			}
			innerList = java.util.Arrays.copyOf(innerList, newsize);
		}
	}

	@Override
	public Object get(int index) {
		if (index < 0 || index >= sizeList) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		return innerList[index];
	}

	@Override
	public void addAll(List list) {
		checkSize(sizeList + list.size());
		for (int i = sizeList; i < sizeList + list.size(); ++i) {
			innerList[i] = list.get(i - sizeList);
		}
		sizeList += list.size();
	}

	@Override
	public void clear() {
		sizeList = 0;
	}

	@Override
	public boolean contains(Object el) {
		return indexOf(el) != -1;
	}

	@Override
	public int indexOf(Object el) {
		for (int i = 0; i < sizeList; ++i) {
			if (innerList[i].equals(el)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Object remove(int index) {
		if (index < 0 || index >= sizeList) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		return rm(index);
	}

	private Object rm(int index) {
		Object elem = innerList[index];
		int delIndex = sizeList - index - 1;
		if (delIndex > 0) {
			System.arraycopy(innerList, index + 1, innerList, index, delIndex);
		}
		innerList[--sizeList] = null;
		return elem;
	}

	@Override
	public boolean remove(Object el) {
		return rm(el);
	}

	private boolean rm(Object el) {
		int pos = indexOf(el);
		if (pos == -1) {
			return false;
		}
		remove(pos);
		return true;
	}

	@Override
	public TaskIterator iterator() {
		TaskIterator iter = new TaskIterator() {
			private int index = 0;
			public boolean hasNext() {
				return (index < sizeList && innerList[index] != null);
			}
			public Object next() {
				if (!hasNext()) {
					throw new java.util.NoSuchElementException();
				}
				return innerList[index++];
			}
			public void remove() {
				if (index <= 0) {
					throw new IllegalStateException();
				}
				rm(--index);
			}
		};
		return iter;
	}

	@Override
	public Object[] toArray() {
		return java.util.Arrays.copyOf(innerList, sizeList);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		for (int i = 0; i < sizeList; ++i) {
			str.append(innerList[i].toString());
			if (i < (sizeList - 1)) {
				str.append(", ");
			}
		}
		str.append("]");
		return str.toString();
	}

	private static void printOne(List listerf, List listers, String... args) {
		listers.add("D");
		listers.add("E");
		listers.add("F");
		System.out.println(listers);
		System.out.println(args[1]);
		System.out.println("~~~ Result: [A, B, C, D, E, F]");
		listerf.addAll(listers);
		System.out.println(listerf);
		System.out.println("~~~ list.add(C)");
		System.out.println("~~~ Result: [A, B, C, D, E, F, C]");
		listerf.add("C");
		System.out.println(listerf);
		System.out.println("~~~ list.clear()");
		System.out.println("~~~ Result: []");
		listerf.clear();
		System.out.println(listerf);
		System.out.println(args[1]);
		System.out.println(args[0]);
		listerf.addAll(listers);
		System.out.println(listerf);
		System.out.println("~~~ list.contains(E)");
		System.out.println("~~~ Result: true");
		System.out.println(listerf.contains("E"));
	}

	private static void printTwo(List lister, String... args) {
		System.out.println("~~~ list.contains(�)");
		System.out.println("~~~ Result: false");
		System.out.println(lister.contains("C"));
		System.out.println("~~~ list.indexOf(D)");
		System.out.println("~~~ Result: 0");
		System.out.println(lister.indexOf("D"));
		System.out.println("~~~ list.get(2)");
		System.out.println("~~~ Result: F");
		System.out.println(lister.get(2));
		System.out.println("~~~ list.indexOf(F)");
		System.out.println("~~~ Result: 2");
		System.out.println(lister.indexOf("F"));
		System.out.println("~~~ list.size()");
		System.out.println("~~~ Result: 3");
		System.out.println(lister.size());
		System.out.println("~~~ list");
		System.out.println(args[0]);
		System.out.println(lister);
	}

	private static void printThree(List listerf, List listers, String... args) {
		System.out.println("~~~ list.remove(1)");
		System.out.println("~~~ Result: [D, F]");
		listerf.remove(1);
		System.out.println(listerf);
		System.out.println("~~~ list.remove(F)");
		System.out.println("~~~ Result: [D]");
		listerf.remove("F");
		System.out.println(listerf);
		System.out.println("~~~ list.size()");
		System.out.println("~~~ Result: 1");
		System.out.println(listerf.size());
		System.out.println(args[1]);
		System.out.println("~~~ Result: [D, D, E, F]");
		listerf.addAll(listers);
		System.out.println(listerf);
		System.out.println("~~~ foreach list");
		System.out.println("~~~ Result: D D E F");
		for (Object el : listerf) {
			System.out.print(el + " ");
		}
		System.out.println();
	}

	private static void printFour(List lister, String... args) {
		System.out.println("~~~ Iterator it = list.iterator()");
		TaskIterator it = lister.iterator();
		System.out.println(args[2]);
		System.out.println("~~~ Result: D");
		System.out.println(it.next());
		System.out.println(args[2]);
		System.out.println("~~~ Result: D");
		System.out.println(it.next());
		System.out.println(args[3]);
		System.out.println(args[0]);
		it.remove();
		System.out.println(lister);
		System.out.println(args[2]);
		System.out.println("~~~ Result: E");
		System.out.println(it.next());
		System.out.println(args[3]);
		System.out.println("~~~ Result: [D, F]");
		it.remove();
		System.out.println(lister);
		System.out.println(args[2]);
		System.out.println("~~~ Result: F");
		System.out.println(it.next());
		System.out.println(args[3]);
		System.out.println("~~~ Result: [D]");
		it.remove();
		System.out.println(lister);
		System.out.println("~~~ list.remove(D)");
		System.out.println("~~~ Result: []");
		lister.remove("D");
		System.out.println(lister);
	}

	private static void printFive(List listerf, List listers, String... args) {
		System.out.println(args[1]);
		System.out.println(args[0]);
		listerf.addAll(listers);
		System.out.println(listerf);
		System.out.println("~~~ foreach list");
		System.out.println("~~~ Result: D E F ");
		for (Object el : listerf) {
			System.out.print(el + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String frep = "~~~ Result: [D, E, F]";
		String srep = "~~~ list.addAll(list2)";
		String trep = "~~~ it.next()";
		String forep = "~~~ it.remove()";
		System.out.println("~~~ list A B C");
		System.out.println("~~~ Result: [A, B, C]");
		List listerfirst = new ListImpl();
		listerfirst.add("A");
		listerfirst.add("B");
		listerfirst.add("C");
		System.out.println(listerfirst);
		System.out.println("~~~ list2: D E F");
		System.out.println(frep);
		List listersecond = new ListImpl();

		printOne(listerfirst, listersecond, new String[] { frep, srep, trep, forep });

		printTwo(listerfirst, new String[] { frep, srep, trep, forep });

		printThree(listerfirst, listersecond, new String[] { frep, srep, trep, forep });

		printFour(listerfirst, new String[] { frep, srep, trep, forep });

		printFive(listerfirst, listersecond, new String[] { frep, srep, trep, forep });
	}

}