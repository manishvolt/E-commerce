package InterviewQuestions;

public class remove_specialchar_fromstring {

	public static void main(String[] args) {
	
		String s= "manish@volt";
		//regular expression: [^a-z]  - not symbol
		s=s.replaceAll("[^a-z]", "");
		System.out.println(s);
		
		
	}

}
