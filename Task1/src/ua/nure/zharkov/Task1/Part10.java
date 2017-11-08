package ua.nure.zharkov.Task1;

public class Part10 {

	public static int[][] binCoeffPyramid(int n) {
		int[][] triaArr = new int[n][];
		for (int i = 0; i < n; ++i) {
			triaArr[i] = new int[i + 1];
			for (int j = 0; j <= i; ++j) {
				if (j == 0 || j == i) {
					triaArr[i][j] = 1;
				} else {
					triaArr[i][j] = triaArr[i - 1][j] + triaArr[i - 1][j - 1];
				}
				System.out.print(triaArr[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		return triaArr;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.print("Function got no parameters");
		} else {
			binCoeffPyramid(Integer.parseInt(args[0]));
		}
	}

}
