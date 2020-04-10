package com.qa.demo.base;

public class EncrptPassword extends CommonMethods{

	public static void main(String[] args) throws Exception {
		/* Please enter your password and run this class as java program 
		 * Copy Encrpyted password from Console Output 
		 * Delete entered password before leaving this class * 
		 * 
		 */
		String password = "MyIndia123";
		String EncrptedPassword = encrypt(password);
		System.out.println("Encripted Password: "+EncrptedPassword);

	}

}
