package com.autoloan.helper.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MasterDTO {
    @NotBlank
    @Size(min = 36, max = 36)
    private String id;
}