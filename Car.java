package Park;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Car extends Structure {
	private int plateNumber;
	private int placeId;
	
	public Car() throws SQLException {
		super();
	}
	
	@Override
	public void insert() throws SQLException {
		System.out.println("Enter car id: ");
		id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter car number: ");
		plateNumber = scan.nextInt();
		System.out.println("Enter place id: ");
		placeId = scan.nextInt();
		while (!isValidPlace(placeId)) {
			System.out.println("Invalid place enter new:");
			placeId = scan.nextInt();
		}
		scan.nextLine();
		
		s.executeUpdate("insert into cars values (" + id + ", '" + plateNumber + "', " + placeId + ")");	
	}
	
	private boolean isValidPlace(int p) throws SQLException {
		ResultSet rs = s.executeQuery("select place_id from parking_places");
		while (rs.next()) {
			int place = rs.getInt(1);
			if (place == p) {
				return true;
			}
		}

		return false;
	}
	
	@Override
	public void update() throws SQLException {
		System.out.println("Which car do you want to update?");
		id = scan.nextInt();
		System.out.println("Enter new plate number:");
		plateNumber = scan.nextInt();
		System.out.println("Enter new place id:");
		int pID = scan.nextInt();
		scan.nextLine();
		
		s.executeUpdate("update cars set plate_num = '" 
		+ plateNumber + "', place_id = '" + pID + "' where car_id = " + id);
	}
	
	@Override
	public void delete() throws SQLException {
		System.out.println("Enter id of car you want to delete: ");
		id = scan.nextInt();
		scan.nextLine();
		
		s.executeUpdate("update cars set place_id = null where car_id = " + id);
		s.executeUpdate("delete from cars where car_id = " + id);
	}

	@Override
	public void showByID() throws SQLException {
		System.out.println("Enter id of car you want to view: ");
		id = scan.nextInt();
		
		ResultSet rs = s.executeQuery("select * from cars where car_id = " + id);
		rs.next(); 
		
		System.out.println("Car ID: " + rs.getString(1) + "\nPlate num: " + rs.getString(2) + "\nPlace ID: " + rs.getString(3));
	}
	
	public void carsParkingPlace() throws SQLException {
		System.out.println("Enter car id which place you want to view: ");
		id = scan.nextInt();
		ResultSet rs = s.executeQuery("select place_id from cars where car_id = " + id);
		rs.next();
		String placeId = rs.getString(1);
		ResultSet rs1 = s.executeQuery("select * from parking_places where place_id = " + placeId);
		rs1.next();
		System.out.println("Place ID: " + rs1.getString(1) + "\nPlace number: " + rs1.getString(2) +
				"\nZone ID: " + rs1.getString(3) + "\nCar ID:" + rs1.getString(4));	
	}
	
	public void carsParkingZone() throws SQLException {
		System.out.println("Enter car id which parking zone you want to view: ");
		id = scan.nextInt();
		
		ResultSet rs = s.executeQuery("select place_id from cars where car_id = " + id);
		rs.next(); 
		String placeId = rs.getString(1);
		
		ResultSet rsPlace = s.executeQuery("select * from parking_places where place_id = " + placeId);
		rsPlace.next();
		String zoneId = rsPlace.getString(3);
		
		ResultSet rsZone = s.executeQuery("select * from parking_zones where zone_id = " + zoneId);
		rsZone.next();
		
		System.out.println("Zone ID: " + rsZone.getString(1) + "\nZone name: " + rsZone.getString(2) 
							+ "\nParking ID: " + rsZone.getString(3));	
	}
	
	public void carsParking() throws SQLException {
		System.out.println("Enter car id which parking you want to view: ");
		id = scan.nextInt();
		
		ResultSet rs = s.executeQuery("select place_id from cars where car_id = " + id);
		rs.next();
		String placeId = rs.getString(1);
		
		ResultSet rsPlace = s.executeQuery("select * from parking_places where place_id = " + placeId);
		rsPlace.next(); 
		String zoneId = rsPlace.getString(3);
		
		ResultSet rsZone = s.executeQuery("select * from parking_zones where zone_id = " + zoneId);
		rsZone.next(); 
		String parkingId = rsZone.getString(3);
		
		ResultSet rsParking = s.executeQuery("select * from parkings where parking_id = " + parkingId);
		rsParking.next();
		
		System.out.println("ID: " + rsParking.getString(1) + "\nName: " + rsParking.getString(2) + "\nCity: " 
		+ rsParking.getString(3) + "\nStreet: " + rsParking.getString(4) + "\nZIP code: " + rsParking.getString(5));	
	}
}
