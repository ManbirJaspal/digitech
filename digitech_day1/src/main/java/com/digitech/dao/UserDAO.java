package com.digitech.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitech.model.User;
import com.digitech.model.UserCredentials;


@Repository
public class UserDAO {  //we keep all the methods in dao
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(User user) {
		Session session =sessionFactory.openSession();
		
		System.out.println("Insert Method Called for UserDetails");
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(user);
		session.flush();
		tx.commit();
		session.close();
   }

	public void insertcreden(UserCredentials userCreden) {
        Session session =sessionFactory.openSession();
		System.out.println("Insert Method Called for UserCredentials");
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(userCreden);
		session.flush();
		tx.commit();
		session.close();
	}
	
	public List<UserCredentials> retrieveUser()
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<UserCredentials> userlist=(ArrayList<UserCredentials>)session.createQuery("from UserCredentials").list();
		session.close();    
		return userlist;
	}
	
	public List<User> AllUser()
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<User> users=(ArrayList<User>)session.createQuery("from User").list();
		session.close();    
		return users;
	}

}

	
	


