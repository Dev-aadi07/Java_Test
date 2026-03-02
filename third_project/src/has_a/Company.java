package has_a;

import java.util.List;

public class Company {
	long companyId;
	String campanyName;
	long numberOfEmployee;
	String companyEmail;
	long companyPhoneNumber;
}

class Room {
	long roomId;
}

class WorkSpace{
	long workspaceId;
	Company company;
	List<Room> rooms;
}

class Floor{
	long floorId;
	List<WorkSpace> workspaces;
}

class Address {
	long streetNo;
	String areaName;
}

class Building{
	long buildingId;
	String buildingName;
	String Area;
	Address address;
	List<Floor> floors;
}

class CoworkSpace{
	long id;
	String Name;
	String City;
	Address address;
	List<Building> buildings;
}



