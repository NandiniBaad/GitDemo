import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

import com.google.common.collect.Streams;

public class Test1 {
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> list2= new ArrayList<String>();
		list2.add("Aniket");list2.add("Vinutha");list2.add("Joe");
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekya");
		names.add("Adam");
		names.add("Ram");
		int count =0;
		for(int i=0;i<names.size();i++) {
			String actual = names.get(i);
			if(actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
		long c = names.stream().filter(s->s.startsWith("A")).count();//filter is intermediate operation and count is terminal operation
		System.out.println(c + "Value of c");
		Stream.of("Abhhijeet","Don","Alekya","Adam","Ram").filter(s->s.startsWith("A"));
		Stream.of("Abhhijeet","Don","Alekya","Adam","Ram").filter(s->s.length()>4).forEach(s->System.out.println(s));
		Stream.of("Abhhijeet","Don","Alekya","Adam","Ram").filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		Streams.concat(names.stream(),list2.stream()).sorted().forEach(s->System.out.println(s));//method 1
		Stream<String> streamArr = Streams.concat(names.stream(),list2.stream());//method 2
//		streamArr.sorted().forEach(s->System.out.println(s));
		boolean val = streamArr.anyMatch(s->s.equalsIgnoreCase("Ram"));
		Assert.assertTrue(val);
		streamMap();
		streamCollect();
	}
	
	
	//print names len >4 and convert it to uppercase
	void streamMap() {
		
		Stream.of("Abhhijeet","Don","Alekya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		String[] n = {"abc","abbg","yytz"}; 
		Arrays.asList(n).stream().filter(s->s.startsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
	
	void streamCollect() {
		//collect result and convert it back to list
		List<String> ls = Stream.of("Abhhijeet","Don","Alekya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		List<Integer> values =  Arrays.asList(3,4,2,3,3,5,9,9,1);
		values.stream().distinct().sorted().limit(2).forEach(v -> System.out.println(v));//put in collector and get(3) will get 3rd ele in list
	}
	 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 t= new Test1();
		t.regular();

	}

}
