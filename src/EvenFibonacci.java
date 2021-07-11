import java.util.Arrays;

/*
 * Fibonacci sequence starts with 0 and 1 where each fibonacci number is a sum of two previous fibonacci numbers. Given an integer N, find the sum of all even fibonacci numbers.
*/
public class EvenFibonacci {

	public static void main(String[] args) {
		int[] fibonacci = new int[10000];
		int limit = 50;
		int limit_index = 0;

		fibonacci[0] = 0;
		fibonacci[1] = 1;

		for (int index = 0; index + 2 < fibonacci.length; index++) {
			fibonacci[index + 2] = fibonacci[index] + fibonacci[index + 1];
			if (fibonacci[index + 2] >= limit) {
				limit_index = index + 2;
				break;
			}
		}
		
		//test
		System.out.print(Arrays.toString(fibonacci));
		
		int fiboSum = 0;
		for(int index = 0; index <= limit_index ; index++) {
			if(fibonacci[index]<limit && fibonacci[index]%2 == 0) {
				System.out.println("�������� �� :" + fibonacci[index]);
				fiboSum += fibonacci[index];
			}
		}
		
		System.out.println(fiboSum);
	}

}
