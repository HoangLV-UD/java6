package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/api/v1/product")
   public String list(Model model){
    List<Product>list= productService.findAll();
    model.addAttribute("items", list);
        System.out.println("abc");
        return "product/list";
   }

    @RequestMapping("/api/v1/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Product item = productService.findById(id);

            model.addAttribute("item", item);
            return "product/detail";
    }
}
