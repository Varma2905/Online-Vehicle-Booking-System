import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TMSApplication {
    public static void main(String[] args) {
        TransportationManager tm = new TransportationManager();
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTransportation Management System");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Add Route");
            System.out.println("3. Add Shipment");
            System.out.println("4. Assign Vehicle to Shipment");
            System.out.println("5. List Vehicles");
            System.out.println("6. List Shipments");
            System.out.println("7. Exit");

            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Vehicle ID:");
                    String vehicleId = input.nextLine();
                    System.out.println("Enter Vehicle Type:");
                    String type = input.nextLine();
                    System.out.println("Enter Vehicle Capacity (tons):");
                    double capacity = input.nextDouble();
                    tm.addVehicle(new Vehicle(vehicleId, type, capacity));
                    break;
                case 2:
                    System.out.println("Enter Route ID:");
                    String routeId = input.nextLine();
                    System.out.println("Enter Start Location:");
                    String startLocation = input.nextLine();
                    System.out.println("Enter End Location:");
                    String endLocation = input.nextLine();
                    System.out.println("Enter Distance (km):");
                    double distance = input.nextDouble();
                    tm.addRoute(new Route(routeId, startLocation, endLocation, distance));
                    break;
                case 3:
                    System.out.println("Enter Shipment ID:");
                    String shipmentId = input.nextLine();
                    System.out.println("Enter Shipment Description:");
                    String description = input.nextLine();
                    System.out.println("Enter Shipment Weight (kg):");
                    double weight = input.nextDouble();
                    tm.addShipment(new Shipment(shipmentId, description, weight));
                    break;
                case 4:
                    System.out.println("Enter Vehicle ID:");
                    vehicleId = input.nextLine();
                    System.out.println("Enter Shipment ID:");
                    shipmentId = input.nextLine();
                    tm.assignVehicleToShipment(vehicleId, shipmentId);
                    break;
                case 5:
                    tm.listVehicles();
                    break;
                case 6:
                    tm.listShipments();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        input.close();
    }
}

class TransportationManager {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Route> routes = new ArrayList<>();
    private List<Shipment> shipments = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public void addShipment(Shipment shipment) {
        shipments.add(shipment);
    }

    public boolean assignVehicleToShipment(String vehicleId, String shipmentId) {
        Vehicle vehicle = findVehicleById(vehicleId);
        Shipment shipment = findShipmentById(shipmentId);

        if (vehicle != null && shipment != null && vehicle.getStatus().equals("Available") && shipment.getWeight() <= vehicle.getCapacity()) {
            vehicle.setStatus("Assigned");
            shipment.setStatus("In Transit");
            System.out.println("Shipment " + shipmentId + " assigned to Vehicle " + vehicleId);
            return true;
        }
        System.out.println("Assignment failed. Please check the vehicle and shipment details.");
        return false;
    }

    private Vehicle findVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    private Shipment findShipmentById(String shipmentId) {
        for (Shipment shipment : shipments) {
            if (shipment.getShipmentId().equals(shipmentId)) {
                return shipment;
            }
        }
        return null;
    }

    public void listVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getVehicleId() + " - " + vehicle.getType() + " - " + vehicle.getStatus());
        }
    }

    public void listShipments() {
        for (Shipment shipment : shipments) {
            System.out.println(shipment.getShipmentId() + " - " + shipment.getDescription() + " - " + shipment.getStatus());
        }
    }
}

class Vehicle {
    private String vehicleId;
    private String type; 
    private double capacity; 
    private String status;

    public Vehicle(String vehicleId, String type, double capacity) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.capacity = capacity;
        this.status = "Available";
    }

    // Getters and Setters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getType() {
        return type;
    }

    public double getCapacity() {
        return capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class Shipment {
    private String shipmentId;
    private String description;
    private double weight; // in kilograms
    private String status; // Pending, In Transit, Delivered

    public Shipment(String shipmentId, String description, double weight) {
        this.shipmentId = shipmentId;
        this.description = description;
        this.weight = weight;
        this.status = "Pending";
    }

    // Getters and Setters
    public String getShipmentId() {
        return shipmentId;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class Route {
    private String routeId;
    private String startLocation;
    private String endLocation;
    private double distance; // in kilometers

    public Route(String routeId, String startLocation, String endLocation, double distance) {
        this.routeId = routeId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
    }

    // Getters and Setters
    public String getRouteId() {
        return routeId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public double getDistance() {
        return distance;
    }
}
