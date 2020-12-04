package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Product;

public class DisplayAllProducts 
{

	public static void main(String[] args)
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Product.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//HQL query
		//String query="select * from product_data"
		
		Query q=ses.createQuery("select p from Product p");
	
		List<Product> productlist=q.list();
		
		System.out.println("ID\tNAME\tPRICE");
		System.out.println("--------------------------------");
		for(Product p:productlist)
		{
			System.out.println(p.getProductId()+"\t"+p.getProductName()+"\t"+p.getProductPrice());
		}
	}

}
