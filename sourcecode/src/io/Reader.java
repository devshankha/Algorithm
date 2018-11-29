package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class Reader {
	public static void main(String[] args) throws Exception {
		FileReader fr = null;
		fr = new FileReader("C:/TestInput.java");
		BufferedReader br = new BufferedReader(fr);
		String s = null;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
			
		}
	}

}
