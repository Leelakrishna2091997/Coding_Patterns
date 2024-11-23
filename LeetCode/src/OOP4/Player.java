package OOP4;

public class Player {
  String name = "No-name";
  int age = 0;
  int endurance = 0;

  // Constructor has the same name as the class name and helps to create the object of the
  // class.
  public Player() {
    System.out.println("Am being called");
  }

  // f1
  public Player(String name) {
    System.out.println("Am being called");
  }


  // f2
  public Player(int age) {
    this.age = age;
  }

  public Player(int age, String name) {
    this.age = age;
    this.name = name;
  }

}
