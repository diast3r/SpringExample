package com.example.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
// Mybatis 라이브러리에 포함된 패키지에서 import함.

import com.example.lesson02.domain.UsedGoods;


@Mapper // Mybatis의 어노테이션. Spring bean으로 등록
public interface UsedGoodsMapper {
	
	// input:X -> BO 한테서.
	// output:List<UsedGoods> -> BO한테.
	public List<UsedGoods> selectUsedGoodsList();
}
