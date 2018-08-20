package com.naturallatex.dao;

import com.naturallatex.entity.PurchaseOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kamald on 8/14/18.
 */
public interface PurchaseOrderDAO extends CrudRepository<PurchaseOrder,Long> {
}
