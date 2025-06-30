package std02.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaOrderEndServlet
 */
@WebServlet("/pizzaOrderEnd")
public class PizzaOrderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaOrderEndServlet() {
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
		
		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		String userEmail = request.getParameter("user_email");
		
		String pizzaSizeNum = request.getParameter("pizza_size");
		String[] toppingNumArr = request.getParameterValues("toppings");
		
		String pizzaSize = "";
		int price = 0;
		switch (pizzaSizeNum) {
		case "1":
			pizzaSize = "스몰";
			price += 15900;
			break;
		case "2":
			pizzaSize = "미디엄";
			price += 21000;
			break;
		case "3":
			pizzaSize = "라지";
			price += 27900;
			break;
		}
		
		String[] toppingArr = new String[toppingNumArr.length];
		for (int i = 0; i < toppingNumArr.length; i++) {
			switch (toppingNumArr[i]) {
			case "1":
				toppingArr[i] = "새우";
				price += 2000;
				break;
			case "2":
				toppingArr[i] = "고구마";
				price += 1000;
				break;
			case "3":
				toppingArr[i] = "감자";
				price += 1000;
				break;
			case "4":
				toppingArr[i] = "파인애플";
				price += 1000;
				break;
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pizzaOrder");
		
		request.setAttribute("user_name", userName);
		request.setAttribute("user_phone", userPhone);
		request.setAttribute("user_email", userEmail);
		
		request.setAttribute("pizza_size", pizzaSize);
		request.setAttribute("toppings", toppingArr);
		request.setAttribute("price", price);
		
		dispatcher.forward(request, response);
	}

}
