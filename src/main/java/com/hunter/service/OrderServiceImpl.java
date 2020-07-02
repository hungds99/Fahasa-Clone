package com.hunter.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunter.dto.CartDTO;
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

}
