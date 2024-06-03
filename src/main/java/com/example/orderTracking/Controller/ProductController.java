package com.example.orderTracking.Controller;

import com.example.orderTracking.Entity.Product;
import com.example.orderTracking.Repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        productRepo.save(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    @GetMapping("/{Pageno}/{PageSize}")
    public List<Product> getProductsByPagination(@PathVariable int Pageno,@PathVariable int PageSize)
    {
    	PageRequest pageable=PageRequest.of(Pageno, PageSize);
		List<Product> products=productRepo.findAll(pageable).getContent();
		return products;
			
			
    }
    @GetMapping("{ProductName}")
    public List<Product>getProductsByMatchedProductName(String productName){
        List<Product>products= productRepo.findAll();
        List<Product>productsList=new ArrayList<>();
        for (Product product : products) {
         if(product.getName().contains(productName))
         {
             productsList.add(product);
         }
        }
        return productsList;
     }
}

