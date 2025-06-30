package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher view = request.getRequestDispatcher("/productList");
		HttpSession session = request.getSession(false);
		
		int code = Integer.parseInt(request.getParameter("product"));
		
		List<Product> sessionList = null;
		if (session.getAttribute("productList") != null) {
			sessionList = (List) session.getAttribute("productList");
		}
		
		List<Product> cartList = new ArrayList<Product>();
		if (session.getAttribute("cartList") != null) {
			cartList = (List) session.getAttribute("cartList");
		}
		if (!sessionList.isEmpty()) {
			for (Product p : sessionList) {
				if (p.getCode() == code)
					cartList.add(p);
			}
		}
		
		
		session.setAttribute("cartList", cartList);
		
		view.forward(request, response);
	}

}
