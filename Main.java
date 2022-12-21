package Park;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		options();
		int n = scan.nextInt();
		while (n != 5) {
			switch(n) {
			case 1:
				parkings(scan);
				break;
			case 2:
				zones(scan);
				break;
			case 3:
				places(scan);
				break;
			case 4:
				cars(scan);
				break;
			case 5:
				System.out.println("End program");
				break;
			}
			options();
			n = scan.nextInt();
		}
	}
	
	private static void options() {
		System.out.println("Choose option with number:\n"
				+ "1. Parkings\n"
				+ "2. Parking zones\n"
				+ "3. Parking places\n"
				+ "4. Cars\n"
				+ "5. End program");
	}
	
	private static void cars(Scanner scan) throws SQLException {
		Car c = new Car();
		System.out.println("Options:\n"
				+ "1. Insert\n"
				+ "2. Update\n"
				+ "3. Delete\n"
				+ "4. Show car by id\n"
				+ "5. Show in which parking place is the car\n"
				+ "6. Show in which parking zone is the car\n"
				+ "7. Show in which parking is the car");
		int op = scan.nextInt();
		switch(op) {
		case 1: 
			c.insert();
			break;
		case 2: 
			c.update();
			break;
		case 3: 
			c.delete();
			break;
		case 4: 
			c.showByID();
			break;
		case 5: 
			c.carsParkingPlace();
			break;
		case 6:
			c.carsParkingZone();
			break;
		case 7:
			c.carsParking();
			break;
		}
	}
	
	private static void places(Scanner scan) throws SQLException {
		ParkingPlace p = new ParkingPlace();
		System.out.println("Options:\n"
				+ "1. Insert\n"
				+ "2. Update\n"
				+ "3. Delete\n"
				+ "4. Show zone by id\n"
				+ "5. Show car by parking place Id");
		int op = scan.nextInt();
		switch(op) {
		case 1: 
			p.insert();
			break;
		case 2: 
			p.update();
			break;
		case 3: 
			p.delete();
			break;
		case 4: 
			p.showByID();
			break;
		case 5: 
			p.showCarByParkingPlace();
			break;
		}
	}
	
	private static void zones(Scanner scan) throws SQLException {
		ParkingZone p = new ParkingZone();
		System.out.println("Options:\n"
				+ "1. Insert\n"
				+ "2. Update\n"
				+ "3. Delete\n"
				+ "4. Show zone by id\n"
				+ "5. Show parking places by parking zone Id");
		int op = scan.nextInt();
		switch(op) {
		case 1: 
			p.insert();
			break;
		case 2: 
			p.update();
			break;
		case 3: 
			p.delete();
			break;
		case 4: 
			p.showByID();
			break;
		case 5: 
			p.parkingPlacesByZoneID();
			break;
		}
	}
	
	private static void parkings(Scanner scan) throws SQLException {
		Parking p = new Parking();
		System.out.println("Options:\n"
				+ "1. Insert\n"
				+ "2. Update\n"
				+ "3. Delete\n"
				+ "4. Show parking by id\n"
				+ "5. Show parking zones by parking Id\n");	
		int op = scan.nextInt();
		switch(op) {
		case 1: 
			p.insert();
			break;
		case 2: 
			p.update();
			break;
		case 3: 
			p.delete();
			break;
		case 4: 
			p.showByID();
			break;
		case 5: 
			p.zonesByParkingID();
			break;
		}
	}

}
