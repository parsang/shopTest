package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.NoticeModel;

public interface NoticeService {
	public List<NoticeModel> noticeList();
		
	public Optional<NoticeModel> noticeListOne(int noticeNumber);
	
	public void noticeInsert(NoticeModel noticeModel);
	
	public void noticeUpdate(NoticeModel noticeModel);
	
	public void noticeDelete(int noticeNumber);
}