package com.example.list.demo.mapper;

import com.example.list.demo.entity.RiskTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ListMapper {
    //查询父节点
    public RiskTable getParentByNode(String code);
    //查询子节点
    public List<RiskTable> getByOneParentNode(String code);

    //删除节点
    public int deleteNode(String code);

    public int insertRisk(RiskTable riskTable );

    public int insertRiskDown(RiskTable riskTable);

    public int insertRiskUp(RiskTable riskTable);

    public void insert(RiskTable riskTable);

    public String selectNode(String code);
}
