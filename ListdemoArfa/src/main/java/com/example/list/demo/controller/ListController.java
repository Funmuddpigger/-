package com.example.list.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.list.demo.entity.RiskTable;
import com.example.list.demo.service.ListService;
import com.example.list.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/mylist")
public class ListController {

    @Autowired
    private ListService listService;

    //传递父节点code
    @PostMapping(value = "/node/getNode")
    public Result getByOneParentNode(@RequestParam("parent_code") String parentcode){
        Map<String,Object> maps = new HashMap<>();
        List<RiskTable> byOneParentNode = listService.getByOneParentNode(parentcode);
        RiskTable getParentByNode = listService.getParentByNode(parentcode);
        maps.put("parent",getParentByNode);
        maps.put("children",byOneParentNode);
        return Result.success(maps);
    }

    /*删除节点*/
    @RequestMapping(value = "/node/deleteNode", method = {RequestMethod.GET,RequestMethod.POST})
    public Result deleteNode(@RequestParam("code") String code){
        listService.deleteNode(code);
        return Result.success("success",200);
    }

    @PostMapping("/node/insertRisk")
    public Result insertRisk(@RequestBody JSONObject jsonObject){
        RiskTable riskTable = new RiskTable();
        String code = jsonObject.getString("code");
        String riskName = jsonObject.getString("riskName");
        String parentCode = jsonObject.getString("parentCode");
        riskTable.setCode(code);
        riskTable.setRiskName(riskName);
        riskTable.setParentCode(parentCode);

        listService.insertRisk(riskTable);
        return Result.success("插入成功!");
    }


    /**
     * 向下添加
     */
    @PostMapping("/node/down")
    public Result insertRiskDown(@RequestBody JSONObject jsonObject){
        RiskTable riskTable = new RiskTable();
        String  code = jsonObject.getString("code");
        String riskName = jsonObject.getString("riskName");
        String parentCode = jsonObject.getString("parentCode");
        riskTable.setCode(code);
        riskTable.setRiskName(riskName);
        riskTable.setParentCode(parentCode);
        listService.insertRiskDown(riskTable);
        return   Result.success("插入 down 成功!");
    }

    // 向上插入
    @PostMapping("/node/up")
    public Result insertRiskUp(@RequestBody JSONObject jsonObject){
        RiskTable riskTable = new RiskTable();
        String  code = jsonObject.getString("code");
        String riskName = jsonObject.getString("riskName");
        String parentCode = jsonObject.getString("parentCode");
        riskTable.setCode(code);
        riskTable.setRiskName(riskName);
        riskTable.setParentCode(parentCode);
        listService.insertRiskUp(riskTable);
        return   Result.success("插入 up 成功!");
    }
}
