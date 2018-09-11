package pck1;
/*5622 다이얼*/
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Diolog {
	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<>();
		map.put("ABC",3);
		map.put("DEF",4);
		map.put("GHI",5);
		map.put("JKL",6);
		map.put("MNO",7);
		map.put("PQRS",8);
		map.put("TUV",9);
		map.put("WXYZ",10);

		Scanner sc=new Scanner(System.in);
		//사용자에게 문자열받기
		String inputString=sc.next();

		int spentTime=0;

		for (int i = 0; i < inputString.length(); i++) {
			char inputChar=inputString.charAt(i);
		    for(String key:map.keySet()) {
		         if(key.indexOf(inputChar)!=-1) {
			              spentTime+=map.get(key); break;}		 
		    }
	}
		System.out.print(spentTime);
		sc.close();
	}

}
