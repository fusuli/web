package com.dao;

import java.util.List;

import com.domain.UrlBean;

public interface UrlDao {
	public List<UrlBean> queryUrlList();
}