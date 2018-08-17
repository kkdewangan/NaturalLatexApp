package com.naturallatex.controller;

import com.naturallatex.entity.BillingAddress;
import com.naturallatex.service.BillingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kamald on 8/14/18.
 */

@RestController
@RequestMapping("/nl/billingaddress")
public class BillingAddressController {

    @Autowired
    BillingAddressService billingAddressService;

    @GetMapping("/all")
    public List<BillingAddress> findAll() {
        return billingAddressService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<BillingAddress> findById(@PathVariable Long id) {
        BillingAddress addr = billingAddressService.findById(id);

        if(addr == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(addr);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<BillingAddress> save(@RequestBody BillingAddress address) {
        BillingAddress addr =  billingAddressService.save(address);

        if(addr == null) {
            return ResponseEntity.unprocessableEntity().build();
        } else {
            return ResponseEntity.ok().body(addr);
        }
    }


    @PutMapping("/edit")
    public ResponseEntity<BillingAddress> edit(@RequestBody BillingAddress address) {
        BillingAddress addr =  billingAddressService.edit(address);

        if(addr == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().body(addr);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        billingAddressService.delete(id);
    }

}
