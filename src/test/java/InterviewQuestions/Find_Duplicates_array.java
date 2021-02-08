package InterviewQuestions;

public class Find_Duplicates_array {

	public static void main(String[] args) {
		String names[]={"manish", "vicky", "adi", "manish", "adi"};
          
		//compare each element
		for(int i=0; i<names.length; i++){
			for(int j=i+1; j<names.length; j++){
				if(names[i].equals(names[j])){
					System.out.println("duplicate is " + names[i]);
				}
			}
			
		}
	}

}
