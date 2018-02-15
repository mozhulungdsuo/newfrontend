package com.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.backend.dao.UserDao;
import com.backend.daoimpl.CartDaoImpl;
import com.backend.daoimpl.CategoryDaoImpl;
import com.backend.daoimpl.OrderDaoImpl;
//import com.backend.daoimpl.CategoryDaoImpl;
import com.backend.daoimpl.SupplierDaoImpl;
import com.backend.daoimpl.UserDaoImpl;
import com.backend.model.Cart;
import com.backend.model.Category;
import com.backend.model.Order;
import com.backend.model.Product;
import com.backend.model.Supplier;
import com.backend.model.User;

@Configuration
@ComponentScan("com.backend")
@EnableTransactionManagement
public class HibernateConfig {
	//@Autowired
	//UserDaoImpl userDaoImpl;
   @Autowired
    @Bean(name="datasource")
    public  DataSource getH2Data()
    {
    	System.out.println("hibernate bean init");
    	DriverManagerDataSource dsource=new DriverManagerDataSource();
    	System.out.println("ho");
    	dsource.setDriverClassName("org.h2.Driver");
    	dsource.setUrl("jdbc:h2:tcp://localhost/~/test");
    	dsource.setUsername("sa");
    	dsource.setPassword("");
    	System.out.println("H2 connected");
    	return dsource;

    }
    private  Properties gethiberProp()
    {   
    	Properties p=new Properties();
    	p.put("hibernate.dailect","org.hibernate.dailect.H2Dailect");
    	p.put("hibernate.hbm2ddl.auto","update");
    	p.put("hibernate.show_sql","true");
    	System.out.println("Data table created in H2");
    	return p;
    	
    	
    }
	

	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFac(DataSource datasource) {
		LocalSessionFactoryBuilder sb=new LocalSessionFactoryBuilder(datasource);
		//sb.scanPackages("com.backend.model");
		
		sb.addAnnotatedClass(User.class);
		 sb.addAnnotatedClass(Supplier.class);
		  sb.addAnnotatedClass(Category.class);
		  sb.addAnnotatedClass(Product.class);
		  sb.addAnnotatedClass(Cart.class);
		  sb.addAnnotatedClass(Order.class);
		  sb.addProperties(gethiberProp());
		return sb.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="supplierDaoImpl")
	public SupplierDaoImpl getSupplierData(SessionFactory sf)
	{
		return new SupplierDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="categoryDaoImpl")
	public CategoryDaoImpl getcategoryData(SessionFactory sf)
	{
		return new CategoryDaoImpl(sf);
	}
	
	
	@Autowired
	@Bean(name="userDaoImpl")
	public UserDaoImpl getuserData(SessionFactory sf)
	{
		return new UserDaoImpl(sf);
	}
	@Autowired
	@Bean(name="cartDaoImpl")
	public CartDaoImpl getCartData(SessionFactory sf)
	{
		return new CartDaoImpl(sf);
		
	}
	@Autowired
	@Bean(name="orderDaoImpl")
	public OrderDaoImpl getOrderData(SessionFactory sf)
	{
		return new OrderDaoImpl(sf);
	}
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager gettrans(SessionFactory sf)
	{
		HibernateTransactionManager tm= new HibernateTransactionManager(sf);
		return tm;
	}
	
}
