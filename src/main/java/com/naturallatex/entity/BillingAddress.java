package com.naturallatex.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by kamald on 8/14/18.
 */

@Entity
public class BillingAddress implements Serializable{

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@SequenceGenerator(sequenceName = "billing_address_seq", allocationSize = 1, name = "billing_address_seq")
    @Column(name = "billing_address_id")
    Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String email;

    private String company;
    private String address;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private String fax;
    private Boolean defaultAddress;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Collection<Customer> customersList;

    //@OneToMany(mappedBy = "id")
    //private Collection<CustomerRegistration> customerRegistrationsList;

    public BillingAddress() {
    }

    public BillingAddress(String firstName, String lastName, String email,
                          String company, String address, String city,
                          String state, String postcode, String country,
                          String fax, Boolean defaultAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
        this.fax = fax;
        this.defaultAddress = defaultAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Boolean getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public Collection<Customer> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(Collection<Customer> customersList) {
        this.customersList = customersList;
    }

//    public Collection<CustomerRegistration> getCustomerRegistrationsList() {
//        return customerRegistrationsList;
//    }
//
//    public void setCustomerRegistrationsList(Collection<CustomerRegistration> customerRegistrationsList) {
//        this.customerRegistrationsList = customerRegistrationsList;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingAddress that = (BillingAddress) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (postcode != null ? !postcode.equals(that.postcode) : that.postcode != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (defaultAddress != null ? !defaultAddress.equals(that.defaultAddress) : that.defaultAddress != null)
            return false;
        return customersList != null ? customersList.equals(that.customersList) : that.customersList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (defaultAddress != null ? defaultAddress.hashCode() : 0);
        result = 31 * result + (customersList != null ? customersList.hashCode() : 0);
        return result;
    }
}
