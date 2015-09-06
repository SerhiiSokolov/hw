package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import impexp.ImpExp;
import impexp.xmlClass;
import person.Person;

public class DS_XML implements DS {
	ArrayList<Person> pp=null;;
	ImpExp txt=new xmlClass();
	String tip=txt.getTip();
	File file =new File("import//import."+tip);
	@Override
	public void create(Person p) throws SQLException {
		try {
			pp = txt.impPersons(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pp.add(p);
		txt.expPersons(pp, file);
	}

	@Override
	public ArrayList<Person> read() throws SQLException {
		try {
			pp = txt.impPersons(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return pp;
	}

	@Override
	public void update(Person p) throws SQLException {
		try {
			pp = txt.impPersons(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Person tmp:pp)
		{
			if(p.getId()==tmp.getId())
			{
				tmp.setId(p.getId());
				tmp.setfName(p.getfName());
				tmp.setlName(p.getlName());
				tmp.setAge(p.getAge());
			}
		}		
		txt.expPersons(pp, file);
	}

	@Override
	public void delete(Person p) throws SQLException {
		try {
			pp = txt.impPersons(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int i=0;
		for(Person tmp:pp){			
			if(p.getId()==tmp.getId()) break;
			i++;
		}
		pp.remove(i);
		txt.expPersons(pp, file);
	}
}
