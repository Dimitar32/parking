package Park;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingPlace extends Structure {
	private int number;
	private int zoneId;
	private int carId;
	
	public ParkingPlace() throws SQLException {
		super();
	}
	
	@Override
	public void insert() throws SQLException {
		System.out.println("Enter new place id: ");
		id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter new place number: ");
		number = scan.nextInt();
		System.out.println("Enter zone id:");
		zoneId = scan.nextInt();
		while (!isValidZone(zoneId)) {
			System.out.println("Invalid zone id enter new: ");
			zoneId = scan.nextInt();
		}
		scan.nextLine();
		System.out.println("Enter car id");
		String carId = scan.nextLine();
		while (!isValidCar(carId)) {
			System.out.println("Invalid car id enter new:");
			carId = scan.nextLine();
		}
		scan.nextLine();
		
		s.executeUpdate("insert into cars values (" + id + ", " + number + ", " + zoneId + ", " + carId + ")");	
	}
	
	private boolean isValidZone(int zoneId) throws SQLException {
		ResultSet rs = s.executeQuery("select zone_id from parking_zones");
		while(rs.next()) {
			if (rs.getInt(1) == zoneId) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isValidCar(String carId) throws SQLException {
		ResultSet rs = s.executeQuery("select car_id from cars");
		while(rs.next()) {
			if (rs.getString(1).equals(carId) || carId.equals("null")) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void update() throws SQLException {
		System.out.println("Which place do you want to update: ");
		id = scan.nextInt();
		System.out.println("Enter new place number:");
		number = scan.nextInt();
		System.out.println("Enter new zone id:");
		zoneId = scan.nextInt();
		System.out.println("Enter new car id:");
		carId = scan.nextInt();
		scan.nextLine();
		
		s.executeUpdate("update parking_places set place_num = " + number + ", zone_id = " + zoneId + ", car_id = " + carId + "where place_id = " + id);
	}
	
	@Override
	public void delete() throws SQLException {
		System.out.println("Enter id of place you want to delete: ");
		id = scan.nextInt();
		scan.nextLine();
		
		s.executeUpdate("update cars set place_id = null where place_id = " + id);
		s.executeUpdate("update parking_places set zone_id = null, car_id = null where place_id = " + id);
		s.executeUpdate("delete from parking_places where place_id = " + id);
	}

	@Override
	public void showByID() throws SQLException {
		System.out.println("Enter id of place you want to view: ");
		id = scan.nextInt();
		
		ResultSet rs = s.executeQuery("select * from parking_places where place_id = " + id);
		rs.next();
		System.out.println("Place ID: " + rs.getString(1) + "\nPlace number: " + rs.getString(2) +
				"\nZone ID: " + rs.getString(3) + "\nCar ID:" + rs.getString(4));	
	}
	
	public void showCarByParkingPlace() throws SQLException {
		System.out.println("Enter id of place you want to view its car: ");
		id = scan.nextInt();
		
		ResultSet rs = s.executeQuery("select car_id from parking_places where place_id = " + id);
		rs.next();
		ResultSet rsCars = s.executeQuery("select * from cars where car_id = " + rs.getString(1));
		rsCars.next();
		System.out.println("Car ID: " + rsCars.getString(1) + "\nPlate num: " + rsCars.getString(2) + "\nPlace ID: " + rsCars.getString(3));
	}
}
