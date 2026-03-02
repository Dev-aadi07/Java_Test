package notes;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface MathOperation {
	public int operate (int a, int b);
}

class sumOperation implements MathOperation {
	@Override
	public int operate (int a, int b) {
		return a+b;
	}
}
public class UnaryStreamUnderstanding {

	public static void main(String[] args) {
		//Java 8 --> minimal Coding, functional programming
		//Java 8 -> Lambda Expression, Streams, Date & Time, API
		
		//Lambda Expression -> It is an anonymous function (no access modifier, no return type, no name)
		sumOperation sum = new sumOperation(); //Traditional
		System.out.println(sum.operate(3, 6));
		
		MathOperation mo = (a,b) -> a+b; // Functional Interface ka refer use kar rahe to hold lambda expression
		MathOperation so = (a,b) -> a-b; // implies functional programming
		System.out.println(mo.operate(3, 4));
		System.out.println(so.operate(3, 4));
		
//=====================================FUNCTIONAL INTERFACE========================================================
		
		//Predicate -> functional Interface (Boolean values fun)
		//Predicate -> only hold the condition (True or false)
		
		System.out.println("\nPREDICATE");
		Predicate<Integer> isEven = x-> x % 2 == 0;
		System.out.println(isEven.test(4));
		
		Predicate<String> isStartWithA = s->s.toLowerCase().startsWith("a");
		Predicate<String> isEndWithA = s->s.toLowerCase().endsWith("a");
		Predicate<String> ans = isStartWithA.and(isEndWithA);
		
		System.out.println(ans.test("Amulya"));
		
//==============================================FUNCTION===========================================================
		System.out.println("\nFUNCTION"); //interface that do work and return smthn for you 
		Function<Integer, Integer> doubleIt = n->2*n;
		Function<Integer, Integer> tripleIt = n->3*n;
		System.out.println(doubleIt.apply(5)); // abstract method
		System.out.println(doubleIt.andThen(tripleIt).apply(5)); //default method
		
		Function<Integer, Integer> identity = Function.identity();
		System.out.println(identity.apply(5)); // static method
		
//==============================================CONSUMER==========================================================
		System.out.println("\nCONSUMER"); //--> not returning anything just consuming, use to print smthn
		
		Consumer<Integer> print = x-> System.out.println(x);
		print.accept(78);
		
		List<Integer> list = Arrays.asList(2,3,4,5);
		
		Consumer<List<Integer>> printList = x -> {
			for (int i: x) System.out.print(i+" ");
		};
		
		printList.accept(list);
		
		Consumer<Integer> c = new Consumer<Integer>() {
			public void accept(Integer x) {
				System.out.println(x);
			}
		};
		
		c.accept(67);
		Consumer<Integer> ct = System.out::println;
		ct.accept(500000);
		
		list.forEach(n->System.out.print(n+" "));
		
//==============================================SUPPLIER==========================================================
		System.out.println("\n\nSUPPLIER"); //->takes nothing as parameter, only gives
		Supplier<Integer> s = () -> 6;
		System.out.println(s.get());
		
		Supplier<String> msg = () -> "Hello world";
		System.out.println(msg.get());
		
//===========================================COMBINATION==========================================================
		System.out.println("\nCOMBINED EXAMPLE");
		Predicate<Integer> pre = x -> x%2==0;
		Function<Integer, Integer> func = x -> x*x;
		Consumer<Integer> cons = x -> System.out.println(x); // used to display
		Supplier<Integer> sup = () -> 100;   //need to put any value here as supplier is returning only
		
		if (pre.test(sup.get())) {
			cons.accept(func.apply(sup.get()));
		}
	}

}




















