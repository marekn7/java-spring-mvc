package com.example.demo.services;

import com.example.demo.domain.Customer;
import com.example.demo.domain.DomainObject;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    @Override
    public List<DomainObject> listAll() {
        return new ArrayList<>(domainMap.values());
    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    public Integer nextId() {
        return Collections.max(domainMap.keySet()) + 1;
    }

    @Override
    public void delete(Integer id) {
        domainMap.remove(id);
    }

    @Override
    protected void loadDomainObjects() {
        domainMap = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Micheal");
        customer1.setLastName("Weston");
        customer1.setAddressLine1("1 Main St");
        customer1.setCity("Miami");
        customer1.setState("Florida");
        customer1.setZipCode("33101");
        customer1.setEmail("micheal@burnnotice.com");
        customer1.setPhoneNumber("305.333.0101");

        domainMap.put(1, customer1);

        Customer customer2 = new Customer();
        customer2.setId(1);
        customer2.setFirstName("Petr");
        customer2.setLastName("Petr");
        customer2.setAddressLine1("1 London");
        customer2.setCity("Miami");
        customer2.setState("US");
        customer2.setZipCode("33101");
        customer2.setEmail("prague@burnnotice.com");
        customer2.setPhoneNumber("305.333.0101");

        domainMap.put(2, customer2);
    }
}
