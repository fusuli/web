package com.test;

import java.util.List;

public class PageView {
	private List<Student> records;// 记录
	private Long totalrecordnumber;// 总记录数
	private Integer startindex;// 第一页
	private Integer endindex;// 最后一页
	private Integer totalpagenumber;// 总页数
	private Integer currentpage;// 当前页

	public PageView(List<Student> records, Long totalrecordnumber, int currentpage, int maximum, int viewperpage)
	// 构造函数
	{
		this.records = records;
		this.totalrecordnumber = totalrecordnumber;
		this.currentpage = currentpage;
		totalpagenumber = (int) (totalrecordnumber % maximum == 0 ? totalrecordnumber / maximum
				: totalrecordnumber / maximum + 1);// 获得总页数
		setIndex(currentpage, viewperpage, totalpagenumber);
	}

	public List<Student> getRecords() {
		return records;
	}

	public Long getTotalrecordnumber() {
		return totalrecordnumber;
	}

	public Integer getStartindex() {
		return startindex;
	}

	public Integer getEndindex() {
		return endindex;
	}

	public Integer getTotalpagenumber() {
		return totalpagenumber;
	}

	public Integer getCurrentpage() {
		return currentpage;
	}

	// 获得总页数 显示页数 当前页数 第一页 最后一页
	public void setIndex(int currentpage, int viewperpage, int totalpagenumber) {
		if (viewperpage >= totalpagenumber) {
			startindex = 1;
			endindex = totalpagenumber;
		} else {
			if (currentpage <= viewperpage / 2) {
				startindex = 1;
				endindex = viewperpage;
			} else if ((currentpage + viewperpage / 2) > totalpagenumber) {
				startindex = totalpagenumber - viewperpage + 1;
				endindex = totalpagenumber;
			} else {
				startindex = currentpage - (viewperpage - 1) / 2;
				endindex = currentpage + viewperpage / 2;
			}
		}
	}
}
