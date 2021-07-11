import java.util.Scanner;

public class SplittingIntoDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=n-1; i>1; i--) {
			if(n%i == 0) {
				System.out.println(n/i);
				for(int j=0;j<n/i;j++) {
					System.out.print(i+" ");
				}
				System.exit(0);
			}
		}
		
		System.out.println(1);
		System.out.println(n);
		
		sc.close();
	}

}
