package Park;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingZone extends Structure {
	private String name;
	private int parkingID;
	
	public ParkingZone() throws SQLException {
		super();
	}
	
	@Override
	public void insert() throws SQLException {
		System.out.println("Enter zone id: ");
		id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter zone name: ");
		name = scan.nextLine();
		System.out.println("Enter parking id: ");
		parkingID = scan.nextInt();
		while (!isValid(parkingID)) {
			System.out.println("Invalid parking id enter new: ");
			parkingID = scan.nextInt();
		}
		scan.nextLine();
		
		s.executeUpdate("insert into parking_zones values (" + id + ", '" + name + "', " + parkingID + ")");
	}
	
	private boolean isValid(int p) throws SQLException {
		ResultSet rs = s.executeQuery("select parking_id from parkings");
		while (rs.next()) {
			if (rs.getInt(1) == p) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void update() throws SQLException {
		System.out.println("Which parking zone do you want to update?");
		id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter new zone name:");
		name = scan.nextLine();
		System.out.println("Enter new parking id:");
		int parkingID = scan.nextInt();
		while (!isValid(parkingID)) {
			System.out.println("Invalid parking id enter new: ");
			parkingID = scan.nextInt();
		}
		scan.nextLine();
		
		s.executeUpdate("update parking_zones set zone_name = '" 
		+ name + "', parking_id = '" + parkingID + "' where zone_id = " + id);
	}
	
	@Override
	public void delete() throws SQLException {
		System.out.println("Enter id of zone you want to delete: ");
		id = scan.nextInt();
		scan.nextLine();
		
		s.executeUpdate("update parking_zones set parking_id = null where zone_id = " + id);
		s.executeUpdate("delete from parking_zones where zone_id = " + id);
	}

	@Override
	public void showByID() throws SQLException {
		System.out.println("Enter id of zone you want to view: ");
		id = scan.nextInt();
		
		ResultSet rs = s.executeQuery("select * from parking_zones where zone_id = " + id);
		rs.next();
		System.out.println("Zone ID: " + rs.getString(1) + "\nZone name: " + rs.getString(2) + "\nParking ID: " + rs.getString(3));	
	}
	
	public void parkingPlacesByZoneID() throws SQLException {
		System.out.println("Enter zone id of parking places you want to view: ");
		id = scan.nextInt();
		
		ResultSet rs = s.executeQuery("select * from parking_places where zone_id = " + id);
		while (rs.next()) {
			System.out.println("Place ID:" + rs.getString(1) + ", Place number: " + rs.getString(2) + ", Zone ID: " + rs.getString(3) + ", Car ID: " + rs.getString(4));	
		}
	}
}
