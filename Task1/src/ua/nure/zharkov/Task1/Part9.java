package ua.nure.zharkov.Task1;

public class Part9 {

	private static int getI(int index, int digit) {
		return Math.round((index % Part5.power(2, digit)) / (float) Part5.power(2, digit));
	}

	public static int[][][][][] fiveD() {
		int[][][][][] result = new int[2][2][2][2][2];
		for (int i = 0; i < 32; ++i) {
			result[getI(i, 5)][getI(i, 4)][getI(i, 3)][getI(i, 2)][getI(i, 1)] = i + 1;
		}
		return result;
	}

	public static void printFiveD(int[][][][][] fd) {
		for (int i = 0; i < 32; ++i) {
			System.out.print(fd[getI(i, 5)][getI(i, 4)][getI(i, 3)][getI(i, 2)][getI(i, 1)]);
			System.out.print(" ");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		int[][][][][] outData = fiveD();
		printFiveD(outData);
	}

}
