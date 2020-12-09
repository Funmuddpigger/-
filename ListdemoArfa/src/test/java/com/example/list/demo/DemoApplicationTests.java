package com.example.list.demo;

import com.example.list.demo.entity.RiskTable;
import com.example.list.demo.service.ListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ListService listService;

	@Test
	void contextLoads() {
	}

	@Test
	void delete(){
		List<RiskTable> lists = listService.getByOneParentNode("11");
		for (RiskTable node : lists) {
			if(hasChild(node)){
				getChild(node.getCode());
			}
		}
		for (RiskTable node : lists) {
			System.out.println("del code:"+ node.getCode());
		}
		RiskTable parentCode = listService.getParentByNode("11");
		System.out.println("del parent :"+ parentCode.getCode());
	}

	boolean hasChild(RiskTable node){
		if(node.getChildren()!=null){
			return true;
		}else{
			return false;
		}
	}
	List<RiskTable> getChild(String code){
		List<RiskTable> lists = listService.getByOneParentNode(code);
		for (RiskTable node : lists) {
			System.out.println("delch code:"+ node.getCode());
			if(hasChild(node)){
				return getChild(node.getCode());
			}
		}
		return null;
	}

}
