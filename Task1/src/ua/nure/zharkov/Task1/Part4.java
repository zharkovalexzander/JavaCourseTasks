package ua.nure.zharkov.Task1;

public class Part4 {

	public static long rowSum(int n) {
		long result = 1;
		long factorial = 1;
		for (int i = 2; i <= n; ++i) {
			factorial *= i;
			if (i % 2 != 0) {
				result += factorial;
			} else {
				result -= factorial;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.print("Function got no parameters");
		} else {
			System.out.print(rowSum(Integer.parseInt(args[0])));
			System.out.println();
		}
	}

}
