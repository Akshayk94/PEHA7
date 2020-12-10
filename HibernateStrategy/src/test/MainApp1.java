package test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Book1;

public class MainApp1
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		
		cfg=cfg.addAnnotatedClass(Book1.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Book1 b1=new Book1();
		b1.setBookName("JAVA");
		b1.setBookPrice(2500.25);
		
		tx=ses.beginTransaction();
		
		ses.save(b1);
		
		tx.commit();
		
		System.out.println("BOOK DETAILS INSERTED SUCCESSFULLY");

	}

}
