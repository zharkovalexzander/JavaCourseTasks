package ua.nure.zharkov.Task1;

public class Part6 {

	public static int[] fibbNums(int n) {
		int[] result = new int[n];
		if (n == 1) {
			result[0] = 1;
		} else {
			result[1] = (result[0] = 1);
			for (int i = 2; i < n; ++i) {
				result[i] = result[i - 2] + result[i - 1];
			}
		}
		return result;
	}

	public static void strArray(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i]);
			if (i != (arr.length - 1)) {
				System.out.print(" ");
			}
		}
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.print("Function got no parameters");
		} else {
			int[] outData = fibbNums(Integer.parseInt(args[0]));
			strArray(outData);
			System.out.println();
		}
	}

}
