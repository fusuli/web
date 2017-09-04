package com.service.impl;

import java.util.List;

import com.dao.UrlDao;
import com.dao.impl.UrlDaoImpl;
import com.domain.UrlBean;

public class BusinessServiceImpl {
	UrlDao uDao = new UrlDaoImpl();
	//对web层提供查询服务
	public List<UrlBean> queryUrlList(){
		return uDao.queryUrlList();	
	}
}
