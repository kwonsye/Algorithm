package pck1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Parallelogram {
/*1064 ����纯��*/
	//����纯���� ���� �����ϴ� Ŭ����
	static class Point{
		int x;
		int y;
		
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	} 
	public static void main(String[] args) {
		//�Է¹��� ������ ������ �迭
		Point[] points=new Point[3];
		HashSet<Double> possibleLengthHashSet=new HashSet<Double>();
		double minLength,maxLength;
		Scanner sc=new Scanner(System.in);
		
		//�Է¹��� �� ���� ����
		int x,y;
		for(int pointCount=0;pointCount<3;pointCount++) {
			x=sc.nextInt();
			y=sc.nextInt();
			points[pointCount]=new Point(x,y);
		}
		//����纯���� ���� �� ������
		if(!isParallelogram(points))
			System.out.println(-1);
		//����纯���� ���� �� ������
		if(isParallelogram(points)) {
			//����� �ִ� ����纯������ ��� �ѷ��Ÿ��� ����ϰ� �ؽü¿� �����Ѵ�.
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
			if(flag) {//ù��°���Ҹ�
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
			if(flag) {//ù��°���Ҹ�
				maxLength=iterator.next();
				flag=false;
			}
		}
		
		return maxLength;
	}
	
	static boolean isParallelogram(Point[] points) {
		//�� ���� ��� �� ������ ������ ����纯���� ���� �� ����.
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
		//���Ⱑ ������..
		if((points[0].x-points[1].x)*(points[1].y-points[2].y)==(points[0].y-points[1].y)*(points[1].x-points[2].x))
			return false;//����纯���� �������
		else
			return true;//����纯���� ���� �� �ִ�.
	}
	
	static void calculatePossibleLength(HashSet<Double> hashset,Point[] points) {
		//����纯���� �׻� 3���� ���� �� �ִ�.
		//���� �� �ִ� ����纯�� �ѷ��� ����=������ ���� ������ �Ÿ��� ��*2
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
