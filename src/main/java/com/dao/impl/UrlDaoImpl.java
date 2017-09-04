package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.UrlDao;
import com.domain.UrlBean;
import com.util.DbUtil;

public class UrlDaoImpl implements UrlDao {
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public List<UrlBean> queryUrlList() {
		String sql = "SELECT * FROM urlbean";
		List<UrlBean> list = new ArrayList<UrlBean>();
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UrlBean urlBean = new UrlBean();
				urlBean.setUrlid(rs.getInt("urlid"));
				urlBean.setUrl(rs.getString("url"));
				urlBean.setStatus(rs.getInt("status"));
				urlBean.setUpdate_time(rs.getInt("update_time"));
				list.add(urlBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DbUtil.closeAll(conn, pstmt, rs);
		}
		return list;
	}
}
