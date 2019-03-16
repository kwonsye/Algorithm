package pck1;

import java.util.Scanner;
//show minimum |width-height| 
public class Square {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //≥–¿Ã
		
		int prev = 0;
		int w=0,h=0;
		
		for(int i = 1; i <= N; i++) {
			if(N % i == 0) {
				if(prev == N/i) {
					w = N/i;
					h = i;
					break;
				}
				else{
					prev = i;
				}
			}
		}
		
		System.out.println(Math.abs(w-h));
		
		sc.close();
	}

}
