package com.naturallatex.service;

import com.naturallatex.dao.CustomerDAO;
import com.naturallatex.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kamald on 8/14/18.
 */

@Service
public class CustomerService {

    @Autowired
    CustomerDAO dao;

    public List<Customer> findAll() {
        return (List<Customer>) dao.findAll();
    }

    public Customer findById(Long id) {
        return dao.findOne(id);
    }

    public Customer save(Customer customer) {
        return dao.save(customer);
    }

    /**
     * Update only if there is any change in billing address
     * @param customer
     * @return
     */
    public Customer edit(Customer customer) {
        Customer oldCust = findById(customer.getId());

        if(oldCust.equals(customer)) {
            System.out.println("No change is customer. No need to update customer");
            return oldCust;
        } else {
            dao.save(customer);
            System.out.println("Updating billing address");
            return customer;
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
