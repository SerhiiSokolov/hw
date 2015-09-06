package impexp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import person.Person;

public class csvClass implements ImpExp
{
	ArrayList<Person> pp=null;
	public String typeofSource="csv";
	public String getTypeofSource() {
		return typeofSource;
	}

	public ArrayList<Person> impPersons(File file) throws FileNotFoundException 
	{
		pp=new ArrayList<Person>();
		Scanner scanner = new Scanner(file).useDelimiter("\\n");
		while(scanner.hasNext())
		{
			pp.add(getPerson((String)scanner.next()));
		}
		scanner.close();
		return pp;
	}

	public Person getPerson(String s) 
	{
		Scanner data=new Scanner(s).useDelimiter(",");
		Person p=new Person();
		p.setId(Integer.valueOf(data.next().trim()));
		p.setfName(data.next().trim());
		p.setlName(data.next().trim());
		if(data.hasNext()) p.setAge(Integer.valueOf(data.next().trim()));
		data.close();
		return p;
	}

	public void expPersons(ArrayList<Person> pp2, File expFile) 
	{
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter( new FileWriter(expFile));
			for(Person p:pp2)
			{	
				writer.write(p.getId()+","+p.getfName()+","+p.getlName()+","+p.getAge()+"\n");
			}
		}
		catch ( IOException e)
		{
		}
		finally
		{
			try
			{
				if ( writer != null)
					writer.close( );
			}
			catch ( IOException e)
			{
			}
		}
	}
}
