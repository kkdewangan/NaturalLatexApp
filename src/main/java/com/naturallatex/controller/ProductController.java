package com.naturallatex.controller;

import com.naturallatex.entity.Product;
import com.naturallatex.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kamald on 8/14/18.
 */

@RestController
@RequestMapping("/nl/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<Product> findAll() {
        return productService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id);

        if(product == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(product);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product prd =  productService.save(product);

        if(prd == null) {
            return ResponseEntity.unprocessableEntity().build();
        } else {
            return ResponseEntity.ok().body(prd);
        }
    }


    @PutMapping("/edit")
    public ResponseEntity<Product> edit(@RequestBody Product product) {
        Product prd =  productService.edit(product);

        if(prd == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().body(prd);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.delete(id);
    }

}
