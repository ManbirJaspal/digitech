package com.digitech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitech.model.Product;
import com.google.gson.Gson;

@Repository
public class ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public void insertProduct(Product product) {
		Session session=sessionFactory.openSession();
		System.out.println("Insert method for Product-Details");
		Transaction tran=session.getTransaction();
		tran.begin();
		session.save(product);
		session.flush();
		tran.commit();
		session.close();
		
	}

	public String Retrieve() {
		
		Session connection = sessionFactory.openSession();
		Transaction tx = connection.getTransaction();
		tx.begin();
		
		List listdata = connection.createQuery("FROM Product").list();
		Gson gson = new Gson();        //google gson is used to collect data from list. it is a class. and we are accessing two toJson() method of this class.
		String jsonNames = gson.toJson(listdata);
		tx.commit();
		connection.close();
		return jsonNames;
		
	}
	
	public void Delete(Integer cid) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Product prod = (Product)session.get(Product.class, cid);
		System.out.println("ID "+ " "+prod.getProName());
		session.delete(prod);
		session.flush();
		tx.commit();
		session.close();
		System.out.println("Deleted");
		
		
	}
	
	public Product UpdateProduct(Integer cid) {                //Used to just select the product
		Session session = sessionFactory.openSession();
		Transaction tx= session.getTransaction();
		tx.begin();
		Product prod = (Product)session.get(Product.class, cid);
		tx.commit();
		session.close();
		return prod;
				
		
	}
	
	public void FieldDataUpdate(int catID, String pName, int price , int stock, String description ) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Product prod = (Product)session.get(Product.class, catID);
		prod.setProName(pName);
		prod.setPrice(price);
		prod.setDescription(description);
		prod.setStock(stock);
		tx.commit();
		session.close();
		session.update(prod);
		System.out.println("Update method called");
		
		
	}
	
	
}

