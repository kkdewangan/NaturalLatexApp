package com.naturallatex.dao;

import com.naturallatex.entity.BillingAddress;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kamald on 8/14/18.
 */
public interface BillingAddressDAO extends CrudRepository<BillingAddress,Long> {
}
