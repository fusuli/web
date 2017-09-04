package com.domain;

public class UrlBean {
	private int urlid;

	private String url;

	private int status;

	private int update_time;

	public UrlBean() {
		
	}
	public UrlBean(int urlid, String url, int status, int update_time) {
		this.urlid = urlid;
		this.url = url;
		this.status = status;
		this.update_time = update_time;
	}

	public int getUrlid() {
		return urlid;
	}

	public void setUrlid(int urlid) {
		this.urlid = urlid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(int update_time) {
		this.update_time = update_time;
	}
}
