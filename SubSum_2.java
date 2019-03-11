package pck1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//천천히 여유롭게!
/*
 * Given an integer array, find the largest consecutive sum of elements.
 * ex> 
 * Input: [-1, 3, -1, 5]
 * Output: 7 // 3 + (-1) + 5
 */

public class SubSum_2 {

	public static void main(String[] args) {
		int[] input_array = { 2, 4, -2, -3, 8 };

		List<Integer> subSumList = new ArrayList<>();

		for (int index = 0; index < input_array.length; index++) {
			subSumList.add(input_array[index]);

			if (index != input_array.length-1) {
				for (int nextIndex = index + 1; nextIndex < input_array.length; nextIndex++) {
					int previous = subSumList.get(subSumList.size() - 1);
					int sum = previous + input_array[nextIndex];
					subSumList.add(sum);
				}
			}
		}
		
		Collections.sort(subSumList); //오름차순 정렬
		System.out.println(subSumList.get(subSumList.size()-1));

	}

}
