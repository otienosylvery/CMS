package com.otieno.starter.service;

import com.otieno.starter.dao.CustomerDAO;
import com.otieno.starter.exception.CustomerNotFoundException;
import com.otieno.starter.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer){

        return customerDAO.save(customer);

    }

    public List<Customer> getCustomers(){

        return customerDAO.findAll();

    }

    public Customer getCustomer(int customerId){

        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer record not found...");
        return optionalCustomer.get();
    }
    public Customer updateCustomer(int customerId, Customer customer){

        customer.setCustomerId(customerId);
        return customerDAO.save(customer);
    }
    public void deleteCustomer(int customerId){

        customerDAO.deleteById(customerId);
    }

}
