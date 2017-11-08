package ua.nure.zharkov.Task1;

public class Part5 {

	public static int power(int num, int pow) {
		int answ = 1;
		for(int i = 0; i < pow; ++i) {
			answ *= num;
		}
		return answ;	
	}

	public static int luckyNums(int n) {
		int answer = 0;
		int fop = power(10, n - 1);
		int halfPow = power(10, (n / 2));
		while (fop < power(10, n)) {
			if (Part2.sumOfDigits(fop % halfPow) == Part2.sumOfDigits(fop / halfPow)) {
				++answer;
			}
			++fop;
		}
		return answer;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.print("Function got no parameters");
		} else {
			System.out.print(luckyNums(Integer.parseInt(args[0])));
			System.out.println();
		}
	}

}
