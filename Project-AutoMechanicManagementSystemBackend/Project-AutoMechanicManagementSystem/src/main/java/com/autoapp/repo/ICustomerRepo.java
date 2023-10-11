package com.autoapp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autoapp.beans.Customer;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer, Integer>{

}
