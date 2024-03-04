package com.vivek.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vivek.entity.Product;
import com.vivek.repo.ProductRepo;

@Controller
public class ProductController {
	@Autowired
	private ProductRepo repo;
	
	@GetMapping("/delete")
	public String deleteData(@RequestParam("id") Integer id ,Model model) {		
		repo.deleteById(id);
		model.addAttribute("msg1","Data Deleted...");
		model.addAttribute("products", repo.findAll());
		return "data";
	}
	
      @GetMapping("/view")
	public String getAllData(Model model) { 
		model.addAttribute("products", repo.findAll());
		return "data";
		
	}
	@PostMapping("/product")
	public String saveProduct(@ModelAttribute("pr") Product pr,Model model) {
		repo.save(pr);
		if(pr.getId() != null) {
			model.addAttribute("msg", "Data Saved...");
		}
		return "index";
	}
	@GetMapping("/")
   public  String loadPage(Model model) {
	   model.addAttribute("pr", new Product());
	   return "index";
	   
   }

}
