package com.read.files.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.assignments.framework.utilities.DBUtil;

public class ReadDB {

	public static void main(String[] args) throws SQLException {
		
		String query = "SELECT film.title AS movie, category.name AS categoryname,language.name AS language FROM category \r\n"
				+ "JOIN\r\n"
				+ "film_category\r\n"
				+ "ON category.category_id = film_category.category_id\r\n"
				+ "JOIN\r\n"
				+ "film\r\n"
				+ "ON film_category.film_id = film.film_id\r\n"
				+ "JOIN\r\n"
				+ "language\r\n"
				+ "ON \r\n"
				+ "film.language_id = language.language_id\r\n"
				+ "WHERE category.name = 'Horror'\r\n"
				+ "ORDER BY film.title ASC\r\n"
				+ "LIMIT 10;\r\n"
				+ "";
		
		
		List<Map<String,String>> data = DBUtil.readData(query);

		System.out.println(data.get(1).get("movie"));
	}

}
