package com.autoloan.supply.service;

import com.autoloan.helper.exception.ItemNotFoundException;
import com.autoloan.supply.dto.ProductDTO;
import com.autoloan.supply.model.ProductEntity;
import com.autoloan.supply.model.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SupplyService.class);

    private final ProductRepository productRepository;

    public ProductDTO getProduct(String id) {
        ProductDTO productDTO = new ProductDTO();
        try {
            ProductEntity productEntity = productRepository.findById(id).orElseThrow();
            BeanUtils.copyProperties(productEntity, productDTO);
            return productDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info(String.format("Product with id: %s not found.", id));
            throw new ItemNotFoundException(String.format("Product with id: %s not found.", id));
        }
    }
}