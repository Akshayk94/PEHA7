package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Passport;
import domain.Person;

public class DisplayPersonDetails 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Passport.class);
		cfg=cfg.addAnnotatedClass(Person.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Criteria crt=ses.createCriteria(Person.class);
		
		List<Person> personlist=crt.list();

		System.out.println("NAME\tAGE\tPASSPORTNO\tCOUNTRY");
		System.out.println("----------------------------------------------------------------");

		for(Person p:personlist)
		{
			System.out.println(p.getPersonName()+"\t"+p.getPersonAge()+"\t"+p.getPassportRef().getPassportNumber()+"\t"+p.getPassportRef().getCountryName());
			System.out.println("----------------------------------------------------------------");
		}
			
	}

}
