package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import model.Account;


/**
 * Servlet implementation class AccountController
 */
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Account account;
	private List<Account> accounts;
	private AccountDAO accountDAO;
	private List<String> ids = new ArrayList<String>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
      account = new Account();
      accounts = new ArrayList<Account>();
      accountDAO = new AccountDAOImpl();
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btn_save") != null) {
			account.setName(request.getParameter("name"));
			account.setGroupAccount(request.getParameter("group_account"));
			account.setTurn(request.getParameter("turn"));
			System.out.println("save");
			if (account.getId()==0L) {
				System.out.println("save");
				accountDAO.createAccount(account);
			} else {
				System.out.println("save");
				accountDAO.updateAccount(account);
			}
			accounts = accountDAO.readAllAccounts();
			request.setAttribute("accounts", accounts);
			request.getRequestDispatcher("account_list.jsp").forward(request, response);
		}else if(request.getParameter("btn_new")!=null) {
			account = new Account();
			request.getRequestDispatcher("account_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_edit")!=null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				account = accountDAO.readAccount(id);	
			}catch (IndexOutOfBoundsException e) {
				account = new Account();
			}
		 request.setAttribute("account", account);
		 request.getRequestDispatcher("account_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_delete")!=null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				accountDAO.deleteAccount(id);
				accounts = accountDAO.readAllAccounts();
			}catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("accounts", accounts);
			request.getRequestDispatcher("account_list.jsp").forward(request, response);
		}else {
			accounts = accountDAO.readAllAccounts();
			request.setAttribute("accounts", accounts);
			request.getRequestDispatcher("account_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
