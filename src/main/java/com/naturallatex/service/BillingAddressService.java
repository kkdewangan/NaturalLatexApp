package com.naturallatex.service;

import com.naturallatex.dao.BillingAddressDAO;
import com.naturallatex.entity.BillingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kamald on 8/14/18.
 */

@Service
public class BillingAddressService {

    @Autowired
    BillingAddressDAO dao;

    public List<BillingAddress> findAll() {
        return (List<BillingAddress>) dao.findAll();
    }

    public BillingAddress findById(Long id) {
        return dao.findOne(id);
    }

    public BillingAddress save(BillingAddress address) {
        return dao.save(address);
    }

    /**
     * Update only if there is any change in billing address
     * @param newAddr
     * @return
     */
    public BillingAddress edit(BillingAddress newAddr) {
        BillingAddress oldAddr = findById(newAddr.getId());

        if(oldAddr.equals(newAddr)) {
            System.out.println("No change is address. No need to update address");
            return oldAddr;
        } else {
            dao.save(newAddr);
            System.out.println("Updating billing address");
            return newAddr;
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
