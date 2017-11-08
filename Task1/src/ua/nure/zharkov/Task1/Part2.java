package ua.nure.zharkov.Task1;

public class Part2 {

	public static int sumOfDigits(int n) {
		int result = 0;
		int tmp = n;
		while (tmp != 0) {
			result += tmp % 10;
			tmp /= 10;
		}
		return result;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.print("Function got no parameters");
		} else {
			System.out.print(sumOfDigits(Integer.parseInt(args[0])));
			System.out.println();
		}
	}
}
