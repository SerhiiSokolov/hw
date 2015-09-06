package impexp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import person.Person;

public class jsonClass implements ImpExp {

	ArrayList<Person> pp=null;
	Person p=null;
	public String typeofSource="json";
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

		scanner=new Scanner(str).useDelimiter("\\{");
		while(scanner.hasNext())
		{
			str=scanner.next().trim();			
			if(str.length()!=0) {
				pp.add(getPerson(str.replace("}", "")));				
			}
		}		
		scanner.close();		
		return pp;
	}

	@Override
	public Person getPerson(String person) 
	{
		Scanner scanner=new Scanner(person).useDelimiter(",");
		p=new Person();
		p.setId((Integer.valueOf(scanner.next().replace("\"", "").replaceAll("^[a-z,A-z]*:", ""))));		
		p.setfName(scanner.next().replace("\"", "").replaceAll("^[a-z,A-z]*:", ""));		
		p.setlName(scanner.next().replace("\"", "").replaceAll("^[a-z,A-z]*:", ""));		
		String age=scanner.next().replace("\"", "").replaceAll("^[a-z,A-z]*:", "");
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
			writer.write("{");
			int i=0;
			for(Person p:pp2)
			{	
				writer.write("{");
				writer.write("\"id\":\""+p.getId()+"\","
						+"\"fName\":\""+p.getfName()+"\","
						+"\"lName\":\""+p.getlName()+"\","
						+"\"age\":\""+p.getAge()+"\"");
				if(++i<pp2.size())writer.write("},\n");
				else writer.write("}");
			}
			writer.write("}");
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
