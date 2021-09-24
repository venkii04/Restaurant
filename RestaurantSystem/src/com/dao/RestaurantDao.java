package com.dao;
import com.model.Restaurant;
import java.util.ArrayList;
import java.util.List;

public interface RestaurantDao {
	public  Restaurant searchRestaurant(int rid);
    public boolean addRestaurant(Restaurant r);
    public boolean Update(Restaurant r);
    public boolean Delete(int rid);
    public boolean activateRestaurant(int rid);
    public List<Restaurant> getAllResturant();

}

