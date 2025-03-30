# Online-Vehicle-Booking-System
# Transportation Management System (TMS)

## Overview
The Transportation Management System (TMS) is a simple Java-based application that allows users to manage vehicles, routes, and shipments efficiently. The system provides functionalities to add and list vehicles, routes, and shipments, as well as assign vehicles to shipments.

## Features
- Add new vehicles with unique IDs, types, and capacities.
- Add new routes with start and end locations and distance.
- Add shipments with unique IDs, descriptions, and weights.
- Assign vehicles to shipments based on availability and capacity.
- View lists of vehicles and shipments.

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Collections Framework (List)
- Exception Handling

## Installation and Setup
1. Ensure you have **Java JDK 8+** installed.
2. Clone this repository:
   ```sh
   git clone https://github.com/yourusername/TMSApplication.git
   ```
3. Navigate to the project directory:
   ```sh
   cd TMSApplication
   ```
4. Compile the Java files:
   ```sh
   javac TMSApplication.java
   ```
5. Run the application:
   ```sh
   java TMSApplication
   ```

## Class Descriptions
### 1. `TMSApplication.java`
This is the main class that provides a menu-driven interface for the user to interact with the transportation management system.

### 2. `TransportationManager.java`
This class handles the core functionality, including storing vehicles, routes, and shipments, and assigning vehicles to shipments.

### 3. `Vehicle.java`
Represents a vehicle with an ID, type, capacity, and status (Available, Assigned, etc.).

### 4. `Route.java`
Represents a route with an ID, start and end locations, and distance in kilometers.

### 5. `Shipment.java`
Represents a shipment with an ID, description, weight, and status (Pending, In Transit, Delivered).

### 6. `ThrowDemo.java`
Demonstrates exception handling by throwing and catching a custom exception.

## Usage
1. Run the program.
2. Select an option from the menu.
3. Follow the prompts to add vehicles, routes, or shipments.
4. Assign vehicles to shipments when needed.
5. View the list of vehicles and shipments.
6. Exit the program when done.

## Contributing
Feel free to contribute by submitting issues or pull requests.

## License
This project is licensed under the **MIT License**.

