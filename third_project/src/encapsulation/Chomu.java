package encapsulation;

public class Chomu {
	public static void main(String[] args) {
		short pin = 123;
		HalkuKaAcc halkuKaAcc = new HalkuKaAcc();
		System.out.println(halkuKaAcc.getBal(pin));
	}
}
