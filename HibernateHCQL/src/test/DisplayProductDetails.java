package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import domain.Product;

public class DisplayProductDetails
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
		
		//create a criteria to display all product details
		
		Criteria crt1=ses.createCriteria(Product.class);
		
		List<Product> products=crt1.list();
		
		System.out.println("ID\tNAME\tPRICE");
		for(Product p:products)
		{
			System.out.println(p.getProductId()+"\t"+p.getProductName()+"\t"+p.getProductPrice());
		}
		
		System.out.println("**************************************************");
		//create a criteria to display details from specific column
		
		//select=========>1) selection 2) projection 3) join
		
		Criteria crt2=ses.createCriteria(Product.class);
		
		crt2.setProjection(Projections.property("productName"));
		
		List<String> productnames=crt2.list();
		
		for(String s: productnames)
		{
			System.out.println(s);
		}
		System.out.println("**************************************************");

		// create a criteria to display details from two or more columns
		
		Criteria crt3=ses.createCriteria(Product.class);
		
		ProjectionList plist=Projections.projectionList();
		plist.add(Projections.property("productName"));
		plist.add(Projections.property("productPrice"));
		
		crt3.setProjection(plist);
		
		List products1=crt3.list();
		
		Iterator itr=products1.iterator();
		
		while(itr.hasNext())
		{
			Object[] arr1=(Object[]) itr.next();
			
			//arr1[0]==productName ,  arr1[1]==productPrice
			System.out.println(arr1[0]+"\t"+arr1[1]);
		}
	}
}
