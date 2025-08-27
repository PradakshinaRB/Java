package com.example.polymorphism;

public class Admin extends User {
	 @Override
	 public void login() {
		 System.out.println("Admin logged in with admin privileges.");
	    }
}

package com.example.polymorphism;

public class Customer extends User {
	 @Override
	 public void login() {
		 System.out.println("Customer logged in with limited access.");
	 }

}
package com.example.polymorphism;

public class PolymorphismDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Pradakshina RB");
		System.out.println("2117240070224");
		User user1=new Admin();
		User user2=new Customer();
		user1.login();
		user2.login();

	}

}
package com.example.polymorphism;

public class User {
	public void login() {
        System.out.println("User logging in...");
    }

}
