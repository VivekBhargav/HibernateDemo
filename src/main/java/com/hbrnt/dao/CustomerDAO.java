package com.hbrnt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.hbrnt.pojo.Customer;
import com.hbrnt.pojo.ReportBean;
import com.hbrnt.utl.HibernateUtils;

public class CustomerDAO implements ICustomerDAO {

	SessionFactory sf;

	public CustomerDAO() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean status = false;
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(customer);
			transaction.commit();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		boolean status = false;
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Customer customer = (Customer) session.load(Customer.class, customerId);
		if (!customer.equals(null)) {
			session.delete(customer);
			session.getTransaction().commit();
			status = true;
		}
		session.close();
		return status;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		boolean status = false;
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		if (!customer.equals(null)) {
			session.beginTransaction();
			session.update(customer);
			session.getTransaction().commit();
			status = true;
		}

		session.close();
		return status;
	}

	@Override
	public Customer loadCustomer(int customerId) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, customerId);
		session.getTransaction().commit();
		session.close();
		return customer;
	}

	@Override
	public List<Customer> getCustomers(String zipCode) {
		sf = HibernateUtils.getSessionFactory();
		
		Session session = sf.openSession();
		Query query = session.createQuery("from Customer where zip = :zipCode ");
		query.setParameter("zipCode", zipCode);
		List<Customer> customers = query.list();
		return customers;
	}

	@Override
	public Map<String, Double> getMonthlySales(int year) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("select MONTH(ord.invDate), \r\n" + 
				"SUM(orP.quantity * orP.price) \r\n" + 
				"from Orders as ord, Orders_Products as orP \r\n" + 
				"where ord.order_ID = orP.orderId and year(ord.invDate) = :yr\r\n" + 
				"GROUP BY MONTH(ord.invDate)");
		query.setParameter("yr", year);
		List<List<Object>> result = query.setResultTransformer(Transformers.TO_LIST).list();
		Map<String, Double> map = new HashMap<>();
		for(List<Object> listObj : result) {
			map.put((listObj.get(0)).toString(), (Double)listObj.get(1));
		}
		session.close();
		return map;
	}

	@Override
	public List<ReportBean> getReport(int month) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("select new com.hbrnt.pojo.ReportBean(A.custID, A.firstName, C.quantity, C.price) \r\n" + 
				"from Customer as A, Orders as B, Orders_Products as C \r\n" + 
				"where A.custID = B.custId and B.order_ID = C.orderId and month(B.invDate) = :mont \r\n" + 
				"order by month(B.invDate)");
		query.setParameter("mont", month);
		List<ReportBean> result = query.list();
		session.close();
		return result;
	}

}
