public interface ElevatorMovement {
    public void startMovingUp(Elevator elevator);
    public void startMovingDown(Elevator elevator);
    public boolean startApproachingFloor(Elevator elevator, int floor);
}
