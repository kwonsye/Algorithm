import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//show correct order of Chemical symbol
public class ChemicalSymbol {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		List<String> strArr = new ArrayList<>();
		List<Character> numArr = new ArrayList<>();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(!Character.isDigit(c)) {
				if(Character.isUpperCase(c)) {
					strArr.add(Character.toString(c));
				} else {
					String newStr =strArr.get(strArr.size()-1) + Character.toString(c);
					strArr.set(strArr.size()-1, newStr);
				}
			} else {
				numArr.add(c);
			}
		}
		
		if(strArr.size() != numArr.size()) {
			System.out.println("error");
		} else {
			for(int i=0; i<strArr.size(); i++) {
				System.out.print(strArr.get(i)+((numArr.get(i)=='1')?"":numArr.get(i)));
			}
		}
		
		sc.close();
	}

}
