package io;

import java.io.FileWriter;

public class TestWriter {
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("Cool.txt");
		String s1 = "How are you";
		char[] ch = new char[s1.length()];
		s1.getChars(0,s1.length(),ch,0);
		fw.write(ch);
		fw.flush();
		fw.close();
	}

}
