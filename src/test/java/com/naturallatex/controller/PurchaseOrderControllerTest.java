package com.naturallatex.controller;

import com.naturallatex.entity.PurchaseOrder;
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
public class PurchaseOrderControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void post() {
        String baseURL = "http://localhost:" + port + "/nl/purchaseOrder";
        PurchaseOrder o = new PurchaseOrder();
        o.setCustId(new Long(123));
        o.setProductId(new Long(123459));
        ResponseEntity<PurchaseOrder> res = restTemplate.postForEntity(baseURL+"/new",o, PurchaseOrder.class);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        //assertTrue(res.getBody().getId() > 0);
        //assertEquals("Peter", res.getBody().getFirstName());
    }
}
