package com.javaguides.banking_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Accountdto {
    private long id;
    private String accountholdernamed;
    private double balence;
}
