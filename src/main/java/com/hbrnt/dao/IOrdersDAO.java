package com.hbrnt.dao;

import com.hbrnt.pojo.Orders;
import com.hbrnt.pojo.Orders_Products;

public interface IOrdersDAO {
	boolean createOrder(Orders order, Orders_Products ordPrd);
	boolean deleteOrder(int orderId);
	boolean updateOrder(Orders order);
	Orders getOrder(int orderId);
}
