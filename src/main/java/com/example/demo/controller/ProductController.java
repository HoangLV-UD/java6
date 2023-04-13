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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/api/v1/product/list")
    public String list(Model model, @RequestParam(value = "cid",required = false)String cid){
        if(cid != null){
            List<Product>list= productService.findByCategoryId(cid);
            model.addAttribute("items", list);
        }else{
            List<Product>list= productService.findAll();
            model.addAttribute("items", list);
        }

        System.out.println("abc");
        return "product/list";
   }

    @RequestMapping("/api/v1/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Product item = productService.findById(id);
            model.addAttribute("item", item);
            return "product/detail";
    }
    //done
}
