package week3.lab;

class Vehicle {
    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName;

    private String vehicleId, brand, model;
    private double rentPerDay;
    private boolean isAvailable;

    public Vehicle(String id, String brand, String model, double rentPerDay) {
        this.vehicleId = id;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        totalVehicles++;
    }

    public double rentVehicle(int days) {
        if (!isAvailable) throw new IllegalStateException("Not available.");
        isAvailable = false;
        double rent = rentPerDay * days;
        totalRevenue += rent;
        return rent;
    }

    public void returnVehicle() { isAvailable = true; }

    public void displayVehicleInfo() {
        System.out.println(vehicleId + " | " + brand + " " + model + " | Rent/Day: " + rentPerDay + " | Available: " + isAvailable);
    }

    public static void setCompanyName(String name) { companyName = name; }
    public static void displayCompanyStats() {
        System.out.println("Company: " + companyName + " | Total Vehicles: " + totalVehicles + " | Revenue: " + totalRevenue);
    }
}

public class RentalSystem {
    public static void main(String[] args) {
        Vehicle.setCompanyName("ZoomCars");

        Vehicle v1 = new Vehicle("V001", "Toyota", "Innova", 1500);
        Vehicle v2 = new Vehicle("V002", "Honda", "City", 1200);

        v1.displayVehicleInfo();
        System.out.println("Rent charged: " + v1.rentVehicle(3));
        v1.displayVehicleInfo();

        v1.returnVehicle();
        v1.displayVehicleInfo();

        Vehicle.displayCompanyStats();
    }
}
