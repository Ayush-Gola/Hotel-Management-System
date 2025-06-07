package Driver;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DataBase.DatabaseClass;
import EntityPackage.RegularUser;
import EntityPackage.Resource;
import EntityPackage.ResourceManager;
import Service.AdminServices;

import Service.ResourceManagerService;
import Service.ResourceService;
import Service.UserService;

public class Driverclass {
	public static void main(String[] args) {
		System.out.println("---------------------------------- 😊😊  Welcome to our Hotel 😊😊 -----------------------------------------------");
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️🎗🎗️  WHO ARE YOU ❓  🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️");
			System.out.println();
			System.out.println("                                             1:Admin 😊");
			System.out.println("                                             2:Regular User 😊");
			System.out.println("                                             3:Resource Manager 😊");  
			System.out.println("                                             4:Exit 😊");
			System.out.println();
			System.out.println("                                         Enter your choice ➡️➡️");
			String s=sc.nextLine();
			if(s.equals("4")) {
				System.out.println("--------------------------------------- Thanku 🤗..Visit us Again 💦 ‼️‼️ ---------------------------------------------");
				break;
			}
			
			switch (s) {
			case "1": {
				while(true) {
				System.out.println();
				System.out.println("🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️  WHAT SERVICE YOU WANT TO USE ❓❓  🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️🎗🎗️");
				System.out.println();
				System.out.println("                                             1:View Users ✅");
				System.out.println("                                             2:Remove User ✅");
				System.out.println("                                             3:Show Bookings ✅");
				System.out.println("                                             4:View Resource Managers ✅");
				System.out.println("                                             5:Exit ✅");
				System.out.println();
				System.out.println("                                         Enter your choice ➡️➡️");
				String choice = sc.nextLine();
				if(choice.equals("5")) {
					break;
				}
				switch (choice) {
				case "1": {
					AdminServices.seeAllUsers();
				}break;
				case "2": {
					System.out.println("                                         Enter id of the user ➡️➡️");
					String idRem = sc.nextLine();
					AdminServices.removeUser(idRem);
				}break;
				case "3":{
					AdminServices.showBookings();
				}break;
				case "4":{
					ResourceManagerService.seeManagers();
				}break;
				default: {
					System.out.println("Enter correct choice");
					break;
				}
				}
				}
			}break;
			case "2": {
				while (true) {
					System.out.println();
					System.out.println("🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️🎗🎗️  Want to login or register ❓❓  🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️🎗🎗️");
					System.out.println("                                             1:Login ✅");
					System.out.println("                                             2:Register ✅");
					System.out.println("                                             3:Exit ✅");
					System.out.println();
					System.out.println("                                         Enter your choice ➡️➡️");
					String cho = sc.nextLine();
					if(cho.equals("3")) {
						break;
					}
					switch (cho) {
					case "1": {
						System.out.println("                                         Enter id ➡️➡️");
						String idLogin = sc.nextLine();
						System.out.println("                                         Enter password ➡️➡️");
						String passLogin = sc.nextLine();
						boolean b = AdminServices.checkUser(idLogin, passLogin);
						if(b==true) {
							System.out.println("                                     ✅✅ User login successfully ✅✅");
						}
						if (b == true) {
							while(true) {
							System.out.println();
							System.out.println("🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️  WHAT SERVICE YOU WANT TO USE ❓❓  🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️🎗🎗️");
							System.out.println("                                             1:Show Rooms ✅");
							System.out.println("                                             2:Book Room ✅");
							System.out.println("                                             3:Cancel Room ✅");
							System.out.println("                                             4:Show my booked Rooms ✅");
							System.out.println("                                             5:Exit ✅");
							System.out.println();
							System.out.println("                                         Enter your choice ➡️➡️");
							String choiceUser = sc.nextLine();
							if(choiceUser.equals("5")) {
								break;
							}
							switch (choiceUser) {
							case "1": {
								UserService.showRooms();
							}break;
							case "2": {
								System.out.println("                                         Enter Room Number ➡️➡️");
								int roomNo = sc.nextInt();
								RegularUser r=UserService.getUser(idLogin, passLogin);
								Resource res=ResourceService.getResource(roomNo);
								if(r!=null) {
									UserService.bookRoom(roomNo,r,res);
									sc.nextLine();
								}
							}break;
							case "3":{
								RegularUser r=UserService.getUser(idLogin, passLogin);
								UserService.cancelRoom(r);
							}break;
							case "4":{
								RegularUser r=UserService.getUser(idLogin, passLogin);
								UserService.showMyBooked(r);
							}break;
							default:{
								System.err.println("                                       ‼️‼️ Pls enter correct choice ‼️‼️");
							}break;
							}
							}
						} 
						else {
							System.err.println("                                       ‼️‼️ Enter Correct Credentials ‼️‼️");
						}
					}break;
					case "2": {
						String na="";
						while (true) {
							System.out.println("                                         Enter Name ➡️➡️");
						    na = sc.nextLine();
						    if (na.matches("^(?!\\d+$)[A-Za-z0-9_@. ]{2,30}$")) {
						        break;
						    } else {
								System.err.println("                                       ‼️‼️ Pls enter valid name ‼️‼️");
						    }
						}
						
						System.out.println("                                         Enter ID ➡️➡️");
						String id = sc.nextLine();
						boolean k = AdminServices.CheckUserId(id);
						if (k == true) {
							System.err.println("                                       ‼️‼️ User already present with same id ‼️‼️");
						} 
						else {
							System.out.println("                                         Enter Password ➡️➡️");
							String pass = sc.nextLine();
							while(pass.length()<4) {
								System.out.println("                                         Enter Password....Password must be of atleast four length ➡️➡️");
								pass=sc.nextLine();
							}
							System.out.println("                                         Enter Password again ➡️➡️");
							String passAgain = sc.nextLine();
							if (!passAgain.equals(pass)) {
								System.err.println("                                       ‼️‼️ Pls Enter correct password ‼️‼️");
							} else {
								RegularUser u = new RegularUser(na, id, pass);
								DatabaseClass.userDatabase.add(u);
								System.out.println("                                     ✅✅ User Registered successfully ✅✅");
							}
						}
					}break;
					default:{
						System.err.println("                                       ‼️‼️ Pls enter correct choice ‼️‼️");
					}
					}
				}
			}break;
			case "3":{
				while (true) {
					System.out.println("🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️🎗🎗️  Want to login or register ❓❓  🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️🎗🎗️");
					System.out.println("                                             1:Login ✅");
					System.out.println("                                             2:Register ✅");
					System.out.println("                                             3:Exit ✅");
					System.out.println();
					System.out.println("                                         Enter your choice ➡️➡️");
					String cho = sc.nextLine();
					if(cho.equals("3")) {
						break;
					}
					switch (cho) {
					case "1": {
						System.out.println();
						System.out.println("                                         Enter ID ➡️➡️");
						String idLogin = sc.nextLine();
						System.out.println("                                         Enter Password ➡️➡️");
						String passLogin = sc.nextLine();
						boolean b = ResourceManagerService.checkResourceManagerWithPassword(idLogin,passLogin);
						if(b==true) {
							System.out.println("                                     ✅✅ Manager login successfully ✅✅");
							while(true) {
								System.out.println();
								System.out.println("🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️  WHAT SERVICE YOU WANT TO USE ❓❓  🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️🎗🎗️");
								System.out.println("                                             1:Add Room ✅");
								System.out.println("                                             2:Delete Room ✅");
								System.out.println("                                             3:Edit Room ✅");
								System.out.println("                                             4:See Rooms ✅");
								System.out.println("                                             5:Exit ✅");
								System.out.println();
								System.out.println("                                         Enter your choice ➡️➡️");
								;
								String choiceUser = sc.nextLine();
								if(choiceUser.equals("5")) {
									break;
								}
								switch (choiceUser) {
								case "1": {
									ResourceManagerService.addRoom();
								}break;
								case "2": {
									ResourceManagerService.deleteRoom();
								}break;
								case "3":{
									ResourceManagerService.editRoom();
								}break;
								case "4":{
									ResourceManagerService.seeRooms();
								}break;
								
								default:{
									System.err.println("                                       ‼️‼️ Enter Correct Choice ‼️‼️");
								}break;
								}
								}
						}
						
						else {
							System.err.println("                                       ‼️‼️ Enter Correct Credentials ‼️‼️");
						}
					}break;
					case "2": {
						String na="";
						while (true) {
							System.out.println("                                         Enter Name ➡️➡️");
						    na = sc.nextLine();
						    if (na.matches("^(?!\\d+$)[A-Za-z0-9_@. ]{2,30}$")) {
						        break;
						    } else {
								System.err.println("                                       ‼️‼️ Enter Valid Name ‼️‼️");
						    }
						}
						
						
						System.out.println("                                         Enter ID ➡️➡️");
						String id = sc.nextLine();
						boolean k = ResourceManagerService.checkResourceManager(id);
						if (k == true) {
							System.out.println("                                         Manager already present with same id");
						} 
						else {
							System.out.println("                                         Enter Password ➡️➡️");
							String pass = sc.nextLine();
							while(pass.length()<4) {
								System.out.println("                                         Enter Password....Password must be of atleast four length ➡️➡️");
								pass=sc.nextLine();
							}
							
							System.out.println("                                         Enter Password again ➡️➡️");
							String passAgain = sc.nextLine();
							if (!passAgain.equals(pass)) {
								System.err.println("                                       ‼️‼️ Enter correct password ‼️‼️");
							} else {
								ResourceManager u = new ResourceManager(na, id, pass);
								DatabaseClass.managerDatabase.add(u);
								System.out.println();
								System.out.println("                                     ✅✅ Manager registered successfully ✅✅");
							}
						}
					}break;
					default:{
						System.out.println();
						System.err.println("                                       ‼️‼️ Pls...Enter correct choice ‼️‼️");
						System.out.println();
					}
					}
				}
			}break;
			default:{
				System.out.println();
				System.err.println("                                       ‼️‼️ Pls...Enter correct choice ‼️‼️");
				System.out.println();
			}
			
		}
	}
}
}

