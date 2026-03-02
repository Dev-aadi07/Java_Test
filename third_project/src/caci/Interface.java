package caci;

public interface Interface {
//	static {}; not allowed in interface
	public abstract void test();
	int num = 9;  // not a non-static but final and static kw are there in prefix implicitly
	static int statiVar = 1;
	static final int constant = 6;
}
