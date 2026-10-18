import java.util.ArrayList;
import java.util.Scanner;

class Car {
    String carNumber;

    Car(String carNumber) {
        this.carNumber = carNumber;
    }
}

public class Main {

    static final int TOTAL_SLOTS = 10;
    static ArrayList<Car> parkedCars = new ArrayList<>();

    public static void parkCar(String carNumber) {
        if (parkedCars.size() < TOTAL_SLOTS) {
            parkedCars.add(new Car(carNumber));
            System.out.println("Car Parked Successfully!");
        } else {
            System.out.println("Parking Full!");
        }
    }

    public static void removeCar(String carNumber) {
        boolean found = false;

        for (int i = 0; i < parkedCars.size(); i++) {
            if (parkedCars.get(i).carNumber.equalsIgnoreCase(carNumber)) {
                parkedCars.remove(i);
                found = true;
                System.out.println("Car Removed Successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Car Not Found!");
        }
    }

    public static void displayCars() {
        if (parkedCars.isEmpty()) {
            System.out.println("No Cars Parked.");
        } else {
            System.out.println("\nParked Cars:");
            for (Car car : parkedCars) {
                System.out.println(car.carNumber);
            }
        }
    }

    public static void availableSlots() {
        System.out.println("Available Slots: " + (TOTAL_SLOTS - parkedCars.size()));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== CAR PARKING MANAGEMENT SYSTEM =====");
            System.out.println("1. Park Car");
            System.out.println("2. Remove Car");
            System.out.println("3. Display Parked Cars");
            System.out.println("4. Check Available Slots");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Car Number: ");
                    String carNo = sc.nextLine();
                    parkCar(carNo);
                    break;

                case 2:
                    System.out.print("Enter Car Number to Remove: ");
                    String removeNo = sc.nextLine();
                    removeCar(removeNo);
                    break;

                case 3:
                    displayCars();
                    break;

                case 4:
                    availableSlots();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}