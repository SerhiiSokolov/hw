package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import person.Person;

public class DS_MongoDB implements DS {
	@Override
	public void create(Person p) {
		ArrayList<Person> pp = new ArrayList<Person>();
		MongoClientURI conn=new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongoClient = new MongoClient(conn);
		MongoDatabase database=mongoClient.getDatabase("test");
		MongoCollection<Document> collection =database.getCollection("person");
		
		Document doc=new Document("id", p.getId())
				.append("fName", p.getfName())
				.append("lName",p.getlName())
				.append("age", p.getAge());
		collection.insertOne(doc);
		mongoClient.close();
	}

	@Override
	public ArrayList<Person> read() {
		ArrayList<Person> pp = new ArrayList<Person>();
		MongoClientURI conn=new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongoClient = new MongoClient(conn);
		MongoDatabase database=mongoClient.getDatabase("test");
		MongoCollection<Document> collection =database.getCollection("person");

		for (Document cur : collection.find()) {
			pp.add(new Person(
					cur.getInteger("id"),
					cur.getString("fName"),
					cur.getString("lName"),
					cur.getInteger("age")));
		}
		mongoClient.close();
		return pp;
	}

	@Override
	public void update(Person p) {
		MongoClientURI conn=new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongoClient = new MongoClient(conn);
		MongoDatabase database=mongoClient.getDatabase("test");
		MongoCollection<Document> collection =database.getCollection("person");
		Document update=new Document("$set", new Document("fName",p.getfName())
				.append("lName", p.getlName()).append("age", p.getAge()));
		collection.updateOne(Filters.eq("id", p.getId()), update);
		mongoClient.close();
	}

	@Override
	public void delete(Person p) {
		MongoClientURI conn=new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongoClient = new MongoClient(conn);
		MongoDatabase database=mongoClient.getDatabase("test");
		MongoCollection<Document> collection =database.getCollection("person");
		collection.deleteOne(Filters.eq("id",p.getId()));
		mongoClient.close();
	}
}
