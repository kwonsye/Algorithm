package pck1;

public class test {
	public static void main(String[] args) {
		String str=deleteChar("smiles","sde");
		System.out.println(str);
	}
	
	private static String deleteChar(String word, String string) {//(������� ��ü,���� ���ĺ�)
		// TODO Auto-generated method stub
		for(int i=0;i<string.length();i++) {
			char deleteChar=string.charAt(i);
			String deleteStr=Character.toString(deleteChar);
			word=word.replace(deleteStr,"");
		}
		return word;
	}
}
