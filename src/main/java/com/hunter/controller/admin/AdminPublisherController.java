package com.hunter.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hunter.file.storage.FileSystemStorageService;
import com.hunter.model.Author;
import com.hunter.model.Publisher;
import com.hunter.service.PublisherService;
import com.hunter.utils.ViewName;

@Controller
@RequestMapping("/Admin/Publisher")
public class AdminPublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	@Autowired
	private FileSystemStorageService fileSystemStorageService;

	@GetMapping("/List")
	public String getPublisherList() {
		return ViewName.ADMIN_PUBLISHER_PAGE;
	}
	
	@PostMapping("/List")
	@ResponseBody
	public List<Publisher> getPublishers(@RequestParam("keyword") String keyword ,@RequestParam("page") int page) {
		List<Publisher> publishers = publisherService.findByPublisherName(keyword, page - 1, 10);;
		return publishers;
	}
	
	@GetMapping("/Create")
	public String getCreatePublisher(Model model) {
		model.addAttribute("breadcrumb", "Thêm nhà xuất bản");
		model.addAttribute("publisher", new Publisher());
		return ViewName.ADMIN_PUBLISHER_FORM_PAGE;
	}
	
	@PostMapping("/Save")
	public String getSavePublisher(HttpServletRequest request,Publisher publisher, @RequestParam("file") MultipartFile file) {
		fileSystemStorageService.store(file);
		publisher.setPublisherImage(file.getOriginalFilename());
		publisherService.save(publisher);
		return "redirect:/Admin/Publisher/List";
	}
	
}
