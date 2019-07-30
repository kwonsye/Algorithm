package pck1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ClimbingLeaderBoard {

	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		/*
		 * 1)오래 걸림 
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
		 * //리더보드에 이미 앨리스점수와 동점자가 있다면 그의 랭크를 보여주면됨 if(scoresList.contains(aliceScore)) {
		 * rankResult[aliceScoreCount]=(scoresList.indexOf(aliceScore)+1); } //리더보드에
		 * 앨리스점수와 동점인 점수가 없다면 else { scoresList.add(aliceScore); //내림차순
		 * Collections.sort(scoresList); Collections.reverse(scoresList);
		 * 
		 * rankResult[aliceScoreCount]=(scoresList.indexOf(aliceScore)+1); //지우기
		 * scoresList.remove(scoresList.indexOf(aliceScore)); } }
		 * 
		 * return rankResult;
		 */

		// 2) 다른 방법
		HashSet<Integer> scoresHashSet = new HashSet<Integer>();
		for (int score : scores)
			scoresHashSet.add(score);

		List<Integer> scoresList = new ArrayList<>(scoresHashSet);
		Collections.sort(scoresList);
		Collections.reverse(scoresList);// 내림차순 정렬

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
