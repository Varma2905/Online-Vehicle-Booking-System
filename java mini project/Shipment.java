public class Shipment {
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
