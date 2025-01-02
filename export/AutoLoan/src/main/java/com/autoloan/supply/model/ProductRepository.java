package com.autoloan.supply.model;

import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface ProductRepository extends CrudRepository<ProductEntity, String> {
    
    public Optional<ProductEntity> findByBarCode(String barCode);
    
    
}