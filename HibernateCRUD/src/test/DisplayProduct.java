package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class DisplayProduct 
{
	public static void main(String[] args)
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Product p1=ses.load(Product.class, 1);
		
		System.out.println("PRODUCT ID IS "+p1.getProductId());
		System.out.println("PRODUCT NAME IS "+p1.getProductName());
		System.out.println("PRODUCT PRICE IS "+p1.getProductPrice());
	}
}
