package Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import DataBase.DatabaseClass;
import EntityPackage.Booking;
import EntityPackage.RegularUser;

public class AdminServices {
	public static void seeAllUsers() {
		int c=0;
		Iterator<RegularUser> i=DatabaseClass.userDatabase.iterator();
		while(i.hasNext()) {
			c=1;
			RegularUser u=i.next();
			System.out.println("                                  🫸🫸 NAME : "+u.name+ " , "+"ID : "+u.id+" , "+"PASSWORD : "+u.password +" 🫷🫷");
		}
		if(c==0) {
			System.err.println("                                          ‼️‼️ No user is present ‼️‼️");
		}
	}
	public static boolean checkUser(String Id,String password) {
		Iterator<RegularUser> i=DatabaseClass.userDatabase.iterator();
		while(i.hasNext()) {
			RegularUser reg=i.next();
			if(reg.id.equals(Id) && reg.password.equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean CheckUserId(String id) {
		Iterator<RegularUser> i=DatabaseClass.userDatabase.iterator();
		while(i.hasNext()) {
			RegularUser reg=i.next();
			if(reg.id.equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void removeUser(String id) {
		Iterator<RegularUser>i=DatabaseClass.userDatabase.iterator();
		int c=0;
		while(i.hasNext()) {
			RegularUser u=i.next();
			if(u.id.equals(id)) {
				c=1;
				Iterator<Booking>iter=DatabaseClass.bookingDatabase.iterator();
				while(iter.hasNext()) {
					Booking b=iter.next();
					if(b.userBooking.equals(u)) {
						b.r.isAvailaible=true;
						iter.remove();
					}
				}
				i.remove();
			}
		}
		if(c==0) {
			System.err.println("                                       ‼️‼️ User not found of this ID ‼️‼️");
		}
		else {
			System.out.println("                                     ✅✅ User remove successfully ✅✅");
		}
	}
	
	public static void showBookings() {
		Iterator<Booking>i=DatabaseClass.bookingDatabase.iterator();
		int p=0;
		while(i.hasNext()) {
			p=1;
			Booking b=i.next();
			System.out.println("   User with ID "+b.userBooking.id+" and name "+b.userBooking.name+" booked room number "+b.r.no+" for time duration "+b.timeDuration+" hours "+" and cost is "+b.cost);
		}
		if(p==0) {
			System.err.println("                                       ‼️‼️ No bookings are made ‼️‼️");
		}
	}
	
//public static void generateReport() throws IOException{
//    	
//    	File file = new File("Booking Reports.csv");
//    	file.createNewFile();
//    	
//    	
//    	FileWriter fileWriter = new FileWriter(file);
//    	fileWriter.write("Customer name, Customer ID,Rooms Booked, Bill\n");
//    	
//    	Iterator<Booking> bookingItr = DatabaseClass.bookingDatabase.iterator();
//    	
//    	while(bookingItr.hasNext()) {
//    		Booking booking = bookingItr.next();
//    		RegularUser customer = booking.userBooking;
//    		String name = customer.name;
//    		String	email = customer.id;
//    		
//    		
//    		
//    		ArrayList<Room> rooms = booking.bookedRooms;
//    		
//    		Iterator<Room> roomItr = rooms.iterator();
//    		int singleRooms = 0;
//    		int doubleRooms = 0;
//    		int tripletRooms = 0;
//    		double price = 0;
//    		
//    		while(roomItr.hasNext()) {
//    			Room r = roomItr.next();
//    			if(r.type.equals("single")){
//    				singleRooms++;
//    				price += Room.singleRoomPrice;
//    			}
//    			else if(r.type.equals("double")){
//    				doubleRooms++;
//    				price += Room.doubleRoomPrice;
//    			}
//    			else if(r.type.equals("triplet")){
//    				tripletRooms++;
//    				price += Room.tripletRoomPrice;
//    			}		
//    		}
//    		
//
//        	
//        	fileWriter.write(name + "," + email + "," + age + "," + singleRooms + "," + doubleRooms + "," + tripletRooms + "," + price + "\n");
//        	
//    		
//    		
//    	}
//    	
//    	System.out.println("Report generated!!");
//    	fileWriter.close();
//
//    	
//    }
}
