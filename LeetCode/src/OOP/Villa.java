package OOP;

public class Villa implements BluePrint{

  @Override
  public void gardenActivity() {
    System.out.println("Planting small plants.");
  }

  @Override
  public void livingRoomActivity() {
    System.out.println("Playing UNO");
  }

  @Override
  public void bathRoom() {

  }

  public void theatre() {
    System.out.println("Watching movie");
  }
}
