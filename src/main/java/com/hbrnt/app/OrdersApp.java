package com.hbrnt.app;

import java.util.Date;
import java.util.Scanner;

import com.hbrnt.dao.IOrdersDAO;
import com.hbrnt.dao.OrdersDAO;
import com.hbrnt.pojo.Orders;
import com.hbrnt.pojo.Orders_Products;

public class OrdersApp {
	static Scanner scan;
	IOrdersDAO orderDao;

	public OrdersApp() {
		orderDao = new OrdersDAO();
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {

		OrdersApp orderApp = new OrdersApp();

		System.out.println("Choose your operation: ");
		int option;

		do {
			System.out.println("\n 1. CREATE \n 2. DELETE \n 3. UPDATE \n 4. Get Order " + "\n 5. Exit");
			option = scan.nextInt();

			switch (option) {
			case 1:
				orderApp.createOrder();
				break;

			case 2:
				orderApp.deleteOrder();
				break;

			case 3:
				orderApp.updateOrder();
				break;

			case 4:
				orderApp.loadOrder();
				break;
				default:
					System.exit(0);
			}

		} while (true);
	}

	private void createOrder() {
		Orders order = new Orders("Order", new Date(), new Date(), new Date(), 1);
		Orders_Products ordPrd = new Orders_Products(2, 102, 3, 29.12);
		
		System.out.println(orderDao.createOrder(order, ordPrd));
	}

	private void deleteOrder() {
		System.out.println("Enter Order Id to Delete an order : ");
		int id = scan.nextInt();
		System.out.println(orderDao.deleteOrder(id));
	}

	private void updateOrder() {
		System.out.println("Enter Order id to Update : ");
		int id = scan.nextInt();
		Orders order = new Orders("Order", new Date(), new Date(), new Date(), 1);
		order.setOrder_ID(id);
		System.out.println(orderDao.updateOrder(order));
	}

	private void loadOrder() {
		System.out.println("Enter Order id to Load : ");
		int id = scan.nextInt();
		Orders order = (Orders) orderDao.getOrder(id);
		System.out.println(order);
	}

}
