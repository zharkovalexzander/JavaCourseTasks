package ua.nure.zharkov.Task1;

public class Part7 {

	private static int[] simples(int n) {
		int[] result = new int[n];
		int op = 2;
		for (int i = 0; i < n; ++i) {
			while (!Part3.isSimple(op)) {
				++op;
			}
			result[i] = op;
			++op;
		}
		return result;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.print("Function got no parameters");
		} else {
			int[] outData = simples(Integer.parseInt(args[0]));
			Part6.strArray(outData);
			System.out.println();
		}
	}

}
