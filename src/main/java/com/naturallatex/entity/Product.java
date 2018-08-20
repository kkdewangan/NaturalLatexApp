/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturallatex.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author kamald
 */
@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_desc")
    private String productDesc;

    private Double unitPrice;
    private Integer qty;
    private String bedSize;
    private String firmnessRating;
  

    public Product() {
    }

    public Product(Long productId) {
        this.id = productId;
    }

    public Product(Long productId, String productName) {
        this.id = productId;
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getBedSize() {
        return bedSize;
    }

    public void setBedSize(String bedSize) {
        this.bedSize = bedSize;
    }

    public String getFirmnessRating() {
        return firmnessRating;
    }

    public void setFirmnessRating(String firmnessRating) {
        this.firmnessRating = firmnessRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (productCode != null ? !productCode.equals(product.productCode) : product.productCode != null) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (productDesc != null ? !productDesc.equals(product.productDesc) : product.productDesc != null) return false;
        if (unitPrice != null ? !unitPrice.equals(product.unitPrice) : product.unitPrice != null) return false;
        if (qty != null ? !qty.equals(product.qty) : product.qty != null) return false;
        if (bedSize != null ? !bedSize.equals(product.bedSize) : product.bedSize != null) return false;
        return firmnessRating != null ? firmnessRating.equals(product.firmnessRating) : product.firmnessRating == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productDesc != null ? productDesc.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (qty != null ? qty.hashCode() : 0);
        result = 31 * result + (bedSize != null ? bedSize.hashCode() : 0);
        result = 31 * result + (firmnessRating != null ? firmnessRating.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                ", bedSize='" + bedSize + '\'' +
                ", firmnessRating='" + firmnessRating + '\'' +
                '}';
    }
}
