public class Vehicle {
    private String vehicleId;
    private String type; // e.g., Truck, Van
    private double capacity; // in tons
    private String status; // Available, In Maintenance, Assigned

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
