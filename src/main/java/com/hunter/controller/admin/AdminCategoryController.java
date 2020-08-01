package com.hunter.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hunter.model.Category;
import com.hunter.service.CategoryService;
import com.hunter.utils.ViewName;

@Controller
@RequestMapping("/Admin")
public class AdminCategoryController {

	@Autowired
	CategoryService categoryService;

	// Category List

	@GetMapping("/Category/List")
	public String getCategoryList(Model model) {
		model.addAttribute("breadcrumb", "Danh mục");
		return ViewName.ADMIN_CATEGORY_PAGE;
	}

	@PostMapping("/Category/List")
	@ResponseBody
	public List<Category> getCategories(@RequestParam(value = "keyword") String keyword, @RequestParam("page") int page) {
		List<Category> categories = categoryService.findByCategoryName(keyword, (page - 1)*3, 3);
		return categories;
	}

	@GetMapping("/Category/Create")
	public String getCreateCategory(Model model) {
		model.addAttribute("breadcrumb", "Thêm danh mục");
		model.addAttribute("category", new Category());
		model.addAttribute("categories", categoryService.findAll());
		return ViewName.ADMIN_CATEGORY_FORM_PAGE;
	}

	@GetMapping("Category/Edit/{id}")
	public String getEditCategory(@PathVariable("id") int id, Model model) {
		Category category = categoryService.findById(id);
		if (category == null) {
			return ViewName.ADMIN_CATEGORY_PAGE;
		}
		model.addAttribute("breadcrumb", "Sửa danh mục");
		model.addAttribute("category", category);
		model.addAttribute("categories", categoryService.findAll());
		return ViewName.ADMIN_CATEGORY_FORM_PAGE;
	}
	
	@GetMapping("/Category/Delete/{id}")
	public String getDeleteCategory(@PathVariable("id") int id, Model model) {
		categoryService.deleteCategory(id);
		return "redirect:/Admin/Category/List";
	}
	
	@PostMapping("Category/Save")
	public String getSaveCategory(Category category) {
		System.out.println(category);
		categoryService.saveAndUpdate(category);
		return "redirect:/Admin/Category/List";
	}
	
	@GetMapping("Category/Search")
	@ResponseBody
	public List<Category> getCategoryByName(@RequestParam("q") String q) {
		return categoryService.findByCategoryName(q);
	}

}
