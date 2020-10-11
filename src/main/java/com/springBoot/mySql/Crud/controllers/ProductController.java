package com.springBoot.mySql.Crud.controllers;

import com.springBoot.mySql.Crud.entity.Product;
import com.springBoot.mySql.Crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private  ProductService productService;

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        return productService.getProductById(id);
    }
    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
      return productService.removeProduct(id);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }


}
