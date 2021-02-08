package InterviewQuestions;

public class reverse_integer {

	public static void main(String[] args) {
		int a=123456;
		StringBuffer b=new StringBuffer(String.valueOf(a));
		System.out.println(b.reverse());
        
		int reverse=0;
		while(a!=0){
			reverse= reverse*10 + a % 10;
			a=a/10;
			}
		System.out.println(reverse);
		
	}

}
