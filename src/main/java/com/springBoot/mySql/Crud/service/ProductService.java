package com.springBoot.mySql.Crud.service;

import com.springBoot.mySql.Crud.entity.Product;
import com.springBoot.mySql.Crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    //Get methods
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getProductById( int id){
     return  productRepository.findById(id).orElse(null);
    }
    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }
    //Post methods
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }
    //Put methods
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
       return productRepository.save(existingProduct);
    }
    //Delete method
    public String removeProduct(int id){
        productRepository.deleteById(id);
        return "Product removed with id" + id;
    }






}
