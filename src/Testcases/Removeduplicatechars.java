package Testcases;

public class Removeduplicatechars {
	public static void main(String[] args) {
		String name="Hello my name is harish";
		String[] name2=name.split(" ");
		int length=name2.length;
		String subword="";
		char ch = '\0';
		for(int i=0;i<=length-1;i++)
		{
			String word=name2[i];
			
			for(int j=0;j<=word.length()-1;j++){
				
				
				 ch=word.charAt(j);
				
				if(subword.contains(Character.toString(ch))){
					
				}
				else
				{
					subword=subword+ch;
				}
			}
			
		}
		System.out.println(subword);
	}

}
