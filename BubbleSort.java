package CSStudy;

//버블정렬
public class BubbleSort {

	public static void main(String[] args) {
		int[] dataArray = { 1, 50, 16, 4, 15, 33, 45, 21, 22 };

		bubbleSort(dataArray);

		for (int data : dataArray) {
			System.out.print(data + " ");
		}
	}

	// 오름차순 bubblesort
	public static void bubbleSort(int[] dataArray) {
		for (int index = 0; index < dataArray.length - 1; index++) {
			for (int left = index; left < dataArray.length-index-1; left++) {
				int right = left+1;
				if(dataArray[left] > dataArray[right]) {
					swap(dataArray, left, right);
				}
			}
		}
	}

	public static void swap(int[] dataArray, int left, int right) {
		int temp = dataArray[left];
		dataArray[left] = dataArray[right];
		dataArray[right] = temp;
	}

}
