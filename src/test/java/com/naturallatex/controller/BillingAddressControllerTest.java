package com.naturallatex.controller;

import com.naturallatex.entity.BillingAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;
/**
 * Created by kamald on 8/14/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BillingAddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    //private static String baseURL;


  //@BeforeClass
  public void init() {
      //baseURL = "http://localhost:" + port + "/nl/billingaddress";
  }

  //@Test
  public void findAll_BillingAddress() {
      /*List forObject = this.restTemplate.getForObject("/all", List.class);
      Collection<COrder> readValues = new ObjectMapper().readValue(jsonAsString, new TypeReference<Collection<COrder>>() { });
      assertNotNull(forObject);
      assertTrue(forObject.size() > 0);*/
  }

    @Test
    public void findOne_BillingAddress() throws IOException{
        String baseURL = "http://localhost:" + port + "/nl/billingaddress";
        ResponseEntity<BillingAddress> res = this.restTemplate.getForEntity(baseURL+"/100",BillingAddress.class);
        assertEquals(res.getStatusCode(), HttpStatus.OK);
        BillingAddress ba = res.getBody();
        assertEquals(new Long(100), ba.getId());
    }

    @Test
    public void delete_EditBillingAddress() {
                String baseURL = "http://localhost:" + port + "/nl/billingaddress";

        restTemplate.delete(baseURL+"/999");
        ResponseEntity<BillingAddress> res = this.restTemplate.getForEntity(baseURL+"/",BillingAddress.class);
        BillingAddress ba = res.getBody();
        assertEquals(res.getStatusCode(), HttpStatus.NOT_FOUND);
    }
    
    @Test
    public void post_NewBillingAddress() {
        String baseURL = "http://localhost:" + port + "/nl/billingaddress";
        BillingAddress address = new BillingAddress(
                "Peter",
                "Parker",
                "peter.parker@aa.com",
                "Parker Corp",
                "201, Johnson Street, Bellview",
                "Seattle",
                "WA",
                "2123555",
                "USA",
                "213-786-0098",
                true);
        address.setId(new Long(999));
        ResponseEntity<BillingAddress> res = restTemplate.postForEntity(baseURL+"/new",address, BillingAddress.class);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertTrue(res.getBody().getId() > 0);
        assertEquals("Peter", res.getBody().getFirstName());
    }

    
}
