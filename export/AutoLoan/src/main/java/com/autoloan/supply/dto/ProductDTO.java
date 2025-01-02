package com.autoloan.supply.dto;

import com.autoloan.helper.dto.MasterDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO extends MasterDTO {
    
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
    
    
    
    private Double price;
    
    @NotBlank
    @Size(min = 1, max = 20)
    private String barCode;
    
    
    @NotBlank
    private String idGroupProduct;
    
}