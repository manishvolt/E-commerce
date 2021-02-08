package InterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Collections {

public static void main(String[] args) {
	// TODO Auto-generated method stub
//List <String> L =new ArrayList<>();

LinkedList<String> L=new LinkedList<>(); 

//List<String> L=new Vector<>();

L.add("abc");
L.add("xyz");
L.add("qwe");
L.addFirst("Manish");  //linkedlist options
L.addLast("Nighut");
L.set(1, "hello");    //insertion

System.out.println(L.get(1));


//map interface
// hasmap

HashMap<Integer, String> hm=new HashMap<Integer, String>();
hm.put(1, "selenium");
hm.put(2, "qtp");
hm.put(3, "ide");

System.out.println(hm.get(1));

for(Entry m: hm.entrySet()){
	System.out.println(m.getKey() + " " + m.getValue());
}
}





}