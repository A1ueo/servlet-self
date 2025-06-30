package view;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangePageServlet
 */
@WebServlet("/changePage")
public class ChangePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/views/countPage.jsp");
		
		Cookie[] cookies =request.getCookies();
		int count = 0;
		for (Cookie c : cookies) {
			if ("count".equals(c.getName())) {
				count = Integer.parseInt(c.getValue());
			}
		}
		count++;
		
		Cookie cookie = new Cookie("count",String.valueOf(count));
		cookie.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie);
		request.setAttribute("count", count);
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
