package pck1.MashUpStudy;

import java.util.Arrays;

public class PhoneBook {

	public static void main(String[] args) {
		//test case
		String[] phoneBook = {"119", "97674223", "1195524421"};
		
		System.out.println(solution(phoneBook));
	}
	
	//TODO: hash 사용해서 풀어보기 _ hash를 어디에 사용하지..
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        //반례 : 11909 , 119, 11
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
