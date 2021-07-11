import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//show the longest length of line
public class LongestLength {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] heights = new int[N];
		List<Integer> lengths = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			int h = sc.nextInt();
			heights[i] = h;
		}
		
		for(int i=0; i<heights.length-1; i++) {
			for(int j=i+1; j<heights.length; j++) {
				if(heights[i] <= heights[j]) {
					lengths.add(j-i);
					break;
				}
			}
		}
		
		System.out.println(Collections.max(lengths));
		sc.close();
	}
}
