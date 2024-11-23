//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.*;
//import java.util.Stack;
//
//public class leet {
//  private static void q(String key) {
//    System.out.println(key);
//  }
//
//  public static long calculateMaximumProfit(int cost_per_cut, int metal_price, int[] lengths) {
//
//    long maxProfit = 0;
//    long curProfit = 0;
//    int maxLength = 0;
//    Arrays.sort(lengths);
//    for (int curLength : lengths) {
//      maxLength = Math.max(maxLength, curLength);
//    }
//
//
//    for (int curLength = 1; curLength <=maxLength; curLength++) {
//
//      int prevSum=0;
//      for (int length : lengths) {
//        int cut = 0;
//        int waste = 0;
//        if(length%curLength==0){
//          cut=(length/curLength)-1;
//        }else{
//          cut=length/curLength;
//        }
//        waste=length%curLength;
//        int profit=Math.max(prevSum,prevSum+(length*metal_price-cut*cost_per_cut-waste*metal_price));
////        System.out.println(curLength+" "+);
//        prevSum=profit;
//      }
//
//      curProfit=prevSum;
//
//      maxProfit = Math.max(maxProfit, curProfit);
//    }
//
//    return maxProfit;
//  }
//
//  private static List<String> sortedOrder(List<String> words, String order) {
//    Collections.sort(words, (a, b) -> {
//      int i = 0,j = 0, n = a.length(), m = b.length();
//      while(i< n && j < m) {
//        if(a.charAt(i) == b.charAt(j)) {
//            i+=1;
//            j+=1;
//        } else {
//          int c1 = order.indexOf(a.charAt(i));
//          int c2 = order.indexOf(b.charAt(j));
//          return c1 - c2;
//        }
//      }
//      if(i == n && j == m) {
//        return 0;
//      } else if(i == n) {
//        return -1;
//      } else {
//        return 1;
//      }
//    });
//    return words;
//  }
//  private static int maxLengthString(String text, String regex) {
//    String[] reg = regex.split("\\*");
//    StringBuilder pre = new StringBuilder(reg[0]);
//    StringBuilder post = new StringBuilder(reg[1]);
//    StringBuilder t = new StringBuilder(text);
//    int stIndex = t.indexOf(reg[0]);
//    if(stIndex < 0) return -1;
//    post.reverse();
//    t.reverse();
//    int endIndex = t.indexOf(post.toString());
//    if(endIndex < 0) return -1;
//    endIndex = (text.length() - endIndex -1);
//    if(! (endIndex >= stIndex + pre.length())) return -1;
//    return endIndex - stIndex +1;
//  }
//  private static int getTop(String input) {
//    Stack<Integer> sk = new Stack<>();
//    String[] items = input.split(" ");
//    for(String eachString: items) {
//      if(eachString.equals("DUP")) {
//        if(sk.size() == 0) {
//          return -1;
//        } else {
//          int top = sk.peek();
//          sk.push(top);
//        }
//      } else if(eachString.equals("POP")) {
//        if(sk.size() == 0) {
//          return -1;
//        } else {
//          sk.pop();
//        }
//      } else if(eachString.equals("+")) {
//        if(sk.size() <= 1) {
//          return -1;
//        } else {
//          int t1 = sk.pop();
//          int t2 = sk.pop();
//          int res = t1 + t2;
//          if(res > 1048575) return -1;
//          sk.push(res);
//        }
//      } else if(eachString.equals("-")) {
//        if(sk.size() <= 1) {
//          return -1;
//        } else {
//          int t1 = sk.pop();
//          int t2 = sk.pop();
//          if(t1 - t2 < 0) return -1;
//          sk.push(t1-t2);
//        }
//      } else {
//        sk.push(Integer.parseInt(eachString));
//      }
//    }
//    return sk.pop();
//  }
//
//  private static int countPairs(int[] projects, int target) {
//    Map<Integer, Boolean> hm = new HashMap<>();
//    int res = 0;
//    for(int i: projects) {
//      hm.put(i, true);
//    }
//    for(int i: projects) {
//      if(hm.containsKey(target + i)) {
//        res +=1;
//      }
//    }
//    return res;
//
//  }
//
//  static int[][] grid;
//  private static void dfs(int row) {
//    int col = 0;
//    while( col < grid[0].length) {
//
//      if(grid[row][col] == 1) {
//        grid[row][col] = -1;
//        dfs(col);
//      }
//      col +=1;
//    }
//    return;
//  }
//  private static int noOfRelations() {
//    int r = 0, c = 0, res = 0;
//    while( r < grid.length) {
//      c = 0;
//      while( c < grid[0].length) {
//        if(grid[r][c] == 1) {
//          dfs(r);
//          res +=1;
//        }
//        c+=1;
//      }
//      r+=1;
//    }
//    return res;
//  }
//
//  private static int bisectLeft(List<Integer> nums, int item, int s, int e) {
//    if(s == e) return nums.get(s);
//    if(s == e-1) {
//      if(nums.get(e) <= item) {
//        return 1;
//      }
//    }
//    return 1;
//  }
//
////  private static int bisectRight(List<Integer> nums, int item, int s, int e) {
////
////  }
////  private static int minDistance(List<Integer> doors, List<Integer> cams) {
////
////  }
//
//  private static int maxShipments(int[] nums) {
//    int ws = -1, we = -1, wmax = Integer.MIN_VALUE;
//    int res = 0;
//    for(int i = 0; i < nums.length; i++) {
//      // window doesn't exist
//      if(ws == -1) {
//        ws = i;
//        we = i;
//        wmax = nums[i];
//      }
//      // window exists
//      else {
//        if(nums[i] >= wmax) {
//          we = i;
//          wmax = nums[i];
//        } else {
//          res += 1;
//          wmax = Integer.MIN_VALUE;
//          ws = -1;
//          we = -1;
//        }
//      }
//    }
//    return res;
//  }
//
//  // A class is a group of members who can be a data item, function, class.
//  private static class Node {
//    // The data value that am storing
//    int data = 900;
//    // This is the address of the next node.
//    Node next;
//
//    private void display2() {
//      System.out.println("How are you");
//    }
//
//    // A new function
//    private void display() {
//      System.out.println("Hello its me");
//    }
//
//    // Its a function
//    public Node(int data, Node next) {
//      this.data = data;
//      this.next = next;
//    }
//
//  }
////  public static void main(String[] args) {
//////      q("hello");
//////      int[] rods= {26, 103, 59};
////////      rods =
//////      System.out.println(calculateMaximumProfit(1, 10, rods));
//////      List<String> words = new ArrayList<>(Arrays.asList("fd", "fbk", "mc"));
//////      List<List<Integer>> inputArray = new ArrayList<>();
//////    inputArray.add(new ArrayList<>(Arrays.asList(1,1,1,1)));
//////    inputArray.add(new ArrayList<>(Arrays.asList(1,1,1,1)));
//////    inputArray.add(new ArrayList<>(Arrays.asList(1,1,1,1)));
//////      grid = new int[5][5];
//////      grid[0] = new int[]{1, 0, 0, 0, 0};
//////      grid[1] = new int[]{0, 1, 0, 0, 0};
//////      grid[2] = new int[]{0, 0, 1, 0, 0};
//////      grid[3] = new int[]{0, 0, 0, 1, 0};
//////      grid[4] = new int[]{0, 0, 0, 0, 1};
//////      grid[0] = new int[]{0, 0, 1, 0};
//////      grid[0] = new int[]{0, 0, 0, 1};
//////      System.out.println(noOfRelations()+" bye ");
//////    System.out.println(getTop("4 5 6 - 7 +"));
//////    System.out.println(getTop("13 DUP 4 POP 5 DUP + DUP + -"));
//////    System.out.println(getTop("5 6 + -"));
//////    System.out.println(getTop("3 DUP 5 - -"));
//////    System.out.println(getTop("1048575 DUP +"));
//////      int[] rods= {8,5,4,7,2};
//////
//////
//////      int a = 5;
//////
//////      // 1000 : {5}
//////
//////
//////      int b = 100;
//////
////////      2501 = {100}
//////
//////      char character = 'b';
//////
////////      Data Types
////////      int, float, char, double, char
//////
//////
////////    Take Aways
////////    1) Data Types - int = long; float = double
////////    2) Characters can't store string values i.e ""
////////    3) House address references to the cells -> memory address
//////
////////    Day 1
//////      int[] arr = new int[2];
//////
//////      // 6000, 6001
//////
////////    Day 2 - 6000, 6001, 6002
//////
//////      arr = new int[3];
//////
//////      // 7000, 7001, 7002
//////
////////    Take Aways
////////    4) Arrays will expect a initializer count - size of the array
////////    5) Arrays will have continuous memory spaces allocated
//////
////////    5, 5000, 4000, 6000
//////
//////    int floorSpace = Integer.MIN_VALUE;
//////    int[] nums = new int[]{6, 90, 200, 85, 102};
//////
//////    // Taking each number from the bucket
//////    for(int eachNumber: nums) {
////////      System.out.println(eachNumber);
////////      if floorSpace is bigger eachNumber then don't replace
//////      if(floorSpace > eachNumber) {
//////        continue;
//////      }
////////      else if eachNumber is bigger than floorSpace then replace
//////      else if(floorSpace < eachNumber){
//////        floorSpace = eachNumber;
//////      }
//////
//////    }
//////    System.out.println(floorSpace);
//////
////
//////    Take Aways
//////    6) Continue to skip to the next iteration
//////    7) Can't alter the array size dynamically
//////    8) Min and Max problem
////
//////      System.out.println(maxShipments( rods));
////
//////    (Primitives) and (Wrapper Classes or Collections)
////    int x = 100;
////    System.out.println(x);
////
////    int[] xarr = {789, 90, 102};
////
////    // 5000, 5001, 5002
//////    5000 + 1
////    System.out.println(xarr[1]);
////
////
////
//////    Node head;
//////
////////    insert 19
////
////    Node firstItem = new Node(19, null);
////
////    Node secondItem = new Node(20, null);
////
////    //    firstItem is the object
////    //    secondItem is the object
////
//////    firstItem.data = 5;
//////    secondItem.display();
////
//////    System.out.println(secondItem.data);
////
//////
//////
//////    System.out.println(firstItem.data);
//////////    head = firstItem;
////////    System.out.println(firstItem);
////////
////////    // insert 10
//////    Node secondItem = new Node(10, null);
////////
//////////    10 -> 19
//////////    secondItem.next = firstItem;
//////    firstItem.next = secondItem; // 5432
////
////    // This is linking part
//////    head.next = newNodeItem; // 5432 address;
////
////
//////    String str = "apple";
////
//////    int[] nums = new int[]{1, 2, 3};
//////    System.out.println("hello" + nums);
////
//////    System.out.println("bye" + nums[0]);
//////    System.out.println(str.charAt(5));
//////    System.out.println(str.length());
////
////
////    Stack<Integer> sk = new Stack<>();
////    sk.push(10);
////    sk.push(20);
////    System.out.println("stack size "+sk.size());
////
////    int removedItem = sk.pop();
////    sk.pop();
////    System.out.println("Removed "+removedItem);
////    System.out.println("stack size "+sk.size());
////    if(sk.size() > 0) {
////      System.out.println("stack top is " + sk.peek());
////    }
////  }
//  private static int sum(int a, int b) {
//    int cal = 0;
//    cal = a + b;
//    return cal;
//  }
//  //  input params: a, b
//  //  out params:  integer cal
//  //
//  private int getListLength(Node head) {
//      Node temp = head;
//      int count = 0;
//
//      // Hopping till i get the null value;
//      while(temp != null) {
//        temp = temp.next;
//        count = count + 1;
//        count ++;
//        count += 1;
//      }
//
//      return count;
//  }
//
//
//  //  function name: getListLength
//  //  input params: head Node
//  //  out params:  count integer
//  //  407: 416
//
//  private static int lamps(int[][] lampsArr) {
//
//    int[][] light = new int[3][lampsArr.length];
//
//
//    int i = 0, n = lampsArr.length;
//
//    // Map of Integer, Integer
//    Map<Integer, Integer> hm = new HashMap<>();
//
//    // for each lamp fill the pos
//    for(int[] eachLamp: lampsArr) {
//
//      // index to identify the value
//      light[i][0] = i;
//
//      // start of light
//      light[i][1] = eachLamp[0] - eachLamp[1];
//
//      // ending of light
//      light[i][2] = eachLamp[0] + eachLamp[1];
//
//      i+=1;
//    }
//
//    int[][] startLight = light.clone();
//    int[][] endLight = light.clone();
//
//    int[] lampsOverlapArr = new int[n];
//
//
//
//
//    // Sort the lights with starting position
//    Arrays.sort(startLight, (a,b) -> (a[1] - b[1]));
//
//    Arrays.sort(endLight, (a,b) -> (a[2] - b[2]));
//
//    i = 0;
//
//    // traverse each light rightmost coordinate and check which is the right most and left most intersecting lamps
//    for(int[] eachStartLight: startLight) {
//
//      int index = eachStartLight[0], value = 0;
//
//      // Get rightMost index for the current lamp
//      value += getRightMostIndex(eachStartLight[2]) - i;
//
//      lampsOverlapArr[index] += value;
//
//      i+=1;
//    }
//
//    // traverse each light rightmost coordinate and check which is the right most and left most intersecting lamps
//    for(int[] eachEndLight: endLight) {
//
//      int index = eachEndLight[0], value = 0;
//
//      // Get leftMost index for the current lamp
//      value += i - getLeftMostIndex(eachStartLight[1]);
//
//      lampsOverlapArr[index] += value;
//
//      i+=1;
//    }
//
//
//
//    return 1;
//  }
//  public static void main(String[] args) {
//    int[][] larr= {{-2,3}, {2,3}, {2,1}};
//    System.out.println(lamps(larr));
//    // Defining the output type of the problem when executing and also pass the required params.
////    LeetcodeProblem pb1 = new NonConstructibleChange<String>(new int[]{2,3}, String.class);
////    System.out.println(pb1.getOutput().toString());
//  }
//  }