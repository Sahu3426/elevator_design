public class ElevatorHandler {
    public static void goToFloor(Elevator elevator, int floorNumber){
            if(elevator.currentFloor > floorNumber){
                elevator.queueDown.add(floorNumber);
                System.out.println("Req floor : " + floorNumber);
            } else {
                elevator.queueUp.add(floorNumber);
                System.out.println("Req floor : " + floorNumber);
            }
    }
}
