import java.util.PriorityQueue;

public class Elevator {
    private static Elevator elevator1;

    int currentFloor;
    int startFloor;
    int endFloor;
    int targetFloor;
    Direction direction;
    PriorityQueue<Integer> queueUp;
    PriorityQueue<Integer> queueDown;

    private Elevator(){
        this.currentFloor = 0;
        this.startFloor = 0;
        this.endFloor = 10;
        this.targetFloor = 0;
        this.direction = Direction.STOP;
        this.queueUp = new PriorityQueue<>((a,b) ->(b-a));
        this.queueDown = new PriorityQueue<>();
    }

    public synchronized static Elevator getElevator(){
        if(elevator1 == null){
            return new Elevator();
        }
        return elevator1;
    }
}
