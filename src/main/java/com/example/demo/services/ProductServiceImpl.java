package com.example.demo.services;

import com.example.demo.domain.Customer;
import com.example.demo.domain.DomainObject;
import com.example.demo.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImpl extends AbstractMapService implements ProductService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Product getById(Integer id) {
        return (Product) super.getById(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        return (Product) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    protected void loadDomainObjects() {
        domainMap = new HashMap<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setDescription("The product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com");

        domainMap.put(1, product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setDescription("The product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com");

        domainMap.put(2, product2);
    }


}

//    private Map<Integer, Product> products;
//
//    public ProductServiceImpl() {
//        loadProducts();
//    }
//
//    @Override
//    public List<Product> listAllProducts() {
//        return new ArrayList<>(products.values());
//    }
//
//    @Override
//    public Product getProduct(Integer id) {
//        return products.get(id);
//    }
//
//    @Override
//    public Product saveOrUpdate(Product product) {
//        if (product != null) {
//            if (product.getId() == null) {
//                product.setId(getNextKey());
//            }
//            products.put(product.getId(), product);
//
//            return product;
//        } else {
//            throw new RuntimeException("Product cant be nill");
//        }
//    }
//
//    @Override
//    public void deleteProduct(Integer id) {
//        products.remove(id);
//    }
//
//    private Integer getNextKey() {
//        return Collections.max(products.keySet()) + 1;
//    }
//
//    private void loadProducts() {
//        products = new HashMap<>();
//
//        Product product1 = new Product();
//        product1.setId(1);
//        product1.setDescription("The product 1");
//        product1.setPrice(new BigDecimal("12.99"));
//        product1.setImageUrl("http://example.com");
//
//        products.put(1, product1);
//
//        Product product2 = new Product();
//        product2.setId(2);
//        product2.setDescription("The product 2");
//        product2.setPrice(new BigDecimal("14.99"));
//        product2.setImageUrl("http://example.com");
//
//        products.put(2, product2);
//    }



