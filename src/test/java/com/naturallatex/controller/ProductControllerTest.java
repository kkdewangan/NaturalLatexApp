package com.naturallatex.controller;

import com.naturallatex.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by kamald on 8/20/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void post_NewBillingAddress() {
        String baseURL = "http://localhost:" + port + "/nl/product";
        Product obj = new Product();
        //obj.setId(new Long(124));
        //obj.setFirmness("test_firmness");
        //obj.setModel("test_model");
        obj.setProductCode("test_productcode1");
        obj.setProductDesc("test_productdesc1");
        obj.setProductName("test_product_name");
        ResponseEntity<Product> res = restTemplate.postForEntity(baseURL+"/new",obj, Product.class);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        //assertTrue(res.getBody().getId() > 0);
        //assertEquals("Peter", res.getBody().getFirstName());
    }
}
