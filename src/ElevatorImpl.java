
public class ElevatorImpl implements Runnable, ElevatorMovement{

    public final static Elevator elevator = Elevator.getElevator();

    @Override
    public void startMovingUp(Elevator elevator) {

    }

    @Override
    public void startMovingDown(Elevator elevator) {

    }

    @Override
    public boolean startApproachingFloor(Elevator e, int floor) {
        if((e.currentFloor < floor && e.direction == Direction.UP) ||
                (e.currentFloor > floor && e.direction == Direction.DOWN)){
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        while (true){
            try{
                try{
                    Thread.sleep(5000);
                } catch (Exception e){

                }

                if(elevator.direction == Direction.DOWN && (!elevator.queueDown.isEmpty())){
                        elevator.targetFloor = elevator.queueDown.peek();
                } else if (elevator.direction == Direction.UP && (!elevator.queueUp.isEmpty())){
                    elevator.targetFloor = elevator.queueUp.peek();
                } else {
                    if ((!elevator.queueDown.isEmpty())){
                        elevator.targetFloor = elevator.queueDown.peek();
                    }
                    if ((!elevator.queueUp.isEmpty())){
                        elevator.targetFloor = elevator.queueUp.peek();
                    }
                }

                //Updating the elevator direction
                if(elevator.targetFloor > elevator.currentFloor){
                    elevator.direction = Direction.UP;
                } else if(elevator.targetFloor < elevator.currentFloor){
                    elevator.direction = Direction.DOWN;
                } else{
                    elevator.direction = Direction.STOP;
                }
                System.out.println(elevator.direction + " " + elevator.queueUp +  " " + elevator.queueDown + " " + elevator.targetFloor + " " + elevator.currentFloor + " " + elevator.startFloor + " " + elevator.endFloor);

                if(elevator.queueUp.isEmpty() && elevator.queueDown.isEmpty()){
                    System.out.println("Static lift/ Idle lift");
                } else {
                    if(elevator.currentFloor < elevator.targetFloor){
                        startMovingUp(elevator);
                        elevator.currentFloor++;
                        System.out.println("Going upwards");
                    }
                    if(elevator.currentFloor > elevator.targetFloor){
                        startMovingDown(elevator);
                        elevator.currentFloor--;
                        System.out.println("Going downwards");
                    }
                    if(elevator.currentFloor == elevator.targetFloor){
                        if((!elevator.queueDown.isEmpty()) && elevator.queueDown.peek() == elevator.targetFloor){
                            System.out.println("Reached " + elevator.targetFloor);
                            elevator.queueDown.poll();
                        }
                        if((!elevator.queueUp.isEmpty()) && elevator.queueUp.peek() == elevator.targetFloor){
                            System.out.println("Reached " + elevator.targetFloor);
                            elevator.queueUp.poll();
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
