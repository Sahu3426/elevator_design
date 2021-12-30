public class ElevatorMain {
    public static void main(String[] args){
        Elevator e = Elevator.getElevator();
        ElevatorImpl impl = new ElevatorImpl();
        new Thread(impl).start();

        System.out.println("Welcome to Lift.");
        ElevatorHandler.goToFloor(e, 4);
        ElevatorHandler.goToFloor(e, 1);
        ElevatorHandler.goToFloor(e, 8);
        ElevatorHandler.goToFloor(e, 5);
        ElevatorHandler.goToFloor(e, 9);
    }
}
