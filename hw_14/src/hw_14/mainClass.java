package hw_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class mainClass {
	public static void main(String[] args) throws FileNotFoundException {
		ImpExp impexp=new jsonClass();
		File impFile=new File("D:\\ssv\\hw\\hw_14\\src\\hw_14\\import."+impexp.getTip());
		ArrayList<Person> pp=impexp.impPersons(impFile);
		System.out.println(pp);
		File expFile=new File("D:\\ssv\\hw\\hw_14\\src\\hw_14\\export."+impexp.getTip());
		impexp.expPersons(pp,expFile);
	}
}
