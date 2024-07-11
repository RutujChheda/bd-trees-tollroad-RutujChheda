

// import java.util.Comparator;
// import java.util.Map;
// import java.util.TreeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Application to demonstrate a TreeMap storing key:value pairs in sorted
 * order based on natural ordering of keys and also a different ordering
 * of the same keys based on the results of a Comparator.
 */
public class TollRoad {
    // TODO 1: Declare two Map variables to associate String keys with Vehicle objects.
    // TODO 1: One will sort by vehicle description and one will sort by vehicle state.
    private Map<String, Vehicle> vehiclesByDescription;
    private Map<String, Vehicle> vehiclesByState;


    /**
     * TollRoad constructor creates two TreeMaps to store data with
     * different keys. The second uses a Comparator to store based
     * on the state code of each vehicle.
     */
    public TollRoad() {
        // TODO 2: Create the two TreeMap objects, the second of which must be
        // TODO 2: given an appropriate Comparator object when constructed.
        this.vehiclesByDescription = new TreeMap<>();

        Comparator<String> vehicleStateComparator = (description1, description2) -> {
            // First, compare the second and third characters for sorting by state code.
            int stateCodeComparison = description1.substring(1, 3).compareTo(description2.substring(1, 3));
            if (stateCodeComparison != 0) {
                return stateCodeComparison;
            }
            // If the state codes are identical, then compare the entire descriptions to check for complete equality.
            return description1.compareTo(description2);
        };
        this.vehiclesByState = new TreeMap<>(vehicleStateComparator);

    }

    /**
     * Adds a toll with the given vehicle's description. If the vehicle has
     * already passed through a toll reader, its toll count is updated.
     * If this is the first time the vehicle has passed through a toll
     * reader, a new Vehicle object is created and added to the TreeMaps.
     *
     * @param description The Vehicle's description.
     */
    public void addToll(String description) {
        // TODO 3: Complete this method as described in the exercise.
            Vehicle vehicle;
            if (vehiclesByDescription.containsKey(description)) {
                // Vehicle already exists, so retrieve it and increment the toll count.
                vehicle = vehiclesByDescription.get(description);
                vehicle.addToll();
            } else {
                // Vehicle does not exist, so create a new one and add it to both maps.
                vehicle = new Vehicle(description);
                vehiclesByDescription.put(description, vehicle);
            }
            // Ensure the vehiclesByState map is using the same Vehicle instance.
            vehiclesByState.put(description, vehicle);
    }

    /**
     * Builds and returns a String containing the current Vehicles
     * sorted by description.
     *
     * @return String containing the current vehicles, sorted by description.
     */
    public String getVehicleReportByDescription() {
        // TODO 4: Complete this method as described in the exercise.
        StringBuilder report = new StringBuilder();
        for (Vehicle vehicle : vehiclesByDescription.values()) {
            report.append(vehicle).append("\n");
        }
        return report.toString();
    }

    /**
     * Builds and returns a String containing the current Vehicles
     * sorted by state.
     *
     * @return String containing the current vehicles, sorted by state.
     */
    public String getVehicleReportByState() {
        // TODO 5: Complete this method as described in the exercise.
        StringBuilder report = new StringBuilder();
        for (Vehicle vehicle : vehiclesByState.values()) {
            report.append(vehicle).append("\n");
        }
        return report.toString();
    }

    /**
     * Main method to demonstrate the Toll Road and Vehicle classes.
     *
     * Expected output:
     *
     * Vehicle Tolls By Description:
     * Description: CCO123ABC, Toll Count: 2
     * Description: CIA432LMN, Toll Count: 3
     * Description: SFL456DEF, Toll Count: 2
     * Description: TCO789XYZ, Toll Count: 4
     * Description: TIA765QRS, Toll Count: 1
     *
     * Vehicle Tolls By State:
     * Description: CCO123ABC, Toll Count: 2
     * Description: TCO789XYZ, Toll Count: 4
     * Description: SFL456DEF, Toll Count: 2
     * Description: CIA432LMN, Toll Count: 3
     * Description: TIA765QRS, Toll Count: 1
     *
     * @param args Command line arguments; ignored in this application.
     */
    public static void main(String[] args) {
        // Create the TollRoad, add some test data, and show the results.
        TollRoad tollRoad = new TollRoad();
        tollRoad.addToll("CCO123ABC");
        tollRoad.addToll("CIA432LMN");
        tollRoad.addToll("TCO789XYZ");
        tollRoad.addToll("SFL456DEF");
        tollRoad.addToll("TCO789XYZ");
        tollRoad.addToll("CIA432LMN");
        tollRoad.addToll("TCO789XYZ");
        tollRoad.addToll("TIA765QRS");
        tollRoad.addToll("CCO123ABC");
        tollRoad.addToll("SFL456DEF");
        tollRoad.addToll("CIA432LMN");
        tollRoad.addToll("TCO789XYZ");

        System.out.println("Vehicle Tolls By Description:");
        System.out.println(tollRoad.getVehicleReportByDescription());

        System.out.println("Vehicle Tolls By State:");
        System.out.println(tollRoad.getVehicleReportByState());
    }
}
