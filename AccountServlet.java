package com.me.AccountSystem.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.me.AccountSystem.Bean.Account;
import com.me.AccountSystem.Dao.AccountDao;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountServlet() {
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
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if (method.equals("select")) {
			try {
				select(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (method.equals("shouzhi")) {
			try {
				shouzhi(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (method.equals("addAccount")) {
			try {
				AddAccount(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (method.equals("selectByWay")) {
			try {
				selectByWay(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (method.equals("selectByDate")) {
			try {
				selectByDate(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (method.equals("selectByMoney")) {
			try {
				selectByMoney(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (method.equals("deleteAccount")) {
			try {
				deleteAccount(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (method.equals("updateAccount")) {
			try {
				updateAccount(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (method.equals("selectF")) {
			try {
				selectFamilyAccounts(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (method.equals("transfer")) {
			try {
				transfer(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void transfer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String name1 = request.getParameter("name1");
		String name2 = request.getParameter("name2");
		int money = Integer.parseInt(request.getParameter("money"));
		boolean is = AccountDao.transfer(name1, name2, money);
		if (is) {
			try {
				request.getRequestDispatcher("success.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}

	}

	private void selectFamilyAccounts(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("identity");
		System.out.println(id);
		List<Account> list = AccountDao.selectFamilyAccounts(id);
		if (!list.isEmpty()) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("listF.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	}

	private void updateAccount(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String way = request.getParameter("way");
		String description = request.getParameter("description");
		String money = request.getParameter("money");
		String date = request.getParameter("date");
		Account a = new Account();
		a.setName(name);
		a.setWay(way);
		a.setDescription(description);
		a.setMoney(money);
		a.setDate(date);
		if (AccountDao.updateAccount(a)) {
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("function.jsp").forward(request, response);
		}
	}

	private void deleteAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		if (AccountDao.deleteAccount(id)) {
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	}

	private void selectByMoney(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String money = request.getParameter("money");
		String name = request.getParameter("name");
		List<Account> WayList = AccountDao.selectAccountByMoney(money, name);
		if (!WayList.isEmpty()) {
			request.setAttribute("list", WayList);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	}

	private void selectByDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String date = request.getParameter("date");
		String name = request.getParameter("name");
		System.out.println(date);
		System.out.println(name);
		List<Account> WayList = AccountDao.selectAccountsByDate(date, name);
		if (!WayList.isEmpty()) {
			request.setAttribute("list", WayList);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("fail.jsp").forward(request, response);

		}
	}

	private void selectByWay(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String des = request.getParameter("description");
		String name = request.getParameter("name");
		System.out.println(des);
		System.out.println(name);
		List<Account> WayList = AccountDao.selectAccountByLike(name, des);
		if (!WayList.isEmpty()) {
			request.setAttribute("list", WayList);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}

	}

	private void AddAccount(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String way = request.getParameter("way");
		String description = request.getParameter("description");
		String money = request.getParameter("money");
		String date = request.getParameter("date");
		Account a = new Account();
		a.setName(name);
		a.setWay(way);
		a.setDescription(description);
		a.setMoney(money);
		a.setDate(date);
		if (AccountDao.addAccount(a)) {
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	}

	private void shouzhi(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		Account s = AccountDao.sumOfZhiChu(name);
		System.out.println(s.getMoney());
		request.setAttribute("zhichu", s);
		Account c = AccountDao.sumOfShouRu(name);
		System.out.println(s.getMoney());
		request.setAttribute("shouru", c);
		if (s != null && c != null) {
			request.getRequestDispatcher("shouzhi.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("function.jsp").forward(request, response);
		}
	}

	private void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		List<Account> list = AccountDao.selectAllAccounts(name);
		if (!list.isEmpty()) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("noAccount.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
