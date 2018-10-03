package pck1;

public class test {
	public static void main(String[] args) {
		String str=deleteChar("smiles","sde");
		System.out.println(str);
	}
	
	private static String deleteChar(String word, String string) {//(지우려는 주체,지울 알파벳)
		// TODO Auto-generated method stub
		for(int i=0;i<string.length();i++) {
			char deleteChar=string.charAt(i);
			String deleteStr=Character.toString(deleteChar);
			word=word.replace(deleteStr,"");
		}
		return word;
	}
}
