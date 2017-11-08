package ua.nure.zharkov.Task1;

public class Part8 {

	public static char[][] bwMatrix(int m, int n) {
		char[][] result = new char[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				result[i][j] = ((i + j) % 2 == 0) ? '×' : 'Á';
			}				
		}
		return result;
	}

	public static void strBW(char[][] matrix, int m, int n) {
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.print("Function got no parameters");
		} else {
			char[][] outData = bwMatrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			strBW(outData, Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		}
	}

}
