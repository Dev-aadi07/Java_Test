package objects;

public class UserDriver {

	public static void main(String[] args) {
		User u1 = new User("email@gmail.com", "12321");
		
		User u2 = new User("email08@gmail.com", "6789876", "NewTown");
		System.out.println(u1.email);
		System.out.println(u2.address);
		
	}

}
