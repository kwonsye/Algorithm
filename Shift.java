package pck1;

import java.util.Scanner;

public class Shift {

	static String getShiftedString(String s,int leftShifts,int rightShifts) {
		
		int inputStringLength=s.length();
		int shiftSub;
		char[] inputCharArray=s.toCharArray();
		char[] resultCharArray=new char[s.length()];
		
		if(leftShifts>rightShifts) {
			shiftSub= leftShifts-rightShifts;
			shiftSub%=inputStringLength;
			//shiftSub만큼 왼쪽쉬프트
			for(int arrayIndex=0;arrayIndex<s.length();arrayIndex++) {
				resultCharArray[(arrayIndex-shiftSub+inputStringLength)%inputStringLength]=inputCharArray[arrayIndex];
			}

			return (new String(resultCharArray));
		}
		
		if(leftShifts<rightShifts) {
			shiftSub= rightShifts-leftShifts;
			shiftSub%=inputStringLength;
			//shiftSub만큼 오른쪽 쉬프트
			for(int arrayIndex=0;arrayIndex<s.length();arrayIndex++) {
				resultCharArray[(arrayIndex+shiftSub)%inputStringLength]=inputCharArray[arrayIndex];
			}
			
			return (new String(resultCharArray));
		}
		
		else
			return s;
		
	}
	public static void main(String[] args) {
		
		//(쉬프트시킬 문자열 String,leftShift 횟수,rightShift 횟수)
		String s= getShiftedString("abcde",2,1);
		System.out.println(s);
		
		s= getShiftedString("abcde",3,5);
		System.out.println(s);
	}

}
