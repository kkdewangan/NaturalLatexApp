package com.naturallatex.dao;

import com.naturallatex.entity.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kamald on 8/14/18.
 */
public interface CustomerDAO extends CrudRepository<Customer,Long> {
}
