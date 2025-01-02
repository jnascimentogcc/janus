package com.autoloan.supply.dto;

import com.autoloan.helper.dto.MasterDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO extends MasterDTO {
    
    @NotBlank
    
    private Object dateOrder;
    
    
    @NotBlank
    private String idCustomer;
    
}