package com.naturallatex.service;

import com.naturallatex.dao.PurchaseOrderDAO;
import com.naturallatex.entity.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kamald on 8/14/18.
 */

@Service
public class PurchaseOrderService {

    @Autowired
    PurchaseOrderDAO dao;

    public List<PurchaseOrder> findAll() {
        return (List<PurchaseOrder>) dao.findAll();
    }

    public PurchaseOrder findById(Long id) {
        return dao.findOne(id);
    }

    public PurchaseOrder save(PurchaseOrder po) {
        return dao.save(po);
    }

    /**
     * Update only if there is any change in billing address
     * @param purchaseOrder
     * @return
     */
    public PurchaseOrder edit(PurchaseOrder purchaseOrder) {
        PurchaseOrder poOld = findById(purchaseOrder.getId());

        if(poOld.equals(purchaseOrder)) {
            System.out.println("No change is purchaseOrder. No need to update purchaseOrder");
            return poOld;
        } else {
            dao.save(purchaseOrder);
            System.out.println("Updating billing address");
            return purchaseOrder;
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
