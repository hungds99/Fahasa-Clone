package com.hunter.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hunter.dto.ProductDTO;
import com.hunter.dto.SearchDTO;
import com.hunter.file.storage.StorageService;
import com.hunter.model.Image;
import com.hunter.model.Product;
import com.hunter.model.ProductAttribute;
import com.hunter.service.AuthorService;
import com.hunter.service.CategoryService;
import com.hunter.service.DiscountService;
import com.hunter.service.ImageService;
import com.hunter.service.ProductAttributeService;
import com.hunter.service.ProductService;
import com.hunter.service.PromotionService;
import com.hunter.service.PublisherService;
import com.hunter.service.SupplierService;
import com.hunter.utils.ViewName;

@Controller
@RequestMapping("/Admin")
public class AdminProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductAttributeService productAttributeService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ImageService imageService;

	@Autowired
	private StorageService storageService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private DiscountService discountService;
	
	@Autowired
	private PromotionService promotionService;

	@GetMapping("/Product/List")
	public String getProductList(Model model) {
		model.addAttribute("breadcrumb", "Sản phẩm");
		model.addAttribute("categories", categoryService.findAll());
		return ViewName.ADMIN_PRODUCT_PAGE;
	}

	@PostMapping("/Product/List")
	@ResponseBody
	public List<ProductDTO> getProducts(@RequestBody SearchDTO searchdto) {
		List<ProductDTO> products = productService.getProductBySearch(searchdto);
		return products;
	}

	@GetMapping("/Product/Create")
	public String getCreateCategory(Model model) {
		model.addAttribute("breadcrumb", "Thêm sản phẩm");
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("product", new Product());
		model.addAttribute("promotions", promotionService.findAllPromotion());
		model.addAttribute("productattribute", 0);
		model.addAttribute("images", 0);
		return ViewName.ADMIN_PRODUCT_FORM_PAGE;
	}

	@GetMapping("/Product/ProductCreateOrUpdate/productId={id}")
	public String getCreateAfterSave(Model model, @PathVariable("id") int productId) {
		model.addAttribute("breadcrumb", "Sửa sản phẩm");
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("discounts", discountService.findAll());
		model.addAttribute("product", productService.findProductById(productId));
		ProductAttribute productattribute = productAttributeService.findByProductId(productId);
		model.addAttribute("productattribute", (productattribute == null) ? new ProductAttribute() : productattribute);
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("suppliers", supplierService.findAll());
		model.addAttribute("publishers", publisherService.findAll());
		model.addAttribute("images", imageService.findByProductId(productId));
		model.addAttribute("image", new Image());
		return ViewName.ADMIN_PRODUCT_FORM_PAGE;
	}

	@PostMapping("/Product/Save")
	public String getSaveProduct(Product product) {
		Product p = productService.saveAndUpdate(product);
		return "redirect:/Admin/Product/ProductCreateOrUpdate/productId=" + p.getId();
	}

	@PostMapping("/ProductImageMapping/Save")
	public String getSaveProductImage(Image image, @RequestParam("file") MultipartFile file) {
		storageService.store(file);
		image.setImageUrl(file.getOriginalFilename());
		imageService.save(image);
		return "redirect:/Admin/Product/ProductCreateOrUpdate/productId=" + image.getProduct().getId();
	}
	
	@GetMapping("/ProductImageMapping/Delete")
	public String getDeleteImage(@RequestParam("imageId") int imageId, @RequestParam("productId") int productId) {
		imageService.delete(imageId);
		return "redirect:/Admin/Product/ProductCreateOrUpdate/productId=" + productId;
	}

	@PostMapping("/ProductAttributeMapping/Save")
	public String getSaveProductAttribute(ProductAttribute productAttribute) {
		productAttributeService.saveAndUpdate(productAttribute);
		return "redirect:/Admin/Product/ProductCreateOrUpdate/productId=" + productAttribute.getProductId();
	}
	

	@GetMapping("/Product/Edit/{id}")
	public String getEditProduct(@PathVariable("id") int id, Model model) {
		model.addAttribute("breadcrumb", "Sửa sản phẩm");
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("product", productService.findProductById(id));
		model.addAttribute("productattribute", productAttributeService.findByProductId(id));
		model.addAttribute("images", imageService.findByProductId(id));
		return ViewName.ADMIN_PRODUCT_FORM_PAGE;
	}

}
