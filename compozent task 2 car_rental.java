import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String registrationNumber;
    private String model;
    private boolean available;

    public Car(String registrationNumber, String model) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.available = true;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rent() {
        if (available) {
            available = false;
            System.out.println("Car rented successfully.");
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    public void returnCar() {
        available = true;
        System.out.println("Car returned successfully.");
    }
}

class CarRentalSystem {
    private List<Car> cars;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        initializeCars();
    }

    private void initializeCars() {
        cars.add(new Car("ABC123", "Toyota Corolla"));
        cars.add(new Car("XYZ789", "Honda Civic"));
        // Add more cars as needed
    }

    public void displayAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println("Registration: " + car.getRegistrationNumber() + ", Model: " + car.getModel());
            }
        }
    }

    public void rentCar(String registrationNumber) {
        for (Car car : cars) {
            if (car.getRegistrationNumber().equals(registrationNumber)) {
                car.rent();
                return;
            }
        }
        System.out.println("Car not found with registration number: " + registrationNumber);
    }

    public void returnCar(String registrationNumber) {
        for (Car car : cars) {
            if (car.getRegistrationNumber().equals(registrationNumber)) {
                car.returnCar();
                return;
            }
        }
        System.out.println("Car not found with registration number: " + registrationNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCar Rental System Menu:");
            System.out.println("1. Display Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    rentalSystem.displayAvailableCars();
                    break;
                case 2:
                    System.out.print("Enter the registration number to rent a car: ");
                    String rentRegistrationNumber = scanner.nextLine();
                    rentalSystem.rentCar(rentRegistrationNumber);
                    break;
                case 3:
                    System.out.print("Enter the registration number to return a car: ");
                    String returnRegistrationNumber = scanner.nextLine();
                    rentalSystem.returnCar(returnRegistrationNumber);
                    break;
                case 4:
                    System.out.println("Exiting Car Rental System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
