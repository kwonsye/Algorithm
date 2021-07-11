import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ClimbingLeaderBoard {

	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		/*
		 * 1)���� �ɸ� 
		 * HashSet<Integer> scoresHashSet=new HashSet<Integer>(); for(int
		 * score:scores) scoresHashSet.add(score);
		 * 
		 * LinkedList<Integer>scoresList=new LinkedList<Integer>();
		 * scoresList.addAll(scoresHashSet);
		 * 
		 * Collections.sort(scoresList); Collections.reverse(scoresList);
		 * 
		 * int aliceScore; int[] rankResult=new int[alice.length]; for(int
		 * aliceScoreCount=0;aliceScoreCount<alice.length;aliceScoreCount++) {
		 * aliceScore=alice[aliceScoreCount];
		 * 
		 * //�������忡 �̹� �ٸ��������� �����ڰ� �ִٸ� ���� ��ũ�� �����ָ�� if(scoresList.contains(aliceScore)) {
		 * rankResult[aliceScoreCount]=(scoresList.indexOf(aliceScore)+1); } //�������忡
		 * �ٸ��������� ������ ������ ���ٸ� else { scoresList.add(aliceScore); //��������
		 * Collections.sort(scoresList); Collections.reverse(scoresList);
		 * 
		 * rankResult[aliceScoreCount]=(scoresList.indexOf(aliceScore)+1); //�����
		 * scoresList.remove(scoresList.indexOf(aliceScore)); } }
		 * 
		 * return rankResult;
		 */

		// 2) �ٸ� ���
		HashSet<Integer> scoresHashSet = new HashSet<Integer>();
		for (int score : scores)
			scoresHashSet.add(score);

		List<Integer> scoresList = new ArrayList<>(scoresHashSet);
		Collections.sort(scoresList);
		Collections.reverse(scoresList);// �������� ����

		int[] rankResult = new int[alice.length];

		for (int aliceScoreCount = 0; aliceScoreCount < alice.length; aliceScoreCount++) {
			int aliceScore = alice[aliceScoreCount];

			if (scoresList.contains(aliceScore)) {
				rankResult[aliceScoreCount] = (scoresList.indexOf(aliceScore) + 1);
			}
			// 100,50,40,20,10
			else if (scoresList.get(0) < aliceScore)
				rankResult[aliceScoreCount] = 1;

			else if (scoresList.get(scoresList.size() - 1) > aliceScore)
				rankResult[aliceScoreCount] = scoresList.size() + 1;
			else {
				for (int index = 0; index < scoresList.size() - 1; index++) {
					if (scoresList.get(index) > aliceScore && scoresList.get(index + 1) < aliceScore) {
						rankResult[aliceScoreCount] = index + 2;
						break;
					}
				}
			}
		}

		return rankResult;
	}

	public static void main(String[] args) {
		int[] scores = { 100, 100, 50, 40, 40, 20, 10 };
		int[] alice = { 5, 25, 50, 120 };

		int[] result = climbingLeaderboard(scores, alice);
		for (int rank : result)
			System.out.println(rank);

	}

}
