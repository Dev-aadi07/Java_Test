package interfaceTeaching;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streaming {

	public static void main(String[] args) {
		//Once you consume  you can't use stream for second time
		//Doesn't effect the original list
		
		List<Integer> l = Arrays.asList(3,2,6,1,8);
		
		Stream<Integer> s = l.stream().filter(n->n%2==0).sorted();
		s.forEach(n->System.out.print(n+" "));
		
		l.stream().filter(n->n%2==0).sorted().forEach(System.out::println);
		
		List<Integer> list = Arrays.asList(5,6,7,8,9);
		list.stream().map( n -> 2*n ).forEach(System.out::println);
		
	}

}
