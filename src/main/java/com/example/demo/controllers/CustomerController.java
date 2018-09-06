package com.example.demo.controllers;

import com.example.demo.domain.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/list")
    public String getCustomers(Model model) {

        model.addAttribute("customers", customerService.listAll());

        return "customer/list";
    }

    @RequestMapping("/{id}")
    public String getCustomer(@PathVariable Integer id, Model model) {

        model.addAttribute("customer", customerService.getById(id));

        return "customer/show";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id, Model model) {

        customerService.delete(id);

        return "redirect:/customer/list";
    }

    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {

        model.addAttribute("customer", customerService.getById(id));

        return "customer/customerform";
    }

    @RequestMapping("/new")
    public String newCustomer(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer/customerform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(Customer customer) {

        Customer saveCustomer = customerService.saveOrUpdate(customer);

        return "redirect:/customer/show/" + saveCustomer.getId();
    }
}
