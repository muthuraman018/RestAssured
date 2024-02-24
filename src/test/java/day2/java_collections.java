package day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class java_collections {
	
public void listmethod() {
	List<String> arraylist2 = new ArrayList<String>();
	
	List arraylist = new ArrayList();
	arraylist.add("muthu");
	arraylist.add("raman");
	arraylist.get(0);
//	arraylist.remove(0);
//	arraylist.clear();
System.out.println(arraylist);
arraylist.addAll(arraylist2);
for(int i =0; i<arraylist2.size();i++ ) {
	System.out.println(arraylist2.get(i));
	
}

LinkedList ll = new LinkedList();
ll.add("ravi");
ll.add("rajan");
ll.remove();
ll.poll();

System.out.println(ll);
System.out.println(ll.indexOf("rajan"));



	}

//set
public void set() {
	HashSet<String> set = new HashSet<String>();
	set.add("set ravi");
	set.add("set raju");
	set.contains("set");
	set.remove("set");
	Iterator<String> it = set.iterator();
	while(it.hasNext()) {
		System.out.println(it.next());
	}
//	linked hashset, insertion order  maintained 
	LinkedHashSet lh = new LinkedHashSet();
	lh.add("muthu");
	lh.add("rajan");
	lh.add("rajan");
	lh.size();
//	Treeset  natural sorting order binary search ,heterogenous not allowed headset tailset null insertion not allowed
	TreeSet ts = new TreeSet();
	ts.add("raju");
	ts.add("rajiv");
	ts.add("rajesh");
	ts.descendingSet();
	Iterator<Integer> iti = ts.iterator();
}
//Hashmap linkedHashMap, treemap
public void map() {
	HashMap hp = new HashMap();
	hp.put("name", "muthu"); //entry
	hp.put("muthu", "muthu");
//	hp.clear();
	boolean con = hp.containsKey("muthu");
	System.out.println(hp.keySet());
//	in hashmap insertion order is preserved
	
}


	public static void main(String[] args) {
		java_collections jc =new java_collections();
		jc.listmethod();
		jc.map();
		
	}
}
