package OOP3;

import OOP2.V1;

public class RunInheritance {


  public static void main(String[] args) {
    RoboV1 ustat = new RoboV1();
    ustat.dance();
    ustat.sing();

    // INVALID -> Interface implements class -> invalid -> There is no infrastructure to implement a blueprint, and there is no blueprint to provide.
    // INVALID -> class implements class -> valid -> There is infrastructure to implement a blueprint, but you can't give a blueprint out of a class.
    // VALID -> class implements interface -> valid -> There is infrastructure needed to implement a blueprint and the blueprint is also being provided.
    // INVALID -> Interface extends class -> invalid -> There is no infrastructure to store the provided defined(noun) methods.
    // VALID -> class extends class -> valid -> There is infrastructure to store the provided defined methods.
    // INVALID -> class extends interface -> invalid -> There is no implementation of the provided abstract method.
    // VALID -> interface extends interface -> invalid -> We are extending the abstract methods.
    // INVALID -> interface implements interface -> valid -> You can't define an abstract inside an interface cos there is no infrastructure.



// implementation -> You are trying to implement an abstraction i.e tyring to define some thing which is an abstract/ a blueprint.
// extension -> You are trying to extend the existing feature which have already been implemented. -> extends


  }

}
