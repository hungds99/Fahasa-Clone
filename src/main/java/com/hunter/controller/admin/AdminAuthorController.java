package com.hunter.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hunter.file.storage.FileStorageService;
import com.hunter.file.storage.FileSystemStorageService;
import com.hunter.model.Author;
import com.hunter.service.AuthorService;
import com.hunter.utils.ViewName;

@Controller
@RequestMapping("/Admin")
public class AdminAuthorController {

	@Autowired
	AuthorService authorService;
	
	@Autowired
	FileSystemStorageService fileSystemStorageService;
	
	@Autowired
	FileStorageService fileStorageService;
	
	@GetMapping("/Author/List")
	public String getAuthorList(Model model) {
		
		return ViewName.ADMIN_AUTHOR_PAGE;
	}
	
	@PostMapping("/Author/List")
	@ResponseBody
	public List<Author> getAuthors(@RequestParam("keyword") String keyword ,@RequestParam("page") int page) {
		System.out.println("Begin Transaction !");
		List<Author> authors = authorService.findByAuthorName(keyword, page - 1, 10);
		System.out.println("End Transaction !");
		return authors;
	}
	
	@GetMapping("/Author/Create")
	public String getCreateAuthor(Model model) {
		model.addAttribute("breadcrumb", "Thêm tác giả");
		model.addAttribute("author", new Author());
		return ViewName.ADMIN_AUTHOR_FORM_PAGE;
	}
	
	@PostMapping("/Author/Save")
	public String getSaveAuthor(HttpServletRequest request,Author author, @RequestParam("file") MultipartFile file) {
//		String authorImage = fileStorageService.storage(request, file);
		fileSystemStorageService.store(file);
		author.setAuthorImage(file.getOriginalFilename());
		authorService.save(author);
//		System.out.println(System.getProperty("user.dir")+ "/src/main/resources/static/images");
		return "redirect:/Admin/Author/List";
	}
	
	@PostMapping("/Author/DeleteSelected")
	@ResponseBody
	public String getDeleteSelected(@RequestBody List<Integer> authorIdsSelected) {
		System.out.println(authorIdsSelected.toString());
		authorService.deleteAllById(authorIdsSelected);
		return "success";
	}
	
	
	
	
}
