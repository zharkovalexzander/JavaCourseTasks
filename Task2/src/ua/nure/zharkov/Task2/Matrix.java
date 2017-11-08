package ua.nure.zharkov.Task2;

public class Matrix {

	protected double[][] matrix;
	protected int rows;
	protected int cols;

	public Matrix(double[][] ar) {
		rows = ar.length;
		cols = ar[0].length;
		matrix = new double[rows][cols];
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				matrix[i][j] = ar[i][j];
			}
		}
	}

	public int getColumns() {
		return cols;
	}

	public int getRows() {
		return rows;
	}

	public void add(Matrix m) {
		if (cols != m.getColumns() || rows != m.getRows()) {
			throw new java.lang.IllegalArgumentException();
		}

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				matrix[i][j] += m.matrix[i][j];
			}
		}

	}

	public void mul(double x) {
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				matrix[i][j] *= x;
			}
		}
	}

	public void mul(Matrix m) {
		if (cols != m.getRows()) {
			throw new java.lang.IllegalArgumentException();
		}

		double[][] temp = new double[rows][m.getColumns()];

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < m.getColumns(); ++j) {
				double value = 0;
				for (int k = 0; k < cols; ++k) {
					value += matrix[i][k] * m.matrix[k][j];
				}
				temp[i][j] = value;
			}
		}
		cols = m.getColumns();
		matrix = temp;
	}

	public void transpose() {
		double[][] temp = new double[cols][rows];

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				temp[j][i] = matrix[i][j];
			}
		}

		int temporary = cols;
		cols = rows;
		rows = temporary;

		matrix = temp;
	}

	public void print() {
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				System.out.print(matrix[i][j]);
				if (j < cols - 1) {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		Matrix secondmatrix = new Matrix(new double[][] { { 1.0, 2.0, 3.0 }, { 4.0, 5.0, 6.0 } });
		Matrix firstmatrix = new Matrix(new double[][] { { 1.0, 2.0, 3.0 }, { 4.0, 5.0, 6.0 } });

		System.out.println("~~~ m");
		firstmatrix.print();

		System.out.println("~~~ m2");
		secondmatrix.print();

		System.out.println("~~~ transpose m");
		firstmatrix.transpose();
		firstmatrix.print();

		System.out.println("~~~ mul m on m2");
		firstmatrix.mul(secondmatrix);
		firstmatrix.print();

		System.out.println("~~~ mul m2 on 2");
		secondmatrix.mul(2);
		secondmatrix.print();
	}

}
