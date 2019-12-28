package com.hunter.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hunter.model.Promotion;
import com.hunter.service.PromotionService;
import com.hunter.utils.ViewName;

@Controller
@RequestMapping("/Admin")
public class AdminPromotionController {
	
	@Autowired
	PromotionService promotionService;

	@GetMapping("/Promotion/List")
	public String getPromotionList(Model model) {
		model.addAttribute("breadcrumb", "Khuyến mãi - Giảm giá");
		return ViewName.ADMIN_PROMOTION_PAGE;
	}
	
	@PostMapping("/Promotion/List")
	@ResponseBody
	public List<Promotion> getPromotions() {
		List<Promotion> promotions = promotionService.findAllPromotion();
		return promotions;
	}
	
	@GetMapping("/Promotion/Create")
	public String getPromotionCreate(Model model) {
		model.addAttribute("breadcrumb", "Thêm khuyến mãi");
		model.addAttribute("promotion", new Promotion());
		return ViewName.ADMIN_PROMOTION_FORM_PAGE;
	}
	
	@PostMapping("/Promotion/Save")
	public String getPromotionSave(@ModelAttribute("promotion") Promotion promotion) {
		
		promotionService.saveOrUpdate(promotion);
		
		return "redirect:/Admin/Promotion/List";
	}
	
	@GetMapping("/Promotion/GetOne")
	@ResponseBody
	public Promotion getPromotion() {
		return promotionService.findById(1);
	}
	
}
