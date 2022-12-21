package Park;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Parking extends Structure {
	private String name;
	private String city;
	private String street;
	private int zip; 
	
	public Parking() throws SQLException {
		super();	
	}
	
	@Override
	public void insert() throws SQLException {
		System.out.println("Enter parking ID: ");
		this.id = scan.nextInt();
		System.out.println("Enter parking name: ");
		scan.nextLine();
		this.name = scan.nextLine();
		System.out.println("Enter city: ");
		this.city = scan.nextLine();
		System.out.println("Enter street: ");
		this.street = scan.nextLine();
		System.out.println("Enter zip code: ");
		this.zip = scan.nextInt();
		scan.nextLine();
		s.executeUpdate("insert into parkings values (" + id+", '" + name + "', '" + city + "', '" + street + "', '" + zip + "')");
	}
	
	@Override
	public void update() throws SQLException {
		System.out.println("Which parking do you want to update: ");
		id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter new name:");
		city = scan.nextLine();
		System.out.println("Enter new city:");
		street = scan.nextLine();
		System.out.println("Enter new street:");
		street = scan.nextLine();
		System.out.println("Enter new zip:");
		zip = scan.nextInt();
		scan.nextLine();
		
		s.executeUpdate("update parkings set name = '" + 
		name + "', city = '" + city + "', street = '" + street + "', zip = " + zip +
		"where parking_id = " + id);
	}
	
	@Override  
	public void delete() throws SQLException {
		System.out.println("Enter id of parking you want to delete: ");
		id = scan.nextInt();
		scan.nextLine();
		
		s.executeUpdate("delete from parkings where parking_id = " + id);
	}

	@Override
	public void showByID() throws SQLException {
		System.out.println("Enter id of parking you want to view: ");
		id = scan.nextInt();
		
		ResultSet rs = s.executeQuery("select * from parkings where parking_id = " + id);
		rs.next();
		System.out.println("ID: " + rs.getString(1) + "\nName: " + rs.getString(2) + "\nCity: " + rs.getString(3) + "\nStreet: " + rs.getString(4) + "\nZIP code: " + rs.getString(5));	
	}
	
	public void zonesByParkingID() throws SQLException {
		System.out.println("Enter parking id of zones you want to view: ");
		id = scan.nextInt();
		
		ResultSet rs = s.executeQuery("select * from parking_zones where parking_id = " + id);
		while(rs.next()) {
			System.out.println("zone ID: " + rs.getString(1) + "\nName of zone: " + rs.getString(2) + '\n');	
		}
	}
}
