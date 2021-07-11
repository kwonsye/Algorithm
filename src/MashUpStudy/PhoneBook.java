package MashUpStudy;

import java.util.Arrays;

public class PhoneBook {

	public static void main(String[] args) {
		//test case
		String[] phoneBook = {"119", "97674223", "1195524421"};
		
		System.out.println(solution(phoneBook));
	}
	
	//TODO: hash ����ؼ� Ǯ��� _ hash�� ��� �������..
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        //�ݷ� : 11909 , 119, 11
        Arrays.sort(phone_book);
        
        for(int prefixIndex=0; prefixIndex<phone_book.length-1; prefixIndex++) {
        	for(int findIndex=prefixIndex+1; findIndex<phone_book.length; findIndex++) {
        		if(phone_book[findIndex].startsWith(phone_book[prefixIndex])) {
        			answer = false;
        			break;
        		}
        	}
        }
        
        return answer;
    }

}
