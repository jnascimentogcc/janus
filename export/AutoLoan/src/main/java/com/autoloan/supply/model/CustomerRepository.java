package com.autoloan.supply.model;

import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {
    
    public Optional<CustomerEntity> findByFiscalNumber(String fiscalNumber);
    
    
}