package com.sheryians.major.controller;

import com.sheryians.major.global.GlobalData;
import com.sheryians.major.model.Product;
import com.sheryians.major.service.CategoryService;
import com.sheryians.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping({"/", "/home"})
    public String home(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }

//    @GetMapping("/shop")
//
//    public String shop(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
//        int pageSize = 6;
//        Pageable pageable = PageRequest.of(page, pageSize);
//        Page<Product> productPage = productService.getAllProducts(pageable);
//
//        model.addAttribute("currentPage", 1);
//        model.addAttribute("categories", categoryService.getAllCategory());
//        model.addAttribute("products", productService.getAllProduct());
//        model.addAttribute("cartCount", GlobalData.cart.size());
//        model.addAttribute("products", productPage.getContent());
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", productPage.getTotalPages());
//
//        return "shop";
//  }
    //////////////////
@GetMapping("/shop")
public String shop(Model model, @RequestParam(value = "category", required = false) Integer categoryId) {
    List<Product> products;

    if (categoryId != null) {
        products = productService.getAllProductsByCategoryId(categoryId);
    } else {
        products = productService.getAllProducts();
    }

    model.addAttribute("categories", categoryService.getAllCategory());
    model.addAttribute("products", products);
    model.addAttribute("cartCount", GlobalData.cart.size());

    return "shop";
}

    ///////////////////
    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("products", productService.getAllProductsByCategoryId(id));
        return "shop";
    }
    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("product", productService.getProductById(id).get());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "viewProduct";
    }




}
