package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NoticeMapper;
import com.example.demo.dao.ShopMapper;
import com.example.demo.model.NoticeModel;
import com.example.demo.model.ShopModel;

@Service(value = "ContextService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeMapper NoticeMapper;
	
	@Override
	public List<NoticeModel> noticeList() {
		return NoticeMapper.noticeList();
	}
	
	@Override
	public Optional<NoticeModel> noticeListOne(int noticeNumber) {
		try {
			return NoticeMapper.noticeListOne(noticeNumber);			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public void noticeInsert(NoticeModel noticeModel) {
		NoticeMapper.noticeInsert(noticeModel);
	}
	
	@Override
	public void noticeUpdate(NoticeModel noticeModel) {
		NoticeMapper.noticeUpdate(noticeModel);
	}
	
	@Override
	public void noticeDelete(int noticeNumber) {
		NoticeMapper.noticeDelete(noticeNumber);
	}
}