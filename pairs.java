package pck1;

public class pairs {
	static int pairs(int k, int[] arr) {
		//k=두수의 차이
		int count=0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(Math.abs(arr[i]-arr[j])==k)
					count++;
			}
		}
		return count;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,5,3,4,2};
		System.out.print(pairs(2,arr));
	}

}
