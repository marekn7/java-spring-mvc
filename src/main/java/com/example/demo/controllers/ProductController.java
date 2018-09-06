package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.services.ProductService;
import com.example.demo.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/list")
    public String getProducts(Model model) {

        model.addAttribute("products", productService.listAll());

        return "product/list";
    }

    @RequestMapping("/{id}")
    public String getProduct(@PathVariable Integer id, Model model) {

        model.addAttribute("product", productService.getById(id));

        return "product/show";
    }

    @RequestMapping("/edit/{id}")
    public String updateProduct(@PathVariable Integer id, Model model) {

        model.addAttribute("product", productService.getById(id));

        return "product/productform";
    }

    @RequestMapping("/new")
    public String createProduct(Model model) {

        model.addAttribute("product", new Product());

        return "/product/productform";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, Model model) {

        productService.delete(id);

        return "redirect:/product/list";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product) {
        Product saveProduct = productService.saveOrUpdate(product);

        return "redirect:/product/" + saveProduct.getId();
    }

}
