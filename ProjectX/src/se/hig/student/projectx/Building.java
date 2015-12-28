package se.hig.student.projectx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.owlike.genson.Genson;

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
			TreeMap<String, List<String>> mappen = new TreeMap<>();
			List<String> cities = new ArrayList<>();
			List<String> yearspans = new ArrayList<>();
			List<String> buildingtypes = new ArrayList<>();
			cities.add("Gävle");
			cities.add("Stockholm");
			yearspans.add("-1920");
			yearspans.add("1921-1940");
			buildingtypes.add("Bostad");
			
			buildingtypes.add("Lokal");
			mappen.put("cities", cities);
			mappen.put("yearspans", yearspans);
			mappen.put("buildingtypes", buildingtypes);
			Genson genson = new Genson();
			out.print(genson.serialize(mappen));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
