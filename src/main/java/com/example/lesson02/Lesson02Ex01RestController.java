package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController
public class Lesson02Ex01RestController {
	
	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	// http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() { // DB의 used_goods 테이블에 해당하는 객체를 만들 것임.
		// 이름 짓는 형식 
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		
		return usedGoodsList; // JSON String => Response
	}
}
