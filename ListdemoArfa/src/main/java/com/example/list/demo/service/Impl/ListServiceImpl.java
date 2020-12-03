package com.example.list.demo.service.Impl;

import com.example.list.demo.entity.RiskTable;
import com.example.list.demo.mapper.ListMapper;
import com.example.list.demo.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    private ListMapper listMapper;


    @Override
    public List<RiskTable> getByOneParentNode(String code) {

        return listMapper.getByOneParentNode(code);
    }

    @Override
    public RiskTable getParentByNode(String code) {
        return listMapper.getParentByNode(code);
    }

    @Override
    public int deleteNode(String code) {
        return listMapper.deleteNode(code);
    }

    @Override
    public int insertRisk(RiskTable riskTable) {
        return listMapper.insertRisk(riskTable);
    }

    @Override
    public int insertRiskDown(RiskTable riskTable) {
        return listMapper.insertRiskDown(riskTable);
    }

    @Override
    public int insertRiskUp(RiskTable riskTable) {
        return listMapper.insertRiskUp(riskTable);
    }

}
