package com.example.list.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskTable {

    private String code;
    private String riskName;

    private String parentCode;


    private List<RiskTable> children;
}
