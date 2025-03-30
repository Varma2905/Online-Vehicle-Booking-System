public class Route {
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
