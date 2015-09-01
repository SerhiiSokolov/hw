package GUI;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import db.*;
import db.DS_HibernateMySQL;
import person.Person;

public class TModel extends AbstractTableModel 
{
	private static final long serialVersionUID = -2318023680453895975L;
	DS ds = new DS_HibernateMySQL();
	ArrayList<Person> pp = null;

	public TModel() 
	{	
		try {
			pp = ds.read();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isCellEditable(int row, int column) 
	{
		return true;
	}

	public void setDS(String set) 
	{
		switch (set) {
		case "HibernateMySQL":
			ds = new DS_HibernateMySQL();
			break;
		case "Mock":
			ds = new DS_Mock();
			break;
		case "H2":
			ds = new DS_H2();
			break;
		case "MySQL":
			ds= new DS_MySQL();
			break;
		case "PostgreSQL":
			ds = new DS_PostgreSQL();
			break;
		case "MongoDB":
			ds = new DS_MongoDB();
			break;	
		default:
			ds = new DS_HibernateMySQL();
			break;
		}
		try {
			pp = ds.read();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override	
	public String getColumnName(int column) 
	{
		String[] str = {"Id","FName","LName","Age"};
		return str[column];
	}

	@Override
	public int getRowCount() 
	{
		return pp.size();
	}

	@Override
	public int getColumnCount() 
	{
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		Person p = pp.get(rowIndex);

		Object ret = null;

		switch (columnIndex) 
		{
		case 0: ret = p.getId();    break;
		case 1: ret = p.getfName(); break;
		case 2: ret = p.getlName(); break;
		case 3: ret = p.getAge();   break;
		}

		return ret;
	}

	public void read() 
	{	
		try {
			pp = ds.read();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void create(String[] args) 
	{
		Integer id=Integer.valueOf(args[0]);
		String fName=args[1];
		String lName=args[2];
		Integer age=Integer.valueOf(args[3]);
		try {
			ds.create(new Person(id, fName, lName, age));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(String[] args) 
	{
		Integer id=Integer.valueOf(args[0]);
		String fName=args[1];
		String lName=args[2];
		Integer age=Integer.valueOf(args[3]);
		try {
			ds.update(new Person(id, fName, lName, age));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int Id)
	{		
		Person temp=null;
		for(Person p:pp)
		{
			if (p.getId()==Id)
			{
				temp=p;
				break;
			}
		}
		try {
			ds.delete(temp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
