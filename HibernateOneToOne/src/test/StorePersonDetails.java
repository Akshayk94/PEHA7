package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Passport;
import domain.Person;

public class StorePersonDetails 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER PERSON NAME");
		String name=sc1.next();
		
		System.out.println("ENTER PERSON AGE");
		int age=sc1.nextInt();
		
		System.out.println("ENTER PASSPORT NO");
		String passportno=sc1.next();
		
		System.out.println("ENTER NAME OF COUNTRY");
		String country=sc1.next();
		
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
		
		Passport pass=new Passport();
		pass.setPassportNumber(passportno);
		pass.setCountryName(country);
		
		Person per=new Person();
		per.setPersonName(name);
		per.setPersonAge(age);
		
		per.setPassportRef(pass);
		
		tx=ses.beginTransaction();
		
		ses.save(per);
		
		tx.commit();
		
		System.out.println("PERSON DETAILS STORED SUCCESSFULLY");

	}

}
