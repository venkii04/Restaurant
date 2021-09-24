package controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.RestaurantDao;
import com.dao.RestaurantDaoImplement;
import com.model.Restaurant;

public class RestaurantAppEntry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//RestaurantDao rdao = new RestaurantDaoImplement();
		//RestaurantDao rdao = new ResturantDaoImplement();
		RestaurantDao rdao=new RestaurantDaoImplement();

		do {
			System.out.println("\n\t##############################");
			System.out.println("\t welcome to resturant system");
			System.out.println("\t################################");
			System.out.println(
					"\n 1--> Search \n 2--> Add \n 3--> Update \n 4--> Delete \n 5--> ActiveResturant \n 6--> DisplayAll \n 7--> Exit");
			System.out.println(" ENTER UR CHOICE : ");
			System.out.println("--------------------");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("@@ Search Restaurant @@");
				System.out.println("Enter Search Restaurant id ");
				int rid = sc.nextInt();

				Restaurant resto = rdao.searchRestaurant(rid);

				if (resto != null)
					// System.out.println("record search successfully !");
					System.out.println("Restaurant_id   :- " + resto.getRid() + "\nRestaurant_Name :- "
							+ resto.getResName() + "\nOpening_Time    :- " + resto.getOpeningTime()
							+ "\nClosing_Time    :- " + resto.getClosingTime() + "\nContact_No      :- "
					 		+ resto.getPhoneNo() + "\nAddress_of_rest :- " + resto.getAddress_of_res()
							+ "\ncuisine         :- " + resto.getCuisine());

				else
					System.out.println("record not searched ");

				break;

			case 2:
				System.out.println("***** Add Restaurant Details *****");
				System.out.println("Enter Restaurant Details");
				System.out.println("Enter restaurant id :");
				rid = sc.nextInt();
				System.out.println("Enter restaurant name :");
				String resName = sc.next();
				System.out.println("Enter restaurant opening time :");
				String openingtime = sc.next();
				System.out.println("Enter restaurant closing time :");
				String closingTime = sc.next();
				System.out.println("Enter restaurant phone number :");
				long phoneNo = sc.nextLong();
				System.out.println("Enter restaurant address :");
				String address_of_res = sc.next();
				System.out.println("Enter restaurant cuisine :");
				String cuisine = sc.next();
				Restaurant restaurant1 = new Restaurant(rid, resName, openingtime, closingTime, phoneNo, address_of_res,
						cuisine);

				boolean isadd = rdao.addRestaurant(restaurant1);

				if (isadd) {
					System.out.println("New Restaurant Added Successfully");

				} else {
					System.out.println("New Restaurant Not Added");
				}

				break;

			case 3:
				System.out.println(" **** Update Restaurant Details ****");
				System.out.println("Enter restaurant id which u want to update");
				rid = sc.nextInt();
				System.out.println("Enter new restaurant name :");
				resName = sc.next();
				System.out.println("Enter new restaurant opening time :");
				openingtime = sc.next();
				System.out.println("Enter new restaurant closing time :");
				closingTime = sc.next();
				// System.out.println("enter new restaurant phone number :");
				// phoneNo = sc.nextLong();
				System.out.println("Enter new restaurant address :");
				address_of_res = sc.next();

				restaurant1 = new Restaurant(rid, resName, openingtime, closingTime, address_of_res);
				boolean isupdate = rdao.Update(restaurant1);
				if (isupdate) {
					System.out.println("Record Updated Successfully");
				} else {
					System.out.println("Records Not Updated");
				}

				break;

			case 4:
				System.out.println("$$ Delete Restaurant details $$");
				System.out.println("Enter id which u want to delete restaurant");
				rid = sc.nextInt();
				boolean isdelete = rdao.Delete(rid);
				if (isdelete) {
					System.out.println("Record Deleted Successfully ");
				} else {
					System.out.println("Not Deleted");
				}

				break;

			case 5:

				System.out.println("## Active And Deactive Restaurant ##");
				System.out.println("Enter restuarant id to check whether retaurant is active or not ");
				rid = sc.nextInt();
				boolean isActive = rdao.activateRestaurant(rid);
				if (isActive) {
					System.out.println("resturant is active");
				} else {
					System.out.println("restaurant is deactive");
				}

				break;

			case 6:
				System.out.println("@@ Display All Restaurant @@");
                System.out.println("----------------------");
				List<Restaurant> Restaurantlist = rdao.getAllResturant();
				for (Restaurant R : Restaurantlist) {
					System.out.println("\n" +R.getRid() + " " + R.getResName() + " " + R.getOpeningTime() + " " + R.getClosingTime()
									+ " " + R.getPhoneNo() + " " + R.getAddress_of_res() + "" + R.getCuisine());
				}
				System.out.println("-----------------------");

				break;

			}

			if (choice == 7)
				break;

		} while (true);

		System.out.println("Thank You");

	}

}
