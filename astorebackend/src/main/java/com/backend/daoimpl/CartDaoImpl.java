package com.backend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	
	public void deleteProdCart(Cart cart)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//Query query = session.createQuery("delete Cart where cartproductid=:pid and cartid=:cartid");
		//query.setParameter("pid", pid);
		//query.setParameter("cartid",cartid);		 
		//query.executeUpdate();
        session.delete(cart);
        session.getTransaction().commit();
        session.close();
	}
	
	public Cart getCartById(int pid, String userEmail) {
	Session session=sessionFactory.openSession();
	Cart cr=null;
	session.beginTransaction();
	cr=(Cart)session.createQuery("from Cart where cartUserDetails=:email and cartProductID=:crid").setString("email",userEmail).setInteger("crid",pid).uniqueResult();
	session.close();
	return cr;
	}
	
	public void insertCart(Cart cart) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		
		session.getTransaction().commit();
		session.close();
		
	}
	public void updateCart(Cart cr) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(cr);
		
		session.getTransaction().commit();
		session.close();
		
	}
	public List<Cart> retrieveCart(int cid) {
		Session session=sessionFactory.openSession();
		Query<Cart> query = session.createQuery("from Cart where cartid = :code",Cart.class);
		query.setParameter("code", cid);
		List<Cart> pl=query.getResultList();
		session.close();
		return pl;
	
	}

	public void deleteCart(int cartid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Cart cr=(Cart)session.get(Cart.class,cartid);
		session.delete(cr);
		session.getTransaction().commit();
		session.close();
	}

	
	@SuppressWarnings("unchecked")
	public List<Cart> findCartByEmailId(String email) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Cart> cr=null;
		try {
			
			 cr = (List<Cart>) session.createQuery("from Cart where cartUserDetails=:email").setString("email",email).getResultList();
			
			session.close();
			
			
		}catch(HibernateException ex)
		{
			ex.printStackTrace();
			session.getTransaction().rollback();
			
		}
		session.close();
		return cr;
		
	}
	
}
