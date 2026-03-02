package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.Junit.JunitPractice;

@TestInstance(Lifecycle.PER_CLASS)
class JunitPracticeTest {
	
	JunitPractice jp = new JunitPractice();
	
	@BeforeEach
	public void start() {
		System.out.println("Before Each");
	}
	@AfterAll
	public void end() {
		System.out.println("finish");
	}
	
	@Test
	public void arrayTest() {
		try {
			int[] arr = null;
			for (int num : arr) {
				System.out.println(num);
			}
		} catch (NullPointerException e) {
			System.out.println("Exception Handled");
		}
	}
	
	@Test
	void revTest() {
		assertEquals(2 , 2);
		System.out.println("RevTest");
	}

}
