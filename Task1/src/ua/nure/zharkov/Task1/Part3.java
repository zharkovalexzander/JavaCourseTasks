package ua.nure.zharkov.Task1;

public class Part3 {

	public static boolean isSimple(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= n / 2; ++i) {
			if ((n % i) == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.print("Function got no parameters");
		} else {
			System.out.print(isSimple(Integer.parseInt(args[0])));
			System.out.println();
		}
	}

}
