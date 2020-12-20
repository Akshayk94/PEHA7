package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Passport;
import domain.Person;

public class SavePersonDetails 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		
		cfg=cfg.addAnnotatedClass(Passport.class);
		cfg=cfg.addAnnotatedClass(Person.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//OBJECTS OF DOMAIN CLASSES
		Passport pass=new Passport();
		pass.setPassportNumber("DC2564FG");
		pass.setCountryName("INDIA");
		
		Person per=new Person();
		per.setPersonName("PRAVIN");
		per.setPersonAge(28);
		
		//ASSOCIATE PASSPORT OBJECT WITH PERSON OBJECT
		per.setPassportRef(pass);

		tx=ses.beginTransaction();
		
		ses.save(per);
		
		tx.commit();
		
		System.out.println("PERSON DETAILS STORED SUCCESSFULLY");
	}

}
