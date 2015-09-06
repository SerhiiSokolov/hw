package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import impexp.ImpExp;
import impexp.jsonClass;
import person.Person;

public class DS_JSON implements DS {
	ArrayList<Person> pp=null;;
	ImpExp source=new jsonClass();
	String typeofSource=source.getTypeofSource();
	File file =new File("import//import."+typeofSource);
	@Override
	public void create(Person p) throws SQLException {
		try {
			pp = source.impPersons(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pp.add(p);
		source.expPersons(pp, file);
	}

	@Override
	public ArrayList<Person> read() throws SQLException {
		try {
			pp = source.impPersons(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return pp;
	}

	@Override
	public void update(Person p) throws SQLException {
		try {
			pp = source.impPersons(file);
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
		source.expPersons(pp, file);
	}

	@Override
	public void delete(Person p) throws SQLException {
		try {
			pp = source.impPersons(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int i=0;
		for(Person tmp:pp){			
			if(p.getId()==tmp.getId()) break;
			i++;
		}
		pp.remove(i);
		source.expPersons(pp, file);
	}
}
