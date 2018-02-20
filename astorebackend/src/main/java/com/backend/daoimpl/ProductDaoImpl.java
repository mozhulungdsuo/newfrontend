package com.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.backend.dao.ProductDao;
import com.backend.model.Category;
import com.backend.model.Product;
import com.backend.model.Supplier;

@Repository
@Service
@Transactional
public class ProductDaoImpl implements ProductDao{
	@Autowired
	SessionFactory sessionFactory;
	//@Autowired
	//roductDao productdao;
	@Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
    }
	//@Transactional
	public void insertProduct(Product product) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
		
	}
	//@Transactional
	public	void deleteProduct(Product product) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.delete(product);
		session.getTransaction().commit();
	}
	public List<Category> retrieveCategory() {
		Session session=sessionFactory.openSession();
		return session.createQuery("FROM Category" ,Category.class).getResultList();
	}
	public List<Supplier> retrieveSupplier() {
		Session session=sessionFactory.openSession();
		return session.createQuery("FROM Supplier" ,Supplier.class).getResultList();
	}
	public Category CgetByID(String cid) {
		Session session=sessionFactory.openSession();
		return session.get(Category.class,cid);

	}
	public Supplier SgetByID(String sid) {
		Session session=sessionFactory.openSession();
		return session.get(Supplier.class,sid);

	}
	public Product getProductbyID(String pid) {
		Session session=sessionFactory.openSession();
		return session.get(Product.class,pid);

	}
	public List<Product> retrieveProducts() {
		Session session=sessionFactory.openSession();
		return session.createQuery("FROM Product" ,Product.class).getResultList();
	}



}
