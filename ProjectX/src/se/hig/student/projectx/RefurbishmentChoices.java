package se.hig.student.projectx;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;

public class RefurbishmentChoices {

	private java.sql.Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public TreeMap<String, List<String>> getChoices() {
		
		TreeMap<String, List<String>> choices = new TreeMap<String, List<String>>();
		ArrayList<String> tieroflogs = new ArrayList<String>();
		ArrayList<String> outerwalls = new ArrayList<String>();
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		String url = "jdbc:postgresql://localhost/project";
		Properties props = new Properties();
		props.setProperty("user","x");
		props.setProperty("password","megaman");
		props.setProperty("ssl","true");
		try {
			connect = DriverManager.getConnection(url, props);
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select refurbishmenttype from tieroflogs");
			while (resultSet.next()) {
				tieroflogs.add(resultSet.getString("refurbishmenttype"));
			}
			choices.put("tieroflogs",tieroflogs);
			resultSet = statement.executeQuery("select refurbishmenttype from outerwalls");
			while (resultSet.next()) {
				outerwalls.add(resultSet.getString("refurbishmenttype"));
			}
			choices.put("outerwalls", outerwalls);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return choices;
	}

}


