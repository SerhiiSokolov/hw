package impexp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import person.Person;

public class xmlClass implements ImpExp {

	ArrayList<Person> pp=null;
	Person p=null;
	public String typeofSource="xml";
	Scanner scanner=null;
	BufferedWriter writer = null;

	@Override
	public String getTypeofSource() 
	{
		return typeofSource;
	}

	@Override
	public ArrayList<Person> impPersons(File file) throws FileNotFoundException 
	{
		String str="";
		pp=new ArrayList<Person>();
		scanner=new Scanner(file);

		while(scanner.hasNext()) str+=scanner.next().trim();

		scanner=new Scanner(str).useDelimiter("<data>");
		while(scanner.hasNext())
		{
			str=scanner.next().trim();
			if(str.startsWith("<id>")) 
			{
				Scanner scanner=new Scanner(str).useDelimiter("</data>");
				while(scanner.hasNext())
				{
					String person=scanner.next().replaceAll("<[/]*[id,fName,lName,age,person]*>", "").replace("\"\"", ":").replace("\"", "");
					if(person.length()!=0)
					{
						pp.add(getPerson(person));
					}
				}					
			}
		}		
		scanner.close();		
		return pp;
	}

	@Override
	public Person getPerson(String person) 
	{
		String age="";
		Scanner scanner=new Scanner(person).useDelimiter(":");
		p=new Person();
		
		p.setId(Integer.valueOf(scanner.next()));		
		p.setfName(scanner.next());		
		p.setlName(scanner.next());		
		
		if(scanner.hasNext()) age=scanner.next();
		if (age.length()!=0) p.setAge(Integer.valueOf(age));
		scanner.close();
		return p;
	}

	@Override
	public void expPersons(ArrayList<Person> pp2, File expFile) 
	{
		try
		{
			writer = new BufferedWriter( new FileWriter(expFile));
			writer.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<!DOCTYPE person import PUBLIC \"person data\">\n<person>\n");
			for(Person p:pp2)
			{	
				//writer.write("\t <data>\n");
				writer.write("\t <data>\n"
						+"\t\t<id>\""+p.getId()+"\"</id>\n"
						+"\t\t<fName>\""+p.getfName()+"\"</fName>\n"
						+"\t\t<lName>\""+p.getlName()+"\"</lName>\n"
						+"\t\t<age>\""+p.getAge()+"\"</age>\n"
						+"\t </data>\n");
			}
			writer.write("</person>");
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
