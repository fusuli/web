package com.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pageServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// showone(request,response);
		try {
			showtwo(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void showone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from student";
		try {
			conn = ConnectionTest.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Student> list = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setSex(rs.getString("sex"));
				stu.setBirth(rs.getDate("birth"));
				list.add(stu);
			}
			// response.sendRedirect("studentlist.jsp");
			request.setAttribute("list", list);
			request.getRequestDispatcher("studentlist.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showtwo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		// 当前是第几页
		String currentpageStr;
		if (request.getParameter("currentpage") == null || request.getParameter("currentpage").equals("")) {
			currentpageStr = "1";
		} else {
			currentpageStr = request.getParameter("currentpage");
		}
		System.out.println(currentpageStr);
		int currentpage = Integer.parseInt(currentpageStr) <= 0 ? 1 : Integer.parseInt(currentpageStr);
		// 每页显示多少条
		int maximum = 5;
		// 可以显示多少页
		int viewperpage = 5;

		String sql = "select * from student limit " + (currentpage - 1) * maximum + "," + maximum;
		conn = ConnectionTest.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Student> list = new ArrayList<Student>();
		while (rs.next()) {
			Student stu = new Student();
			stu.setId(rs.getInt("id"));
			stu.setName(rs.getString("name"));
			stu.setAge(rs.getInt("age"));
			stu.setSex(rs.getString("sex"));
			stu.setBirth(rs.getDate("birth"));
			list.add(stu);
		}
		String sql2 = "select * from student";
		ResultSet rs2 = pstmt.executeQuery(sql2);
		int count = 0;
		while (rs2.next()) {
			count++;
		}
		long totalrecordnumber;
		if (count % maximum == 0) {
			totalrecordnumber = count / maximum;
		} else {
			totalrecordnumber = count / maximum + 1;
		}

		// 将数据都封装到pageView
		PageView pageView = new PageView(list, totalrecordnumber, currentpage, maximum, viewperpage);

		request.setAttribute("pageView", pageView);
		request.setAttribute("list", list);
		request.getRequestDispatcher("studentlist.jsp").forward(request, response);

	}
}