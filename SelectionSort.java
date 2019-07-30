package CSStudy;

public class SelectionSort {

	public static void main(String[] args) {
		int[] dataArray = { 1, 50, 16, 4, 15, 33, 45, 21, 22 };

		selectionSort(dataArray);

		for (int data : dataArray) {
			System.out.print(data + " ");
		}
	}
	
	public static void selectionSort(int[] dataArray) {
		for(int index=0; index<dataArray.length-1; index++) {
			int minIndex = index;
			for(int selected=index+1; selected<dataArray.length; selected++) {
				if(dataArray[minIndex] > dataArray[selected]) {
					minIndex = selected;
				}
			}
			
			swap(dataArray, index, minIndex);
		}
	}
	
	public static void swap(int[] dataArray, int left, int right) {
		int temp = dataArray[left];
		dataArray[left] = dataArray[right];
		dataArray[right] = temp;
	}

}
