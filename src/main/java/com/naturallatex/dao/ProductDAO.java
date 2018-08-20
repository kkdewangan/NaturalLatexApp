package com.naturallatex.dao;

import com.naturallatex.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kamald on 8/14/18.
 */
public interface ProductDAO extends CrudRepository<Product,Long> {
}
