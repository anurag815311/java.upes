import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Flight {

    private String flightNum;
    private String dest;
    private LocalDateTime depTime;
    private LocalDateTime arrTime;

    public Flight(String flightNum, String dest, LocalDateTime depTime, LocalDateTime arrTime) {
        this.flightNum = flightNum;
        this.dest = dest;
        this.depTime = depTime;
        this.arrTime = arrTime;
    }

    private boolean isUpcoming() {
        return LocalDateTime.now().isBefore(depTime);
    }

    public void updateDepTime(LocalDateTime newDepTime) {
        this.depTime = newDepTime;
    }

    public void updateArrTime(LocalDateTime newArrTime) {
        this.arrTime = newArrTime;
    }

    public void showDetails() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Flight #: " + flightNum);
        System.out.println("Destination: " + dest);
        System.out.println("Departure: " + depTime.format(fmt));
        System.out.println("Arrival: " + arrTime.format(fmt));
        System.out.println("Upcoming: " + (isUpcoming() ? "Yes" : "No"));
    }

    public String getFlightNum() {
        return flightNum;
    }

    public boolean isFlightUpcoming() {
        return isUpcoming();
    }
}

class Airport {

    private String airportName;
    private Flight[] flights;
    private int totalFlights;

    public Airport(String airportName, int maxFlights) {
        this.airportName = airportName;
        this.flights = new Flight[maxFlights];
        this.totalFlights = 0;
    }

    private Flight findFlight(String flightNum) {
        for (int i = 0; i < totalFlights; i++) {
            if (flights[i].getFlightNum().equals(flightNum)) {
                return flights[i];
            }
        }
        return null;
    }

    public boolean addFlight(Flight newFlight) {
        if (totalFlights < flights.length) {
            flights[totalFlights] = newFlight;
            totalFlights++;
            return true;
        }
        return false;
    }

    public boolean removeFlight(String flightNum) {
        for (int i = 0; i < totalFlights; i++) {
            if (flights[i].getFlightNum().equals(flightNum)) {
                for (int j = i; j < totalFlights - 1; j++) {
                    flights[j] = flights[j + 1];
                }
                flights[totalFlights - 1] = null;
                totalFlights--;
                return true;
            }
        }
        return false;
    }

    public void showUpcomingFlights() {
        System.out.println("Upcoming Flights at " + airportName + ":");
        boolean found = false;
        for (int i = 0; i < totalFlights; i++) {
            if (flights[i].isFlightUpcoming()) {
                flights[i].showDetails();
                System.out.println("------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No upcoming flights.");
        }
    }

    public void showCompletedFlights() {
        System.out.println("Completed Flights at " + airportName + ":");
        boolean found = false;
        for (int i = 0; i < totalFlights; i++) {
            if (!flights[i].isFlightUpcoming()) {
                flights[i].showDetails();
                System.out.println("------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No completed flights.");
        }
    }

    public void showAllFlights() {
        System.out.println("All Flights at " + airportName + ":");
        if (totalFlights == 0) {
            System.out.println("No flights available.");
        } else {
            for (int i = 0; i < totalFlights; i++) {
                flights[i].showDetails();
                System.out.println("------------------------");
            }
        }
    }
}

public class AMS {

    public static void main(String[] args) {
        // Initialize the airport with a capacity of 5 flights
        Airport airport = new Airport("International Airport", 5);

        // Define the date-time format
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Create flight instances
        Flight flight1 = new Flight("FL001", "MUMBAI",
                LocalDateTime.parse("2024-10-01 10:30", fmt),
                LocalDateTime.parse("2024-10-01 14:30", fmt));

        Flight flight2 = new Flight("FL002", "KOLKATA",
                LocalDateTime.parse("2024-09-28 09:00", fmt),
                LocalDateTime.parse("2024-09-28 11:45", fmt));

        Flight flight3 = new Flight("FL003", "DEHRADUN",
                LocalDateTime.parse("2024-10-05 15:15", fmt),
                LocalDateTime.parse("2024-10-05 19:00", fmt));

        // Add flights to the airport
        airport.addFlight(flight1);
        airport.addFlight(flight2);
        airport.addFlight(flight3);

        // Display all flights
        System.out.println("All Flights:");
        airport.showAllFlights();

        // Display upcoming flights
        System.out.println("Upcoming Flights:");
        airport.showUpcomingFlights();

        // Update the departure time of flight1
        flight1.updateDepTime(LocalDateTime.parse("2024-10-01 11:00", fmt));
        System.out.println("Updated Flight FL001:");
        flight1.showDetails();

        // Remove a flight
        airport.removeFlight("FL002");

        // Show all flights after removing flight FL002
        System.out.println("All Flights after removal of FL002:");
        airport.showAllFlights();
    }
}
