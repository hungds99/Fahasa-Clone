package com.hunter.controller.client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hunter.dto.CartDTO;
import com.hunter.model.Product;
import com.hunter.service.ProductService;

@RestController
@RequestMapping("/api/cart")
@SessionAttributes("cart")
public class CartAPIController {

	@Autowired
	private ProductService productService;

	@PostMapping("/addToCart")
	public List<CartDTO> addToCart(@RequestBody CartDTO cartDTO, HttpServletRequest request) {

		Product productExisted = productService.findProductById(cartDTO.getProductId());

		if (productExisted == null)
			return null;

		HttpSession session = (HttpSession) request.getSession();
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");

		// Chưa có gì trong giỏ hàng => Tạo giỏ hàng
		if (carts == null)
			carts = new ArrayList<CartDTO>();

		// Da co san pham trong gio hang
		// Kiem tra san pham da ton tai hay chua
		int index = checkProductExisted(cartDTO.getProductId(), carts);

		if (index == -1) {
			carts.add(cartDTO);
			session.setAttribute("cart", carts);
			return carts;
		} else {
			CartDTO cart = carts.get(index);
			// Set so luong
			cart.setProductAmount(cart.getProductAmount() + cartDTO.getProductAmount());
			session.setAttribute("cart", carts);
			return carts;
		}
	}

	private static int checkProductExisted(int productId, List<CartDTO> carts) {

		return IntStream.range(0, carts.size()).filter(i -> productId == (carts.get(i).getProductId())).findFirst()
				.orElse(-1);
	}

}
