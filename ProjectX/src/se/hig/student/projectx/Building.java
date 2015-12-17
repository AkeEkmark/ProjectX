package se.hig.student.projectx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Building
 */
@WebServlet("/api/Building")
public class Building extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Building() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()) {
			out.print("{"
					+ "'cities' : ['Gävle', 'Stockholm'],"
					+ "'yearspans' : ['-1920', '1921-1940'],"
					+ "'buildingtypes' : ['Bostad', Lokal'],"
					+ "}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
