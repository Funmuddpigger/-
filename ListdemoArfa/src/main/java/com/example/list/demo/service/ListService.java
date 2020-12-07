package com.example.list.demo.service;

import com.example.list.demo.entity.RiskTable;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface ListService {
    List<RiskTable> getByOneParentNode(String code);

    RiskTable getParentByNode(String code);

    int deleteNode(String code);

    public int insertRisk(RiskTable riskTable);

    public int insertRiskDown(RiskTable riskTable);

    public int insertRiskUp(RiskTable riskTable);

    @Async
    void insert(RiskTable riskTable);

}
