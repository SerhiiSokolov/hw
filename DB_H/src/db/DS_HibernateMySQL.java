package db;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import hibernate.HibernateUtil;
import person.Person;

public class DS_HibernateMySQL implements DS {

	@Override
	public void create(Person person) throws SQLException {
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(person);
			session.getTransaction().commit();
			HibernateUtil.shutdown();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {

				session.close();
			}
		}
	}

	@Override
	public ArrayList<Person> read() {
		ArrayList<Person> pp = new ArrayList<Person>();
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			pp = (ArrayList<Person>)session.createCriteria(Person.class).list();
			HibernateUtil.shutdown();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {

				session.close();
			}
		}
		return pp;
	}

	@Override
	public void update(Person person) {
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(person);
			session.getTransaction().commit();
			HibernateUtil.shutdown();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {

				session.close();
			}
		}
	}

	@Override
	public void delete(Person person) {
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(person);
			session.getTransaction().commit();
			HibernateUtil.shutdown();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {

				session.close();
			}
		}
	}	
}
