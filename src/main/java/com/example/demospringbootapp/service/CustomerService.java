package com.example.demospringbootapp.service;

import com.example.demospringbootapp.domain.Customer;
import com.example.demospringbootapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id){
        Customer theCustomer = customerRepository.findById(id).orElse(null);
        return theCustomer;
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer){
        if (customerRepository.findById(customer.getId()) == null){
            return null;
        }
        else {
            return customerRepository.save(customer);
        }
    }

//    public Object deleteCustomer(int id){
//        Customer theCustomer = customerRepository.findById(id).orElse(null);
//        if (customerRepository.findById(id) == null){
//            return null;
//        }
//        else {
//            return customerRepository.delete(theCustomer);
//        }
//    }

}
