package se.hig.student.projectx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.owlike.genson.Genson;

/**
 * Servlet implementation class Refurbishment
 */
@WebServlet("/api/Refurbishment")
public class Refurbishment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Refurbishment() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("application/json;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()) {
			RefurbishmentChoices choices = new RefurbishmentChoices();
			TreeMap<String, List<String>> mappen = choices.getChoices();
			
			Genson genson = new Genson();
			out.print(genson.serialize(mappen));
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
