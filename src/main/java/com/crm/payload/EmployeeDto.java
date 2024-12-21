package com.crm.payload;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private String name;
    private String emailId;
    private String mobile;

}
