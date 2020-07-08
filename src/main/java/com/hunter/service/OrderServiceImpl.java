package com.hunter.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunter.dto.CartDTO;
import com.hunter.dto.CustomerDTO;
import com.hunter.dto.OrderDTO;
import com.hunter.dto.OrderProductDTO;
import com.hunter.model.Customer;
import com.hunter.model.OrderCustomer;
import com.hunter.repository.CustomerRepository;
import com.hunter.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderDetailService orderDetailService;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Override
	@Transactional
	public void saveOrder(Customer customer, List<CartDTO> carts) {
		OrderCustomer order = new OrderCustomer();

		Customer customerExisted = null;

		customerExisted = customerRepository.findById(customer.getId()).orElse(null);
		if (customerExisted == null) {

			customerExisted = customerRepository.save(customer);
		}

		order.setCustomer(customerExisted);

		OrderCustomer orderSaved = orderRepository.save(order);

		for (CartDTO cart : carts) {
			orderDetailService.saveOrderDetail(cart, orderSaved);
		}

	}

	@Override
	@Transactional
	public List<OrderDTO> orderInfo(int customerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("SELECT \r\n" + "    oc.order_status,\r\n" + "    oc.created_date,\r\n" + "    oc.id,\r\n"
				+ "    od.order_price,\r\n" + "    od.order_amount,\r\n" + "    pr.product_name");
		stringBuilder
				.append(" FROM\r\n" + "    order_customer oc,\r\n" + "    order_detail od,\r\n" + "    product pr");

		stringBuilder.append(" WHERE\r\n" + "    oc.id = od.order_id\r\n" + "        AND od.product_id = pr.id\r\n"
				+ "        AND oc.customer_id = " + customerId);

		@SuppressWarnings("unchecked")
		List<Object[]> listObject = entityManager.createNativeQuery(stringBuilder.toString()).getResultList();

		List<OrderDTO> orderDtoList = new ArrayList<OrderDTO>();

		for (Object[] object : listObject) {
				System.out.println("Lần thứ ID : " + object[2].toString());
				System.out.println("Data: ID " + object[2].toString() + " - Tên sản phẩm " + object[5].toString() + " *");
					int checkEixted = 0;
					for (OrderDTO orderDTO : orderDtoList) {
						if (Integer.parseInt(object[2].toString()) == orderDTO.getOrderId()) {
							System.out.println("Mã đơn hàng đã tồn tại!");
							OrderProductDTO orderProduct = new OrderProductDTO();
							orderProduct.setOrderAmount(Integer.parseInt(object[4].toString()));
							orderProduct.setOrderPrice(Double.parseDouble(object[3].toString()));
							orderProduct.setOrderProduct(object[5].toString());
							orderDTO.getOrderProduct().add(orderProduct);
							checkEixted = -1;
						}
					}
					
					if(checkEixted == 0) {
						System.out.println("Mã đơn hàng chưa tồn tại!");
						OrderDTO orderdto = new OrderDTO();
						orderdto.setOrderId(Integer.parseInt(object[2].toString()));
						orderdto.setOrderDate(object[1].toString());
						orderdto.setOrderStatus(object[0].toString());

						OrderProductDTO orderProduct = new OrderProductDTO();
						orderProduct.setOrderAmount(Integer.parseInt(object[4].toString()));
						orderProduct.setOrderPrice(Double.parseDouble(object[3].toString()));
						orderProduct.setOrderProduct(object[5].toString());

						List<OrderProductDTO> orderProductDTO = new ArrayList<OrderProductDTO>();
						orderProductDTO.add(orderProduct);
						orderdto.setOrderProduct(orderProductDTO);
						
						orderDtoList.add(orderdto);
					}
			
			System.out.println(orderDtoList);
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();

		return orderDtoList;
	}

	@Override
	public List<OrderDTO> findAllByOrder(int orderId, int begin, int end) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("SELECT oc.id,  c.name , oc.created_date, oc.order_status, SUM(od.order_price * od.order_amount) AS totalPrice ");
		stringBuilder.append("FROM customer c, order_customer oc, order_detail od ");
		stringBuilder.append("WHERE c.id = oc.customer_id AND od.order_id = oc.id ");
		stringBuilder.append("GROUP BY oc.id ");
		stringBuilder.append("LIMIT " + begin + "," + end);
		
		@SuppressWarnings("unchecked")
		List<Object[]> listObject = entityManager.createNativeQuery(stringBuilder.toString()).getResultList();
		
		List<OrderDTO> orders = new ArrayList<OrderDTO>();
		
		for (Object[] object : listObject) {
			System.out.println("Value of Object : " + object[0]);
			System.out.println("Value of Object : " + object[1]);
			System.out.println("Value of Object : " + object[2]);
			System.out.println("Value of Object : " + object[3]);
			System.out.println("Value of Object : " + object[4]);
			
			OrderDTO o = new OrderDTO();
			o.setOrderId(Integer.parseInt(object[0].toString()));
			o.setCreatedName(object[1].toString());
			o.setOrderDate(object[2].toString());
			o.setOrderStatus(object[3].toString());
			o.setTotalPrice(Double.parseDouble(object[4].toString()));
			
			orders.add(o);
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return orders;
	}

	@Override
	@Transactional
	public OrderDTO orderCustomerInfo(int orderId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("SELECT oc.id, oc.recipient_name, oc.recipient_phone, "
				+ "oc.recipient_email, oc.recipient_address,oc.order_status, c.name, c.phone, c.email, c.address ");
		stringBuilder.append("FROM order_customer oc, customer c ");
		stringBuilder.append("WHERE oc.customer_id = c.id ");
		stringBuilder.append("AND oc.id = " + orderId);
		
		@SuppressWarnings("unchecked")
		List<Object[]> listObject = entityManager.createNativeQuery(stringBuilder.toString()).getResultList();
		
		OrderDTO orderdto = new OrderDTO();
		
		for (Object[] object : listObject) {
			System.out.println("orderId: " + object[0]);
			System.out.println("recipient_name: " + object[1]);
			System.out.println("recipient_phone: " + object[2]);
			System.out.println("recipient_email: " + object[3]);
			System.out.println("recipient_address: " + object[4]);
			System.out.println("customer_name: " + object[5]);
			System.out.println("customer_phone: " + object[6]);
			System.out.println("customer_email: " + object[7]);
			System.out.println("customer_address: " + object[8]);
			
			orderdto.setOrderId(Integer.parseInt(object[0].toString()));
			orderdto.setRecipientName(object[1] == null ? null : object[1].toString());
			orderdto.setRecipientPhone(object[2] == null ? null : object[2].toString());
			orderdto.setRecipientEmail(object[3] == null ? null : object[3].toString());
			orderdto.setRecipientAddress(object[4] == null ? null : object[4].toString());
			orderdto.setOrderStatus(object[5] == null ? null : object[5].toString());
			
			CustomerDTO customer = new CustomerDTO();
			customer.setCustomerName(object[6] == null ? null : object[6].toString());
			customer.setCustomerPhone(object[7] == null ? null : object[7].toString());
			customer.setCustomerEmail(object[8] == null ? null : object[8].toString());
			customer.setCustomerAddress(object[9] == null ? null : object[9].toString());
			
			orderdto.setCustomer(customer);
		}
		
		orderdto.setOrderProduct(this.orderCustomerProduct(orderId));
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return orderdto;
	}
	
	public List<OrderProductDTO> orderCustomerProduct(int orderId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT p.product_name, od.order_amount, od.order_price ");
		stringBuilder.append("FROM order_detail od, product p ");
		stringBuilder.append("WHERE od.product_id = p.id AND od.order_id = " + orderId);
		
		@SuppressWarnings("unchecked")
		List<Object[]> listObject = entityManager.createNativeQuery(stringBuilder.toString()).getResultList();
		
		List<OrderProductDTO> products = new ArrayList<OrderProductDTO>();
		
		for (Object[] object : listObject) {
			OrderProductDTO dto = new OrderProductDTO();
			dto.setProductName(object[0] == null ? null : object[0].toString());
			dto.setOrderAmount(object[1] == null ? null : Integer.parseInt(object[1].toString()));
			dto.setOrderPrice(object[2] == null ? null : Double.parseDouble(object[2].toString()));
			products.add(dto);
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return products;
	}

}
