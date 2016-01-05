package se.hig.student.projectx;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;
import java.sql.*;
public class BuildingChoices {
	private java.sql.Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public TreeMap<String, List<String>> getChoices() {
		
		TreeMap<String, List<String>> choices = new TreeMap<String, List<String>>();
		ArrayList<String> cities = new ArrayList<String>();
		ArrayList<String> yearspan = new ArrayList<String>();
		
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
			resultSet = statement.executeQuery("select city from climatedata");
			while (resultSet.next()) {
				cities.add(resultSet.getString("city"));
			}
			choices.put("cities",cities);
			resultSet = statement.executeQuery("select yearspan from buildingyear");
			while (resultSet.next()) {
				yearspan.add(resultSet.getString("yearspan"));
			}
			choices.put("yearspan", yearspan);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return choices;
	}

}
