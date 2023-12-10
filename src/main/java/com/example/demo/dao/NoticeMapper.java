package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NoticeModel;

@Repository
@Mapper
public interface NoticeMapper {
	List<NoticeModel> noticeList();
	
	Optional<NoticeModel> noticeListOne(int noticeNumber);

//	@Options(useGeneratedKeys = true, keyProperty = "noticeModel.noticeNumber")
	void noticeInsert(NoticeModel noticeModel);

	void noticeUpdate(NoticeModel noticeModel);

	void noticeDelete(int noticeNumber);
}