package com.dao.impl.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dao.impl.UrlDaoImpl;
import com.domain.UrlBean;

public class UrlDaoImplTest {

	@Test
	public void testQueryUrlList() throws ClassNotFoundException, SQLException {
		System.out.println("eee");
		UrlDaoImpl urlDaoImpl = new UrlDaoImpl();
		List<UrlBean> lists = urlDaoImpl.queryUrlList();
		System.out.println("aaa");
		for(UrlBean l:lists) {
	    	System.out.println(l);
	    }
		Assert.assertNotNull(lists);
	}

	@Test
	public void testQueryUrlList1() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root",
				"root");

		String sql = "select * from urlbean";
		List<UrlBean> list = new ArrayList<UrlBean>();
		System.out.println("s1ss");

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("s2ss");
		while (rs.next()) {
			UrlBean urlBean = new UrlBean();
			urlBean.setUrlid(rs.getInt("urlid"));
			urlBean.setUrl(rs.getString("url"));
			urlBean.setStatus(rs.getInt("status"));
			urlBean.setUpdate_time(rs.getInt("update_time"));
			list.add(urlBean);
		}
		rs.close();
	    pstmt.close();
	    conn.close();
	    for(UrlBean l:list) {
	    	System.out.println(l);
	    }

		System.out.println("sss");
		Assert.assertNotNull(list);
	}

}
