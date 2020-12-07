package com.example.list.demo.utils;

import com.example.list.demo.entity.RiskTable;

public class MyTree {

    public String root = null;
    public int codelen = 0;

    public RiskTable getTree(String code,String name){
        RiskTable riskTable = new RiskTable();
        if(code.length()==2){

        }else{
            codelen =  code.length();
        }
        return riskTable;
    }
    public void setTreeRoot(String code,String name){
        root = code;
        if(root.length()>2){

        }
    }

    public void TreeChild(String code,String name){
        if(codelen <=4){
            if(code.substring(0,codelen-3).equals(root)){
                setTreeRoot(code,name);
            }
        }else{
            if(code.substring(0,codelen-3).equals(root.substring(0,codelen-3))){
                setTreeRoot(code,name);
            }
        }

    }
}

