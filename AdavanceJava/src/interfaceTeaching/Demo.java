package interfaceTeaching;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@FunctionalInterface
interface Draw {
	void Circle();
}

public class Demo {

	public static void main(String[] args) {
		
//		Draw d = ()->System.out.println("hello");
//		d.Circle();
//		
//		Function<String, Integer> f = (String s) -> s.length();
//		System.out.println(f.apply("Hellow World"));
		
		List<Integer> l = Arrays.asList(2,4,7,3,5);
		l.forEach(n->System.out.println(n));
		
	}

}
