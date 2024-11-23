package OOP;

public class School implements BluePrint{

  @Override
  public void gardenActivity() {
    System.out.println("Planting some big trees.");
  }

  @Override
  public void livingRoomActivity() {
    System.out.println("Its empty, as its a school no living room");
  }

  @Override
  public void bathRoom() {

  }

  public void classRoom() {
    System.out.println("Studying in the class.");

  }
}