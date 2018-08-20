package com.naturallatex.controller;

import com.naturallatex.entity.Customer;
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
public class CustomerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void post_NewBillingAddress() {
        String baseURL = "http://localhost:" + port + "/nl/customer";
        Customer o = new Customer();

        o.setEmail("aa@aa.com");
        o.setFax("312-456-8790");
        o.setFirstName("TestFirstName");
        o.setLastName("TestLastName");
        o.setPassword("testpass");
        o.setPhone("231-342-9876");
        o.setStatus(true);
        ResponseEntity<Customer> res = restTemplate.postForEntity(baseURL+"/new",o, Customer.class);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        //assertTrue(res.getBody().getId() > 0);
        //assertEquals("Peter", res.getBody().getFirstName());
    }
}
