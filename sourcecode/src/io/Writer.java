package io;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Writer implements Serializable {
	 private void writeObject(ObjectOutputStream o) {
		System.out.println("In thw writing serialization");
		
	}
	 private void readObject(ObjectInputStream s) {
		
	}
	public static void main(String[] args) throws Exception{
		OutputStream s1 = new FileOutputStream("D:\\David.txt");
		String val = "It is very good";
		byte[] b =val.getBytes();
		s1.write(b);
		s1.flush();
		s1.close();
		Writer w = new Writer();
		OutputStream k = new FileOutputStream("D:\\Obno");
		ObjectOutputStream mn = new ObjectOutputStream(k);
		mn.writeObject(w);
		mn.flush();mn.close();
		
	}

}
