package com.service.impl;

import java.util.List;

import com.dao.UrlDao;
import com.dao.impl.UrlDaoImpl;
import com.domain.UrlBean;

public class BusinessServiceImpl {
	UrlDao uDao = new UrlDaoImpl();
	//��web���ṩ��ѯ����
	public List<UrlBean> queryUrlList(){
		return uDao.queryUrlList();	
	}
}
