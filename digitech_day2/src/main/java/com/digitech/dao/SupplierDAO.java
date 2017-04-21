package com.digitech.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitech.model.Supplier;

@Repository
public class SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(Supplier supplier) {
		Session session=sessionFactory.openSession();
		System.out.println("Insert Method call for Supplier-Details");
		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(supplier);
		session.flush();
		tran.commit();
		session.close();
		
	}

}
