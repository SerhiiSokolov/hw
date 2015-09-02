package impexp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import person.Person;

public class mainClass {
	public static void main(String[] args) throws FileNotFoundException {
		ImpExp impexp=new xmlClass();
		String path="d:\\java\\school\\hw\\hw_14\\src\\hw_14\\";
		File impFile=new File(path+"import."+impexp.getTip());
		ArrayList<Person> pp=impexp.impPersons(impFile);
		System.out.println(pp);
		File expFile=new File(path+"export."+impexp.getTip());
		impexp.expPersons(pp,expFile);		
	}
}
