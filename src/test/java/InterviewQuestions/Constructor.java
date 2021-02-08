package InterviewQuestions;

public class Constructor {

	String name;
	int age;
	
	public Constructor(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	
	
	public static void main(String[] args) {
		
		Constructor obj=new Constructor("manish", 28);
		System.out.println(obj.name);
		System.out.println(obj.age);

	}

}
