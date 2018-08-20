package com.naturallatex.service;

import com.naturallatex.dao.BillingAddressDAO;
import com.naturallatex.dao.ProductDAO;
import com.naturallatex.entity.BillingAddress;
import com.naturallatex.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kamald on 8/14/18.
 */

@Service
public class ProductService {

    @Autowired
    ProductDAO dao;

    public List<Product> findAll() {
        return (List<Product>) dao.findAll();
    }

    public Product findById(Long id) {
        return dao.findOne(id);
    }

    public Product save(Product product) {
        return dao.save(product);
    }

    /**
     * Update only if there is any change in billing address
     * @param product
     * @return
     */
    public Product edit(Product product) {
        Product oldAddr = findById(product.getId());

        if(oldAddr.equals(product)) {
            System.out.println("No change is address. No need to update address");
            return oldAddr;
        } else {
            dao.save(product);
            System.out.println("Updating billing address");
            return product;
        }
    }

    public boolean delete(Long id) {
        boolean isDeleted = false;
        try {
            dao.delete(id);
            isDeleted = true;
        } catch (Exception e) {
            System.out.println("Failed to delet");
        }

        return isDeleted;
    }

}
