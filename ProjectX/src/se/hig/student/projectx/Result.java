package se.hig.student.projectx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.owlike.genson.Genson;

/**
 * Servlet implementation class Result
 */
@WebServlet("/api/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Result() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		TreeMap<String, String> variables = new TreeMap<String, String>();
		variables.put("wall", request.getParameter("wall"));
		variables.put("tier", request.getParameter("tier"));
		try (PrintWriter out = response.getWriter()) {
			ResultData data = new ResultData();
			TreeMap<String, Map<String, String>> mappen = data.getData(variables);
			
			Genson genson = new Genson();
			out.print(genson.serialize(mappen));
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
