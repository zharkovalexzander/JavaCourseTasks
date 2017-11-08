package ua.nure.zharkov.Task1;

public class Part1 {

	public static int nod(int farg, int sarg) {
		int f = farg;
		int s = sarg;
		while (s > 0) {
			f %= s;
			int tmp = f;
			f = s;
			s = tmp;
		}
		return f;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.print("Function got no parameters");
		} else {
			System.out.print(nod(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
			System.out.println();
		}
	}

}
