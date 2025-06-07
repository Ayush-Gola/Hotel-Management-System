package Service;

import java.util.Iterator;
import java.util.Scanner;

import DataBase.DatabaseClass;
import EntityPackage.Booking;
import EntityPackage.RegularUser;
import EntityPackage.Resource;

public class UserService {
	static Scanner sc=new Scanner(System.in);
	public static void showRooms() {

		int p=0;
		Iterator<Resource>i=DatabaseClass.Rooms.iterator();
		while(i.hasNext()) {
			p=1;
			Resource r=i.next();
			System.out.println("                     🫸🫸 Room Number : "+r.no+ " , "+"Type : "+r.type+" , "+"Cost Per Hour : "+r.costPerHr+" , "+"Availaibility : "+r.isAvailaible +" 🫷🫷");

		}
		if(p==0) {
			System.err.println("                                          ‼️‼️ No room is present ‼️‼️");
		}
	}
	
	public static void bookRoom(int roomNo,RegularUser user,Resource res) {
		Iterator<Resource>iter=DatabaseClass.Rooms.iterator();
		int l=0;
		while(iter.hasNext()) {
			Resource r=iter.next();
			if(r.no==roomNo) {
				l=1;
			}
		}
		if(l==0) {
			System.err.println("                                          ‼️‼️ Pls enter correct room no ‼️‼️");
			return;
		}
		Iterator<Resource>i=DatabaseClass.Rooms.iterator();
		int k=0;
		while(i.hasNext()) {
			Resource r=i.next();
			if(r.no==roomNo && r.isAvailaible==false) {
				k=1;
				System.out.println("                                          Srry ‼️‼️.. Room is not availaible ‼️‼️");
			}
		}
		if(k==0) {
			BookingService.roomBooking(roomNo,user,res);
		}
	}
	
	public static RegularUser getUser(String id,String password) {
		Iterator<RegularUser>i=DatabaseClass.userDatabase.iterator();
		while(i.hasNext()) {
			RegularUser r=i.next();
			if(r.id.equals(id) && r.password.equals(password)) {
				return r;
			}
		}
		return null;
	}
	
	public static void cancelRoom(RegularUser res) {
		Iterator<Booking>i=DatabaseClass.bookingDatabase.iterator();
		int p=0;
		while(i.hasNext()) {
			Booking b=i.next();
			if(b.userBooking.equals(res)) {
				p=1;
			}
		}
		if(p==0) {
			System.out.println("                                      No room booked for this user");
		}
		else {
			System.out.println("                                         Enter Room Number ➡️➡️");
			int rNO=sc.nextInt();
			Iterator<Booking>k=DatabaseClass.bookingDatabase.iterator();
			int present=0;
			while(k.hasNext()) {
				Booking l=k.next();
				if(l.r.no==rNO && l.userBooking.equals(res)) {
					present=1;
				}
			}
			if(present==0) {
				System.out.println("                                     ‼️‼️ This room is not booked by this user ‼️‼️");
			}
			else {
				Iterator<Booking>bo=DatabaseClass.bookingDatabase.iterator();
				Booking b=null;
				while(bo.hasNext()) {
					b=bo.next();
					if(b.r.no==rNO) {
						bo.remove();
					}
				}
				b.r.isAvailaible=true;
				System.out.println("                                     ✅✅ Room canceled Successfully ✅✅");
			}
		}
	}
	
	public static void showMyBooked(RegularUser u) {
		Iterator<Booking>i=DatabaseClass.bookingDatabase.iterator();
		int p=0;
		while(i.hasNext()) {
			Booking b=i.next();{
				if(b.userBooking.equals(u)) {
					p=1;
					System.out.println("     User of ID "+b.userBooking.id+" booked room number "+b.r.no);
				}
			}
		}
		if(p==0) {
			System.err.println("                                       ‼️‼️ No Room Booked ‼️‼️");
		}
	}
}
