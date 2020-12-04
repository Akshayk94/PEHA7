package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class SaveProduct 
{
	public static void main(String[] args) 
	{
		//declare resources
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		//STEP-1 ACTIVATE HIBERNATE FRAMEWORK
		cfg=new Configuration();
		
		//STEP-2 READ THE DATA FROM CFG AND MAPPING FILE
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		
		//STEP-3 BUILD CONNECTION WITH DB VENDOR
		factory=cfg.buildSessionFactory();
		
		//STEP-4 OPEN THE SESSION WITH DB VENDOR
		ses=factory.openSession();
		
		//STEP-5 CREATE AN OBJECT OF DOMAIN CLASS
		Product p1=new Product();
		p1.setProductId(1);
		p1.setProductName("LAPTOP");
		p1.setProductPrice(65000.25);
		
		//STEP-6 START THE TRANSACTION WITH DB VENDOR
		tx=ses.beginTransaction();
		
		//STEP-7 SAVE OBJECT
		ses.save(p1);
		
		//STEP-8 COMMIT TRANSACTION
		tx.commit();
		
		System.out.println("PRODUCT INSERTED SUCCESSFULLY");
	}
}
