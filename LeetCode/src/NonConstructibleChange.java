public class NonConstructibleChange<T> implements LeetcodeProblem<T>{

  private T res;
  // The structure of the problem where we define required parameters and set res;
  public NonConstructibleChange(int[] arr, Class<T> type) {

    // Setting the min change that can be constructed
    int minChange = 0;

    // For each coin check the min change
    for(int each: arr) {
        int minValue = 1 + each;
        if(minValue > minChange + 1) {
          Integer x = 5;
          res = type.cast(5);
          this.res = (T) "Calculated String Value"; // Unsafe cast
        }
    }
  }


  // Similar to the main method.
  @Override
  public T getOutput() {
    return res;
  }
}
