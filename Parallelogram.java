package pck1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Parallelogram {
/*1064 평행사변형*/
	//평행사변형의 점을 저장하는 클래스
	static class Point{
		int x;
		int y;
		
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	} 
	public static void main(String[] args) {
		//입력받은 세점을 저장할 배열
		Point[] points=new Point[3];
		HashSet<Double> possibleLengthHashSet=new HashSet<Double>();
		double minLength,maxLength;
		Scanner sc=new Scanner(System.in);
		
		//입력받은 세 점은 저장
		int x,y;
		for(int pointCount=0;pointCount<3;pointCount++) {
			x=sc.nextInt();
			y=sc.nextInt();
			points[pointCount]=new Point(x,y);
		}
		//평행사변형을 만들 수 없으면
		if(!isParallelogram(points))
			System.out.println(-1);
		//평행사변형을 만들 수 있으면
		if(isParallelogram(points)) {
			//만들수 있는 평행사변형들의 모든 둘레거리를 계산하고 해시셋에 저장한다.
			calculatePossibleLength(possibleLengthHashSet,points);
			minLength=calculateMinLength(possibleLengthHashSet);
			maxLength=calculateMaxLength(possibleLengthHashSet);
			
			//System.out.println(possibleLengthHashSet);
			//System.out.println(minLength+" "+maxLength);
			System.out.println(maxLength-minLength);
		}
		sc.close();
	}
	
	static double calculateMinLength(HashSet<Double> hashset) {
		double minLength=0;
		boolean flag=true;
		Iterator<Double> iterator=hashset.iterator();
		while(iterator.hasNext()) {
			if(!flag) {
				double length=iterator.next();
				if(minLength>length)
					minLength=length;
			}
			if(flag) {//첫번째원소면
				minLength=iterator.next();
				flag=false;
			}
		}
		
		return minLength;
	}
	
	static double calculateMaxLength(HashSet<Double> hashset) {
		double maxLength=0;
		boolean flag=true;
		Iterator<Double> iterator=hashset.iterator();
		while(iterator.hasNext()) {
			if(!flag) {
				double length=iterator.next();
				if(maxLength<length)
					maxLength=length;
			}
			if(flag) {//첫번째원소면
				maxLength=iterator.next();
				flag=false;
			}
		}
		
		return maxLength;
	}
	
	static boolean isParallelogram(Point[] points) {
		//세 점이 모두 한 직선상에 있으면 평행사변형을 만들 수 없다.
		//double firstSlope,secondSlope;
		/*try {
			 firstSlope=(points[0].y-points[1].y)/(points[0].x-points[1].x);
		}
		catch(ArithmeticException e) {
			firstSlope=0;
		}
		try {
		secondSlope=(points[1].y-points[2].y)/(points[1].x-points[2].x);
		}
		catch(ArithmeticException e) {
			secondSlope=0;
		}*/
		//기울기가 같으면..
		if((points[0].x-points[1].x)*(points[1].y-points[2].y)==(points[0].y-points[1].y)*(points[1].x-points[2].x))
			return false;//평행사변형을 못만들고
		else
			return true;//평행사변형을 만들 수 있다.
	}
	
	static void calculatePossibleLength(HashSet<Double> hashset,Point[] points) {
		//평행사변형은 항상 3개씩 만들 수 있다.
		//만들 수 있는 평행사변형 둘레의 길이=각각의 점들 사이의 거리의 합*2
		double length1,length2,length3;
		
		length1=Math.sqrt((points[0].x-points[1].x)*(points[0].x-points[1].x)+(points[0].y-points[1].y)*(points[0].y-points[1].y))+
		Math.sqrt((points[0].x-points[2].x)*(points[0].x-points[2].x)+(points[0].y-points[2].y)*(points[0].y-points[2].y));
		
		length2=Math.sqrt((points[1].x-points[2].x)*(points[1].x-points[2].x)+(points[1].y-points[2].y)*(points[1].y-points[2].y))+
				Math.sqrt((points[1].x-points[0].x)*(points[1].x-points[0].x)+(points[1].y-points[0].y)*(points[1].y-points[0].y));
					
		length3=Math.sqrt((points[2].x-points[1].x)*(points[2].x-points[1].x)+(points[2].y-points[1].y)*(points[2].y-points[1].y))+
				Math.sqrt((points[2].x-points[0].x)*(points[2].x-points[0].x)+(points[2].y-points[0].y)*(points[2].y-points[0].y));
		
		hashset.add(2*length1);
		hashset.add(2*length2);
		hashset.add(2*length3);
	} 

}
