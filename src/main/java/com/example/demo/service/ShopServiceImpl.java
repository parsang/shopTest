package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ShopMapper;
import com.example.demo.model.ShopModel;

@Service(value = "shopService")
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ShopMapper cardMapper;
	
	@Override
	public List<ShopModel> memberList() {
		return cardMapper.memberList();
	}
}