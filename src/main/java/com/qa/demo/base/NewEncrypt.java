package com.qa.demo.base;

public class NewEncrypt extends CommonMethods2{

		public NewEncrypt() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

		public void EncryptMethod() {
			String password = "testdev1234";
			String EncrptedPassword = encrypt(password);
			System.out.println("Encrypted Password: "+EncrptedPassword);
			
			String DecryptedPassword = decrypt(EncrptedPassword);
			System.out.println("Decrypted Password: "+DecryptedPassword);
		}
		
		public static void main(String[] args) throws Exception {
			
			NewEncrypt enc = new NewEncrypt();
			enc.EncryptMethod();
					
		}
	
}
