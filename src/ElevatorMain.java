public class ElevatorMain {
    public static void main(String[] args){
        ElevatorImpl impl = new ElevatorImpl();
        new Thread(impl).start();

        System.out.println("Welcome to Lift.");

        Elevator elevator = Elevator.getElevator();
        System.out.println(elevator.direction + " " + elevator.queueUp +  " " + elevator.queueDown + " " + elevator.targetFloor + " " + elevator.currentFloor + " " + elevator.startFloor + " " +elevator.endFloor);
        ElevatorHandler.goToFloor(elevator, 2);
//        ElevatorHandler.goToFloor(elevator, 5);
        ElevatorHandler.goToFloor(elevator, 8);
        System.out.println(elevator.direction + " " + elevator.queueUp +  " " + elevator.queueDown + " " + elevator.targetFloor + " " + elevator.currentFloor + " " + elevator.startFloor + " " +elevator.endFloor);



    }
}
