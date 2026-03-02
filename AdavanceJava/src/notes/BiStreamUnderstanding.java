package notes;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class BiStreamUnderstanding {

	public static void main(String[] args) {
		//BiPredicate -> taking 2 func arguments and returning true false obviously
		BiPredicate<Integer, Integer> biPred = (a,b) -> (a+b)%2 == 0;
		System.out.println(biPred.test(7, 3));
		
		//BiConsumer -> accepting 2 functional arg and printing both
		BiConsumer<Integer, String> biCons = (a, b) -> {
			System.out.println(a+". "+b);
		};
		biCons.accept(1, "Aditi");
		
		//BiFunction
		BiFunction<String, String, Integer> biFun = (str1, str2) -> (str1+str2).length();
		System.out.println("Length: "+biFun.apply("aa", ""));
		
		//in BiFunction we have two category -> UnaryOperator and BinaryOperator
		UnaryOperator<Integer> uO = (a) -> a*2;
		BinaryOperator<String> bO = (a,b) -> a+b;
		System.out.println(uO.apply(6));
		System.out.println(bO.apply("Hello", " World"));
	}

}
