import java.util.ArrayList;
import java.util.Scanner;
class Train {
 String trainName;
 String trainTime;
 int passengerStrength;
 int trainNumber;
 Train(String trainName, String trainTime, int passengerStrength, int trainNumber) {
 this.trainName = trainName;
 this.trainTime = trainTime;
 this.passengerStrength = passengerStrength;
 this.trainNumber = trainNumber;}
 public String toString() {
 return "Train Name: " + trainName + ", Time: " + trainTime + ", Train Number: " + trainNumber
+ ", Seats: " + passengerStrength;}}
class ReservationSystem {
 ArrayList<Train> availableTrains = new ArrayList<>();
 ArrayList<Train> bookedSeats = new ArrayList<>();
 public ReservationSystem() {
 availableTrains.add(new Train("Kolkata-Delhi", "09:00", 50, 1001));
 availableTrains.add(new Train("Mumbai-Kolkata", "12:00", 60, 1002));
 availableTrains.add(new Train("Delhi-Kolkata", "15:00", 55, 1003));
 availableTrains.add(new Train("Kolkata-Mumbai", "18:00", 40, 1004));
 availableTrains.add(new Train("Delhi-Bangalore", "21:00", 65, 1005)); }
 public void displayTrains() {
 System.out.println("Available Trains:");
 for (Train train : availableTrains) {
 System.out.println(train);}}
 public void checkSeatAvailability(int trainNumber) {
 for (Train train : availableTrains) {
 if (train.trainNumber == trainNumber) {
 System.out.println("Seats available in " + train.trainName + ": " + train.passengerStrength);
 return; } }
 System.out.println("Train not found."); }
 public void bookTicket(String passengerName, int trainNumber) {
 for (Train train : availableTrains) {
 if (train.trainNumber == trainNumber) {
 if (train.passengerStrength > 0) {
 train.passengerStrength--;
 bookedSeats.add(train);
 System.out.println("Booking confirmed for " + passengerName + " on train " +
train.trainName);
 return;
 } else {
 System.out.println("Sorry, train is fully booked.");
 return; }}}
 System.out.println("Train not found."); }
 public void cancelTicket(String passengerName, int trainNumber) {
 for (Train train : bookedSeats) {
 if (train.trainNumber == trainNumber) {
 bookedSeats.remove(train);
50 | C S E - B ( 1 4 0 )
 train.passengerStrength++;
 System.out.println("Ticket for " + passengerName + " canceled on train " + train.trainName);
 return; }}
 System.out.println("No booking found for " + passengerName); }
 public void displayBookedTickets() {
 if (bookedSeats.isEmpty()) {
 System.out.println("No tickets booked.");
 } else {
 System.out.println("Booked Tickets:");
 for (Train train : bookedSeats) {
 System.out.println(train);}}}}
public class RailwayReservationSystem {
 public static void main(String[] args) {
 ReservationSystem system = new ReservationSystem();
 Scanner scanner = new Scanner(System.in);
 int option;
 do {
 System.out.println("\nRailway Reservation System:");
 System.out.println("1. Display Available Trains");
 System.out.println("2. Check Seat Availability");
 System.out.println("3. Book a Ticket");
 System.out.println("4. Cancel a Ticket");
 System.out.println("5. Display Booked Tickets");
 System.out.println("6. Exit");
 System.out.print("Choose an option: ");
 option = scanner.nextInt();
 switch (option) {
 case 1:
 system.displayTrains(); break;
 case 2:
 System.out.print("Enter Train Number: ");
 int trainNumber = scanner.nextInt();
 system.checkSeatAvailability(trainNumber); break;
 case 3:
 System.out.print("Enter Train Number: ");
 trainNumber = scanner.nextInt();
 System.out.print("Enter Passenger Name: ");
 String name = scanner.next();
 system.bookTicket(name, trainNumber);
 break;
 case 4:
 System.out.print("Enter Train Number: ");
 trainNumber = scanner.nextInt();
 System.out.print("Enter Passenger Name: ");
 name = scanner.next();
 system.cancelTicket(name, trainNumber);
 break;
 case 5:
 system.displayBookedTickets();break;
 case 6:
 System.out.println("Exiting the system.");
 break;
 default:
 System.out.println("Invalid option. Please try again."); }
 } while (option != 6);}}