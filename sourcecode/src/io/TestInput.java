package io;

import java.io.FileInputStream;

public class TestInput {
	public static void main(String[] args) throws Exception{
		FileInputStream fin = null;
		int i = 0;
		try {
			fin = new FileInputStream("C:/TestInput.java");
			
		} catch (Exception e){
			e.printStackTrace();
		}
		while (i != -1) {
			i = fin.read();
			System.out.print((char)i);
			
		}
		
	}
	
	

}
