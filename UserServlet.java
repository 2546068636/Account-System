package com.me.AccountSystem.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.me.AccountSystem.Bean.UserBean;
import com.me.AccountSystem.Dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		response.setCharacterEncoding("UTF-8");
		if (method.equals("login")) {
			try {
				login(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (method.equals("exit")) {
			exit(request, response);
		} else if (method.equals("register")) {
			try {
				register(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (method.equals("updateUser")) {
			try {
				updateUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		int account = Integer.parseInt(request.getParameter("account"));
		String identity = request.getParameter("identity");
		UserBean user = new UserBean();
		user.setName(name);
		user.setAccount(account);
		user.setIdentity(identity);
		user.setPassword(password);
		user.setSex(sex);
		user.setPhone(phone);
		if (UserDao.update(user)) {
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String id = request.getParameter("identity");
		String password = request.getParameter("password");
		int account = Integer.parseInt(request.getParameter("account"));
		UserBean user = new UserBean();
		user.setName(name);
		user.setSex(sex);
		user.setPhone(phone);
		user.setIdentity(id);
		user.setPassword(password);
		user.setAccount(account);
		if (UserDao.register(user)) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	private void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();// 清楚session数据
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		UserBean user = new UserBean();
		user = UserDao.login(name, password);
		request.setAttribute("who", user);
		if (user != null) {
			request.getRequestDispatcher("function.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
