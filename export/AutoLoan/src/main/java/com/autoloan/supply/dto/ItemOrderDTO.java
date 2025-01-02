package com.autoloan.supply.dto;

import com.autoloan.helper.dto.MasterDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemOrderDTO extends MasterDTO {
    
    @NotBlank
    
    private Integer qtD;
    
    @NotBlank
    
    private Double discount;
    
    
    @NotBlank
    private String idOrder;
    
    @NotBlank
    private String idProduct;
    
}