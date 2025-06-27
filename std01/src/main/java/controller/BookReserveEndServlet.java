package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookReserveEndServlet
 */
@WebServlet("/bookReserveEnd")
public class BookReserveEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReserveEndServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		String userEmail = request.getParameter("user_email");
		
		String bookNum = request.getParameter("book_name");
		String borrowPeriod = request.getParameter("borrow_period");
		
		String bookName = "";
		int price = 0;
		int period = Integer.parseInt(borrowPeriod);
		
		switch (bookNum) {
		case "1":
			bookName = "자바 프로그래밍 입문";
			price = 1500 + 500 * (period - 1);
			break;
		case "2":
			bookName = "웹 개발의 기초";
			price = 1800 + 500 * (period - 1);
		break;
		case "3":
			bookName = "데이터베이스 시스템";
			price = 2000 + 500 * (period - 1);
		break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/book/reserve.jsp");
		request.setAttribute("user_name", userName);
		request.setAttribute("user_phone", userPhone);
		request.setAttribute("user_email", userEmail);
		request.setAttribute("book_name", bookName);
		request.setAttribute("borrow_period", borrowPeriod);
		request.setAttribute("price", price);
		
		dispatcher.forward(request, response);
		
//		response.sendRedirect("/bookReserve");
	}

}
