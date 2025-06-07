package Service;

import java.util.Iterator;
import java.util.Scanner;

import DataBase.DatabaseClass;
import EntityPackage.RegularUser;
import EntityPackage.Resource;
import EntityPackage.ResourceManager;

public class ResourceManagerService {
	static Scanner sc=new Scanner(System.in);
	public static boolean checkResourceManager(String id) {
		Iterator<ResourceManager> i=DatabaseClass.managerDatabase.iterator();
		while(i.hasNext()) {
			ResourceManager res=i.next();
			if(res.id.equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkResourceManagerWithPassword(String Id,String password) {
		Iterator<ResourceManager> i=DatabaseClass.managerDatabase.iterator();
		while(i.hasNext()) {
			ResourceManager res=i.next();
			if(res.id.equals(Id) && res.password.equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public static void seeManagers() {
		int p=0;
		Iterator<ResourceManager>i=DatabaseClass.managerDatabase.iterator();
		while(i.hasNext()) {
			p=1;
			ResourceManager r=i.next();
			System.out.println("                                  🫸🫸 NAME : "+r.name+ " , "+"ID : "+r.id+" , "+"PASSWORD : "+r.password +" 🫷🫷");

		}
		if(p==0) {
			System.err.println("                                          ‼️‼️ No Manager is present ‼️‼️");
		}
	}
	
	public static void addRoom() {
		System.out.println();
		System.out.println("                                         Enter unique no ➡️➡️");
		int n=sc.nextInt();
		Iterator<Resource>i=DatabaseClass.Rooms.iterator();
		while(i.hasNext()){
			Resource r=i.next();
			if(r.no==n) {
				System.err.println("                                       ‼️‼️ This room no is already present ‼️‼️");
				return;
			}
		}
		System.out.println("                                         Enter type ➡️➡️");
		sc.nextLine();
		String str=sc.nextLine();
		System.out.println("                                         Enter cost per hour ➡️➡️");
		int cost=sc.nextInt();
		if(cost<0) {
			System.err.println("                                       ‼️‼️ Cost is invalid ‼️‼️");
			return;
		}
		sc.nextLine();
		Resource r=new Resource(n,str,cost,true);
		DatabaseClass.Rooms.add(r);
	}
	
	public static void seeRooms() {
		int p=0;
		Iterator<Resource>i=DatabaseClass.Rooms.iterator();
		while(i.hasNext()) {
			p=1;
			Resource r=i.next();
			System.out.println("                                  🫸🫸 NUMBER : "+r.no+ " , "+"TYPE : "+r.type+" , "+"COST PER HOUR : "+r.costPerHr+" , "+"AVAILAIBILITY : "+r.isAvailaible +" 🫷🫷");

		}
		if(p==0) {
			System.err.println("                                          ‼️‼️ No Room Availaible ‼️‼️");
		}
	}
	
	public static void deleteRoom() {
		System.out.println("                                         Enter Room number ➡️➡️");
		int no=sc.nextInt();
		Iterator<Resource>it=DatabaseClass.Rooms.iterator();
		int p=0;
		int c=0;
		while(it.hasNext()) {
			Resource r=it.next();
			if(r.no==no) {
				c=1;
			}
		}
		if(c==0) {
			System.err.println("                                       ‼️‼️ Pls Enter correct room number ‼️‼️");
			return;
		}
		it=DatabaseClass.Rooms.iterator();
		while(it.hasNext()) {
			Resource r=it.next();
			if(r.no==no) {
				c=1;
			}
			if(r.no==no && r.isAvailaible==true) {
				p=1;
				it.remove();
				System.out.println("                                     ✅✅ Room Deleted Successfully ✅✅");
				return;
			}
		}
		if(p==0) {
			System.err.println("        Someone is using this room ....so this room cant be deleted");
		}
	
	}
	
	public static void editRoom() {
		System.out.println("                                         Enter Room number ➡️➡️");
		int no=sc.nextInt();
		Iterator<Resource>i=DatabaseClass.Rooms.iterator();
		int p=0;
		Resource res=null;
		while(i.hasNext()) {
			res=i.next();
			if(res.no==no) {
				p=1;
				break;
			}
		}
		if(p==0) {
			System.err.println("                                       ‼️‼️ Room of this number is not present ‼️‼️");
			return;
		}
		System.out.println("🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️  WHAT YOU WANT TO EDIT ❓❓  🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗️🎗🎗️🎗️🎗🎗️");
		System.out.println("                                             1:Type ✅");
		System.out.println("                                             2:Cost Per Hour ✅");
		System.out.println("                                             3:Availaibility ✅");
		System.out.println("                                             4:Exit ✅");
		System.out.println();
		System.out.println("                                         Enter Your Choice ➡️➡️");
		sc.nextLine();
		String ch=sc.nextLine();

		switch(ch) {

		case "4":{
			return;
		}
		case "1":{
			System.out.println("                                         Enter new type ➡️➡️");
			
			String str=sc.nextLine();
			res.type=str;
			System.out.println("                                     ✅✅ Type Updated ✅✅");
		}break;
		case "2":{
			System.out.println("                                         Enter New Cost ➡️➡️");
			int co=sc.nextInt();
			res.costPerHr=co;
			System.out.println("                                     ✅✅ Cost Updated ✅✅");
		}break;
		case "3":{
			System.out.println("                                         Enter New Availaibility ➡️➡️");
			sc.nextLine();
			boolean b=sc.nextBoolean();
			res.isAvailaible=b;
			System.out.println("                                     ✅✅ Availaibility Updated ✅✅");
		}break;
		default:{
			System.err.println("                                       ‼️‼️ Enter Correct Choice ‼️‼️");
		}break;
		}
		
	}
}
