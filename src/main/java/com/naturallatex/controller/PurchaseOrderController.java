package com.naturallatex.controller;

import com.naturallatex.entity.PurchaseOrder;
import com.naturallatex.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kamald on 8/14/18.
 */

@RestController
@RequestMapping("/nl/purchaseOrder")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @GetMapping("/all")
    public List<PurchaseOrder> findAll() {
        return purchaseOrderService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> findById(@PathVariable Long id) {
        PurchaseOrder po = purchaseOrderService.findById(id);

        if(po == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(po);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<PurchaseOrder> save(@RequestBody PurchaseOrder purchaseOrder) {
        PurchaseOrder po =  purchaseOrderService.save(purchaseOrder);

        if(po == null) {
            return ResponseEntity.unprocessableEntity().build();
        } else {
            return ResponseEntity.ok().body(po);
        }
    }


    @PutMapping("/edit")
    public ResponseEntity<PurchaseOrder> edit(@RequestBody PurchaseOrder purchaseOrder) {
        PurchaseOrder po =  purchaseOrderService.edit(purchaseOrder);

        if(po == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().body(po);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        purchaseOrderService.delete(id);
    }

}
