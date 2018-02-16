package com.backend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.backend.dao.CategoryDao;
import com.backend.model.Category;
import com.backend.model.Product;

@Repository
@Service
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;
	//@Autowired
	//CategoryDao categorydao;
	@Autowired
    public CategoryDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
    }
	//@Transactional
	public void insertCategory(Category category) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.saveOrUpdate(category);
		session.getTransaction().commit();
		
	}
	
	//public void getCatByID(String cid) {
		//add today
	//}
	//@Transactional
	public void deleteCategory(Category category) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.delete(category);
		session.getTransaction().commit();
	}
	public List<Product> retrieveProduct(String cid) {
		Session session=sessionFactory.openSession();
		Query<Product> query = session.createQuery("from Product where cid = :code",Product.class);
		query.setParameter("code", cid);
		List<Product> pl=query.getResultList();
		return pl;
	
	}
}
