package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import configuration.DBConnect;
import com.model.Restaurant;


public class RestaurantDaoImplement implements RestaurantDao {
	public Restaurant searchRestaurant(int rid) {
		Restaurant r = null;
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement prestatement = connection.prepareStatement("select * from restaurant where rid=? ")) {
			prestatement.setInt(1, rid);
			ResultSet resultset = prestatement.executeQuery();

			while (resultset.next()) {
				r = new Restaurant();
				r.setRid(resultset.getInt("rid"));
				r.setResName(resultset.getString("resname"));
				r.setOpeningTime(resultset.getString("opening_time"));
				r.setClosingTime(resultset.getString("closing_time"));
				r.setPhoneNo(resultset.getLong("phone_no"));
				r.setAddress_of_res(resultset.getString("address"));
				r.setClosingTime(resultset.getString("cuisine"));
				
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		return r;

	}

	
	public boolean addRestaurant(Restaurant r) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement prestatement = connection.prepareStatement(
						"insert into restaurant(rid,name,opening_time,closing_time,phone_no,address,cuisine) values(?,?,?,?,?,?,?)")) {
			prestatement.setInt(1, r.getRid());
			prestatement.setString(2, r.getResName());
			prestatement.setString(3, r.getOpeningTime());
			prestatement.setString(4, r.getClosingTime());
			prestatement.setLong(5, r.getPhoneNo());
			prestatement.setString(6, r.getAddress_of_res());
			prestatement.setString(7, r.getCuisine());
			prestatement.executeUpdate();

			return true;

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean Update(Restaurant r) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement prestatement = connection.prepareStatement(
						"update restaurant set name=?,opening_time=?, closing_time=?,address=? where rid=?")) {

			prestatement.setString(1, r.getResName());
			prestatement.setString(2, r.getOpeningTime());
			prestatement.setString(3, r.getClosingTime());
			prestatement.setString(4, r.getAddress_of_res());
			prestatement.setInt(5, r.getRid());

			// prestatement.setLong(6, 10);
			// prestatement.setString(7, r.getCuisine());

			prestatement.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return false;
	}

 public List<Restaurant> getAllResturant() {
		ArrayList<Restaurant> Restaurantlist = new ArrayList<Restaurant>();
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement prestatement = connection
						.prepareStatement("select * from restaurant ")) {

			ResultSet rs = prestatement.executeQuery();
			while (rs.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setRid(rs.getInt(1));
				restaurant.setResName(rs.getString(2));
				restaurant.setOpeningTime(rs.getString(3));
				restaurant.setClosingTime(rs.getString(4));
				restaurant.setPhoneNo(rs.getLong(5));
				restaurant.setAddress_of_res(rs.getString(6));
				restaurant.setCuisine(rs.getString(7));

				Restaurantlist.add(restaurant);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Restaurantlist;
	}

	
	public boolean Delete(int rid) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement prestatement = connection
						.prepareStatement("delete from restaurant where rid= " + rid)) {
			prestatement.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return false;
	}

	public boolean activateRestaurant(int id) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement prestatement = connection
						.prepareStatement("update restaurant set isactive='y' where rid"+id)) {
			prestatement.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return false;
	}

}
