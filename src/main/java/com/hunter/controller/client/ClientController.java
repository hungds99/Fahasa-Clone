package com.hunter.controller.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hunter.dto.CartDTO;
import com.hunter.dto.OrderDTO;
import com.hunter.dto.ProductCatalog;
import com.hunter.dto.ProductViewDTO;
import com.hunter.model.Customer;
import com.hunter.repository.CustomerRepository;
import com.hunter.service.CategoryService;
import com.hunter.service.CustomerService;
import com.hunter.service.OrderService;
import com.hunter.service.ProductService;
import com.hunter.utils.ViewName;

@Controller
@RequestMapping("/")
public class ClientController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;

	@GetMapping
	public String getHomePage(Model model, HttpServletRequest request) {
		HttpSession session = (HttpSession) request.getSession();
		@SuppressWarnings("unchecked")
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");

		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());

		return ViewName.CLIENT_HOME_PAGE;
	}

	@GetMapping("san-pham/{productId}")
	public String getDetailPage(@PathVariable("productId") int productId, Model model, HttpServletRequest request) {
		ProductViewDTO productViewDTO = productService.getProductByProductId(productId);

		HttpSession session = (HttpSession) request.getSession();
		@SuppressWarnings("unchecked")
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");

		model.addAttribute("product", productViewDTO);
		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());

		return ViewName.CLIENT_DETAIL_PAGE;
	}
	
	@GetMapping("/catalog/search")
	public String getSearchPage(@RequestParam("q") String q, Model model, HttpServletRequest request) {
		System.out.println(q);
		List<ProductViewDTO> listViewDTO = productService.getProductBySearch(q, "Comming_Soon", 1, 24);
		
		HttpSession session = (HttpSession) request.getSession();
		@SuppressWarnings("unchecked")
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");

		model.addAttribute("productList", listViewDTO);
		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());
		model.addAttribute("viewName", "resultSearch");
		
		return ViewName.CLIENT_LIST_PAGE;
	}

	@GetMapping("danh-muc/{categoryId}")
	public String getCategoryProductPage(@PathVariable("categoryId") int categoryId, Model model,
			HttpServletRequest request) {

		ProductCatalog catalog = productService.getProductCatalog(categoryId);

		model.addAttribute("category", catalog.getCategory());
		model.addAttribute("parentCategories", catalog.getParent_categories());

		model.addAttribute("productList", catalog.getProductList());

//		model.addAttribute("catalog", catalog);

		HttpSession session = (HttpSession) request.getSession();
		@SuppressWarnings("unchecked")
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");

		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());
		model.addAttribute("viewName", "resultList");

		return ViewName.CLIENT_LIST_PAGE;
	}

	@GetMapping("kiem-tra-gio-hang")
	public String getCartPage(HttpServletRequest request, Model model) {
		HttpSession session = (HttpSession) request.getSession();
		@SuppressWarnings("unchecked")
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");

		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());

		return ViewName.CLIENT_CART_PAGE;
	}

	@GetMapping("tien-hanh-thanh-toan")
	public String getPaymentPage(HttpServletRequest request, Model model) {
		HttpSession session = (HttpSession) request.getSession();
		@SuppressWarnings("unchecked")
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");

		model.addAttribute("customer", new Customer());
		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String email = authentication.getName();
			Customer customer = customerRepository.findByEmail(email)
					.orElseThrow(() -> new UsernameNotFoundException("Username: " + email + " not found"));
			model.addAttribute("customer", customer);
		}

		return ViewName.CLIENT_PAYMENT_PAGE;
	}

	@GetMapping("/customer/account")
	public String getCustomerAccountInfo(HttpServletRequest request, Model model) {
		HttpSession session = (HttpSession) request.getSession();
		@SuppressWarnings("unchecked")
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String email = authentication.getName();
			Customer customer = customerRepository.findByEmail(email)
					.orElseThrow(() -> new UsernameNotFoundException("Username: " + email + " not found"));
			model.addAttribute("customer", customer);
		}

		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());
		model.addAttribute("viewName", "accountInfo");

		return ViewName.CLIENT_CUSTOMER_PAGE;
	}

	@GetMapping("/customer/account/edit")
	public String editCustomerInfo(HttpServletRequest request, Model model) {
		HttpSession session = (HttpSession) request.getSession();
		@SuppressWarnings("unchecked")
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String email = authentication.getName();
			Customer customer = customerRepository.findByEmail(email)
					.orElseThrow(() -> new UsernameNotFoundException("Username: " + email + " not found"));
			model.addAttribute("customer", customer);
		}
		

		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());
		model.addAttribute("viewName", "accountEdit");
		

		return ViewName.CLIENT_CUSTOMER_PAGE;
	}

	@PostMapping("/customer/account/edit")
	public String updateCustomer(Customer customer) {
		customerService.saveOrEdit(customer);
		return "redirect:/customer/account";
	}

	@GetMapping("/sales/order/history")
	public String getOrdersHistory(HttpServletRequest request, Model model) {
		int customerId = 0;
		
		HttpSession session = (HttpSession) request.getSession();
		@SuppressWarnings("unchecked")
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String email = authentication.getName();
			Customer customer = customerRepository.findByEmail(email)
					.orElseThrow(() -> new UsernameNotFoundException("Username: " + email + " not found"));
			customerId = customer.getId();
			model.addAttribute("customer", customer);
		}
		
		List<OrderDTO> orderDTO = orderService.orderInfo(customerId);

		System.out.println(orderDTO);
		
		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());
		model.addAttribute("viewName", "accountOrder");
		model.addAttribute("orderList", orderDTO);

		return ViewName.CLIENT_CUSTOMER_PAGE;
	}

}
