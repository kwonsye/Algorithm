import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*6987 ������*/
public class WorldCup {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int[] resultArray=new int[5];
		for(int row=1;row<=4;row++) {

			List<Integer> winScoreList=new ArrayList<Integer>();
			List<Integer> drawScoreList=new ArrayList<Integer>();
			List<Integer> loseScoreList=new ArrayList<Integer>();
			
			for(int country=1;country<=6;country++) {
				int winScore=sc.nextInt();
				int drawScore=sc.nextInt();
				int loseScore=sc.nextInt();
				
				winScoreList.add(winScore);
				drawScoreList.add(drawScore);
				loseScoreList.add(loseScore);
				
			}
			
			//������������
			Collections.sort(winScoreList);
			Collections.reverse(winScoreList);
			Collections.sort(loseScoreList);
			Collections.reverse(loseScoreList);

			for(int n:winScoreList) {
			    for(int i=0;i<n;i++) {
			          int  result= (loseScoreList.get(i)-1);
			          loseScoreList.set(i,result);
			    }
			    //���������ѹ���
			    Collections.sort(loseScoreList);
			    Collections.reverse(loseScoreList);
			    
			}
			
			int winLoseFlag=0;
			for(int element:loseScoreList) {
				if(element!=0) {
					winLoseFlag=1;break;
				}
				
			}//�Ұ����� ��������ǥ�� �˷���
			//������� ���з� �Ǵ�

			//���� ���º��Ǵ�
			
			//������������
			Collections.sort(drawScoreList);
			Collections.reverse(drawScoreList);

			while(drawScoreList.get(0)!=0) {
				int count=drawScoreList.get(0);
				drawScoreList.set(0,0);
				for(int i=1;i<1+count;i++) {
					int result=drawScoreList.get(i)-1;
					drawScoreList.set(i,result);
					}
				//������������
				Collections.sort(drawScoreList);
				Collections.reverse(drawScoreList);
			}
			
			int drawFlag=0;
			for(int element:drawScoreList) {
				if(element!=0) {
					drawFlag=1;break;
				}
			}//�Ұ����� ���º�����ǥ�� �˷���
		
		
			//������ ����ǥ���� �����Ǵ�
			if((winLoseFlag==0)&&(drawFlag==0))
				resultArray[row]=1;
			
			else if((winLoseFlag==1)||(drawFlag==1))
				resultArray[row]=0;
			
			
			
		}
		
		for(int i=1;i<=4;i++) {
		System.out.print(resultArray[i]+" ");
		}
		sc.close();
	}
	
}
