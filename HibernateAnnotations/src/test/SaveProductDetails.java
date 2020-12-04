package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class SaveProductDetails 
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER PRODUCT ID");
		int id=sc1.nextInt();
		
		System.out.println("ENTER PRODUCT NAME");
		String name=sc1.next();
		
		System.out.println("ENTER PRODUCT PRICE");
		double price=sc1.nextDouble();
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Product.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Product p1=new Product();
		p1.setProductId(id);
		p1.setProductName(name);
		p1.setProductPrice(price);
		
		tx=ses.beginTransaction();
		
		ses.save(p1);
		
		tx.commit();
		
		System.out.println("PRODUCT INSERTED SUCCESSFULLY");
	}
}
