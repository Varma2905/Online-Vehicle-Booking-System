import java.util.ArrayList;
import java.util.List;

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

        if (vehicle != null && shipment != null && vehicle.getStatus().equals("Available") && shipment.getWeight() <= vehicle.getCapacity() * 1000) { // Convert tons to kg
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
