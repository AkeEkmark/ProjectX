package se.hig.student.projectx;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class ResultData {
	private java.sql.Connection connect = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	
	public TreeMap<String, Map<String, String>> getData(Map<String, String> variables) {
		TreeMap<String, Map<String, String>> data = new TreeMap<String, Map<String, String>>();
		TreeMap<String, String> tieroflogs = new TreeMap<String, String>();
		TreeMap<String, String> walls = new TreeMap<String, String>();
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
			statement = connect.prepareStatement("SELECT investmentcost, climateimpact FROM tieroflogs WHERE refurbishmenttype = ?");
			statement.setString(1, variables.get("tier"));
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				tieroflogs.put("investmentcost", resultSet.getString("investmentcost"));
				tieroflogs.put("climateimpact", resultSet.getString("climateimpact"));
			}
			data.put("tieroflogs",tieroflogs);
			
			statement = connect.prepareStatement("SELECT investmentcost, climateimpact FROM outerwalls WHERE refurbishmenttype = ?");
			statement.setString(1, variables.get("wall"));
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				walls.put("investmentcost", resultSet.getString("investmentcost"));
				walls.put("climateimpact", resultSet.getString("climateimpact"));
			}
			data.put("walls", walls);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return data;
	}

}
