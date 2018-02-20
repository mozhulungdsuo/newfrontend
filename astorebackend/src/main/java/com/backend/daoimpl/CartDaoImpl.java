package com.backend.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.backend.dao.CartDao;
import com.backend.model.Cart;
import com.backend.model.Category;
import com.backend.model.Product;

@Repository
@Service
@Transactional
public class CartDaoImpl implements CartDao{
	

	@Autowired
	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public Cart getCartById(String pid, String userEmail) {
	Session session=sessionFactory.openSession();
	Cart cr=null;
	session.beginTransaction();
	cr=(Cart)session.createQuery("from Cart where cartUserDetails=:email and cartProductID=:crid").setString("email",userEmail).setString("crid",pid).uniqueResult();
	
	return cr;
	}
	public void insertCart(Cart cart) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.saveOrUpdate(cart);
		session.getTransaction().commit();
		
	}
	
}
