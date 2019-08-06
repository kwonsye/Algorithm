package pck1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class coding {

	public static void main(String[] args) {
		//스트림
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.stream()
			.map(s -> (s+1))
			.filter(s->(s>1))
			//.forEach(System.out::println);
			.forEach(s->System.out.println(s));
		                                                                           
		//for( int a : (List<Integer>)stream) {
			//System.out.println(a);
		//}
		//list=(List<Integer>) stream;
		//System.out.println(list);
		/*
		int[] arr= {9,10,15,20,8,27};
		Arrays.sort(arr);//8 9 10 15 20 27
	
		int[] result=new int[arr.length];
		
		Scanner sc=new Scanner(System.in);
		String c=sc.next();
		
		int[][] arr2=new int[3][2];
		arr2[1].le
		String s="2";
		String.par
		
		/*
		// TODO Auto-generated method stub
		String str="absc";
		str=str.substring(str.length()-2, str.length());
		System.out.println(str);
		
		//String b=Integer.toBinaryString(0);
		//System.out.println(b);
		int num=3;
		str=String.format("%"+num+"s", Integer.toBinaryString(0)).replace(" ", "0");
		System.out.println(str);
		
		double num2=Math.sqrt(num);
		if(num2==(int)num2) {
			System.out.println("Y");
		}
		
		//int num=10;
		double n=Math.log10(100);
		//String s=Double.toString(n);
		System.out.printf("%.2f",n);
		
		HashSet<String> set=new HashSet<>();
		
		set.add("monk");
		set.add("angel");
		set.add("apple");
		set.add("encyclopedia");
		set.add("apple");
		set.add("elephant");
		
		List<String> list=new ArrayList(set);
		
		Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()<o2.length())
					return -1;
				if(o1.length()>o2.length())
					return 1;
				if(o1.length()==o2.length()) {
					return o1.compareTo(o2);
				}	
				return 0;
			}
			
		});//사전순
		
		for(String s:list) {
			System.out.println(s);
		}
		//1,2,3,4,5
		System.out.println(gcd(3,5));
		
	}
	  public static int gcd(int a, int b) {
		    while (b != 0) {
		      int temp = a % b;
		      a = b;
		      b = temp;
		    }
		    return Math.abs(a);
		    */
		
		
		  }

}
