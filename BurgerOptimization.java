package pck1;

import java.util.*;
import java.io.*;

public class BurgerOptimization {
//Google Woman SoftWare 
	//Burger Optimization
	

	public static void main(String[] args) {
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    for (int i = 1; i <= t; ++i) {
		      int k = in.nextInt();
		      List<Integer> value=new ArrayList<>();
		      
		      for(int j=0;j<k/2;j++) {
		    	  value.add(j);
		    	  value.add(j);
		      }
		      if(k%2!=0)
		    	 value.add(k/2);
		      
		      List<Integer> list=new ArrayList<>();
		      for(int j=1;j<=k;j++) {
		    	  int n=in.nextInt();
		    	  list.add(n);
		      }
		      Collections.sort(list);//오름차순
		      Collections.sort(value);
		      int result=0;
		      for(int j=0;j<k;j++) {
		    	 result+=(list.get(j)-value.get(j))*(list.get(j)-value.get(j));
		      }
		      
		      System.out.println("Case #" + i + ": "+result);
		    }
	}

}
