package com.hbrnt.app;

import com.hbrnt.utl.HibernateUtils;

public class ConnectionTest {

	public static void main(String[] args) {
		HibernateUtils.getSessionFactory();
		System.out.println("Success");

	}

}
