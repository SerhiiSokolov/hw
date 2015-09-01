package db;

import java.sql.SQLException;
import java.util.ArrayList;

import person.Person;

public interface DS 
{
	void create(Person p) throws SQLException;
	ArrayList<Person> read() throws SQLException;
	void update(Person p) throws SQLException;
	void delete(Person p) throws SQLException;
}
