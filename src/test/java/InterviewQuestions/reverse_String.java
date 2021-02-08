package InterviewQuestions;

public class reverse_String {

	public static void main(String[] args) {
		
		String s="Selenium";
		int length=s.length();
		String reverse="";
		for(int i=length-1; i>=0; i--){
			
			reverse=reverse + s.charAt(i); //this gives 
			}

		System.out.println(reverse);
		StringBuffer a=new StringBuffer(s);
		System.out.println(a.reverse());
	}

	
	
	
}
