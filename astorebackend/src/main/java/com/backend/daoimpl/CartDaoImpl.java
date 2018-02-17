package com.backend.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.backend.dao.CartDao;
import com.backend.model.Cart;

@Repository
@Service
@Transactional
public class CartDaoImpl implements CartDao{
	

	@Autowired
	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public Cart getCartById(int cartId, String userEmail) {
	Session session=sessionFactory.openSession();
	Cart cr=null;
	session.beginTransaction();
	cr=(Cart)session.createQuery("from Cart where cartUserDetailsl=:email and cartProductID=:crid").setString("email",userEmail).setInteger("crid",cartId).uniqueResult();
	
	return cr;
	}
}
