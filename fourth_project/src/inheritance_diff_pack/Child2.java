package inheritance_diff_pack;

import inheritance.Parent;

public class Child2 extends Parent{
	int c = 6;
//	showP(); // why not ?? and how to 
	void showChild2() {
		System.out.println("This is in diff package extending parent");
	}
}
