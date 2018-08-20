package com.naturallatex.controller;

import com.naturallatex.entity.Customer;
import com.naturallatex.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kamald on 8/14/18.
 */

@RestController
@RequestMapping("/nl/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> findAll() {
        return customerService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Customer product = customerService.findById(id);

        if(product == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(product);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        Customer cust =  customerService.save(customer);

        if(cust == null) {
            return ResponseEntity.unprocessableEntity().build();
        } else {
            return ResponseEntity.ok().body(cust);
        }
    }


    @PutMapping("/edit")
    public ResponseEntity<Customer> edit(@RequestBody Customer customer) {
        Customer cust =  customerService.edit(customer);

        if(cust == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().body(cust);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        customerService.delete(id);
    }

}
