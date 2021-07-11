import java.util.HashMap;
import java.util.Scanner;
//show inner join of two tables
public class InnerJoin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] headers = new String[2];
		HashMap<Integer, String>[] map = new HashMap[2];
		HashMap<Integer, String> map_join = new HashMap<>();
		int colNum = 0;
		
		for (int table = 0; table < 2; table++) {
			int rowCount = sc.nextInt(); // �� ��
			sc.nextLine();
			headers[table] = sc.nextLine();
			
			int spaceCount = 0;
			for (int i = 0; i < headers[table].length(); i++) {
				if (headers[table].charAt(i) == ' ') {
					spaceCount++;
				}
			}

			colNum = spaceCount + 1;
			map[table] = new HashMap<Integer, String>();
			for (int row = 0; row < rowCount-1; row++) {
				int id = sc.nextInt();
				String colContents="";
				for (int i = 1; i < colNum; i++) {
					colContents += (sc.next()+" ");
				}
				map[table].put(id, colContents);
				
			}
		}
		/*
		for( int key : map[0].keySet()) {
			System.out.println(key+" "+ map[0].get(key));
		}
		for( int key : map[1].keySet()) {
			System.out.println(key+" "+ map[1].get(key));
		}*/
		
		//����
		for(int keyCount=1; keyCount<=map[0].size(); keyCount++) {
			String firstTable = map[0].get(keyCount);
			String secondTable ="";
			if(map[1].get(keyCount) == null) {
				for(int i=1; i<colNum; i++)
					secondTable += "NULL ";
			} else {
				secondTable = map[1].get(keyCount);
			}
			//System.out.println(firstTable + secondTable);
			map_join.put(keyCount, firstTable + secondTable);
		}
	
		
		//���
		String joinHeader = headers[0] + " " + headers[1].substring(3);
		System.out.println(joinHeader);
		for( int key : map_join.keySet()) {
			System.out.println(key+" "+ map_join.get(key));
		}
	}

}
