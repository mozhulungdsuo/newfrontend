package com.backend.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.backend.dao.OrderDao;
import com.backend.model.Order;
import com.backend.model.Product;

@Repository
@Service
@Transactional
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	public OrderDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public void insert(Order order) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.saveOrUpdate(order);
		session.getTransaction().commit();
		
	}
	
}
