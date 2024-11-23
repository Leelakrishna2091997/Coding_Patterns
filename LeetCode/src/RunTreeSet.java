import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RunTreeSet {

  private static String getString(int[] count) {
    StringBuilder evenCharsHalf = new StringBuilder("");
    StringBuilder oddChars = new StringBuilder("");

    for(int each = 0; each < 26; each ++ ) {

      char ch = (char) (97 + each);
      int counter = count[each];

      // Even then add half to even stringbuilder
      if(counter % 2 == 0) {
        int temp = counter / 2;
        while(temp > 0) {
          evenCharsHalf.append(ch);
          temp -= 1;
        }
      }


      // Even then add half to even stringbuilder
      if(counter % 2 == 1) {
        int temp = counter;
        while(temp > 0) {
          oddChars.append(ch);
          temp -= 1;
        }
      }
    }
    return evenCharsHalf.toString() + oddChars.toString() + evenCharsHalf.reverse().toString();

  }
  private static String getMinPalindrome(String s) {
    // create count arr
    char[] charr = s.toCharArray();
    int[] count = new int[26];

    for(char each: charr) {
      count[each - 97] += 1;
    }

    int left = 0, right = 25;
    // Move left and right, updating the counts accordingly
    while(left < right) {

      // even then continue
      if(count[left] % 2 == 0) {
        left +=1;
        continue;
      }

      // even then continue
      if(count[right] % 2 == 0) {
        right -=1;
        continue;
      }

      // Both are odd then update the counts
      count[left] += 1;
      count[right] -= 1;

    }


    return getString(count);
  }
  private char[][] gravity(char[][] grid) {
    int rows = grid.length, cols = grid[0].length;

    // Traverse each col
    {
      // Traverse from last row to 0 
    }
    return null;

  }

  static class Node {
    Node left;
    Node right;
    int val;
    public Node(int val,Node left,Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }


  private static int bisect_left(List<Integer> nums, int item, int l, int r) {

//    1 2
//    l r

    // Terminal states
    if(l == r) {
      if(nums.get(l) < item) return r + 1;
      return r;
    }
      if(l == r -1) {
        if(nums.get(r) < item ) return r+1;
        else if(nums.get(l) < item && item <= nums.get(r)) return r;
        return l;
      }

    int mid = (l + r) / 2;

    // Recursion
    // mid is greater than item go to left
    if(item <= nums.get(mid)) {
      return bisect_left(nums, item, l, mid);
    }

    return bisect_left(nums, item, mid, r);
  }

  private static int getBeauty(int n, int[] arr, int m, int[][] pairs) {

    // Sort the pairs
    Arrays.sort(pairs, (a,b) -> (a[0] - b[0]));
    List<Integer> nums = new ArrayList<>();
    // lookup for array of nums
    boolean[] visited = new boolean[n];
    int curr = 0, pairIndex = 0;

    // travel through each pair and set look up as visited if done
    while(pairIndex < m) {

      // if curr >= eachPair[0] && curr is < eachPair[1] then curr++ include it
      if(curr >= pairs[pairIndex][0] && curr <= pairs[pairIndex][1]) {
        visited[curr] = true;
        curr+=1;
        continue;
      }

      // if curr is less than eachPair[0]
      else if (curr < pairs[pairIndex][0]) {
        curr = pairs[pairIndex][0];
        continue;
      }

      else {
        // Add all the numbers of pair to nums
//    [1,2,1,2,3,2,3]
//        System.out.println(pairIndex+" "+ nums);

        int addIndex = pairs[pairIndex][0], end = pairs[pairIndex][1];
        while( addIndex <= end ) {
          nums.add(arr[addIndex]);
          addIndex += 1;
        }

        pairIndex+=1;
      }

    }

    System.out.println(Arrays.toString(visited)+" "+ nums);

    // Sort the nums
    Collections.sort(nums);

    int count = 0, index = 0;
    while(index < n) {
      if(!visited[index]) {
        count += bisect_left(nums, arr[index], 0 , nums.size() - 1);
        System.out.println(count);

      }
      index += 1;
    }
    return count;
  }

  private static int getMaxChannel(List<Integer> packets, int channels) {

    // if no channels
    if(channels == 0) return 0;

    Collections.sort(packets);

    // initialize and get sum for c - 1 channels
    int sum = 0, count = channels - 1, r = packets.size() - 1;
    while(count > 0) {
      sum += packets.get(r);
      r-=1;
      count -=1;
    }

    // No of left over packets is odd then get the mid point
    if((r+1) % 2 == 1) return sum + packets.get(r/2);
    else return Math.round(sum + ((float) (packets.get(r/2) + packets.get((r/2) + 1)))/2) ;

  }

  private static void easyIterate(String s) {
    // initialise l and r
    int l = 0, r = 0, n = s.length();

    while (l < n && r < n) {

      // if any points to ? then skip
      if(s.charAt(l) == '?') {l++; continue;}
      if(s.charAt(r) == '?') {r++; continue;}

      // if they are in wrong order
      if(l>=r) {r+=1; continue;}

      // processing l and r
      System.out.println(l+" "+r);
      l+=1;
      r+=1;

    }

  }

  private static int extraOrdinary( String s) {

    // Map
    int[] valueArr = {1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9};

    // cummulative sum creation
    int[] cumm = new int[s.length()];
    int index = 0, n = s.length();
    for(char c: s.toCharArray()) {
      if(index == 0) {
        cumm[index] = valueArr[c-97];
      }
       else {
        cumm[index] = cumm[index-1] + valueArr[c-97];
      }
       index +=1;
    }

    // Get all the substrings and identify count
    int i = 0, j = 0, ans = 0;
    while(i < n) {

      j = i;
      while(j < n) {

        // Gets cumm sum
        int sum = cumm[j] - cumm[i] + valueArr[s.charAt(i) - 97];
        int len = j - i + 1;
        if(sum % len == 0) ans +=1;

        j+=1;
      }
      i+=1;
    }
    return ans;
  }


  private static void playingWithStreams() {

    int[][] arr = {{0,0}, {1,1}, {2,2}, {3,3}};

    //    printing 2d array
    Arrays.stream(arr).forEach(each -> System.out.println(Arrays.toString(each)));

    //    converting 2d array to list of lists
    List<List<Integer>> list = Arrays.stream(arr)
        .map(e ->
            Arrays.stream(e).boxed().collect(Collectors.toList()))
        .collect(Collectors.toList());

    // converting list of lists to 2d array
    int[][] newarr = list.stream()
        .map(e ->
            e.stream().mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);

  }

  // gets the count array for all alphabets
  private static int[] getCountArray(String word) {
      int[] carr = new int[26];

      // traverse each char and inc count
      for(int i = 0; i < word.length() ; i++) {
        carr[word.charAt(i) - 97] += 1;
      }
      return carr;
  }
  private static char[] getChars(String[] words) {

    // global carr for all words
    int[] carr = new int[26];
    List<Character> allChars = new ArrayList<>();

    // traverse all words
    for(String each: words) {

      // get carr for each word
      int[] currentArr = getCountArray(each);

      // traverse and update global carr
      for(int i = 0; i < 26; i++) {
        carr[i] = Math.max(carr[i], currentArr[i]);
      }
    }

    // return list of chars
    for(int i = 0; i < 26; i++) {

      int count = carr[i];

      // all char count times
      while( count > 0) {
        allChars.add((char) ('a'+i));
        count -=1;
      }
    }

    return allChars.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString().toCharArray();



  }

  private static int optimize1(String s) {
    Stack<Integer> sk = new Stack<>();

    int minLength = s.length();
    char start = s.charAt(0);
    char end = s.charAt(s.length() - 1);

    sk.push(0);

    // traverse through each number
    for(int i = 0; i < s.length(); i++ ) {

      // if i matches with start then remove the top
      if(s.charAt(i) == start) {

        // if already present
        if(sk.size() > 0 ) {
          sk.pop();
        }
        sk.push(i);

      }

      // if i matches with end, then update length;
      else if(s.charAt(i) == end) {
        int startIndex = sk.peek();
        minLength = Math.min(minLength, i - startIndex + 1);

      }




    }

    return s.length() - minLength;
  }
  private static int optimize(String s) {

    int n = s.length();

    int minLength = n;

    // if length is 0 or 1 then return 0
    if(n == 0 || n == 1) return 0;

    char start = s.charAt(0);
    char end = s.charAt(n - 1);

    int i = 0, j = 1;

    // traverse till j has reached end
    while(j < n) {

      // if in the mean time found a start then move start
      while(j < n && s.charAt(j) == start) {
        i = j;
        j = j+1;
      }

      // j reached end as all are alike
      if(j >= n) break;

      // found a match
      if(s.charAt(j) == end) {
        minLength = Math.min(j-i+1, minLength);

        // move i till it is valid
        while(i < n && s.charAt(i) != start) {
          i+=1;
          j = i+1;
        }

        // if exceeded
        if(i >= n) break;
      }

      j+=1;
    }

    return minLength == n ? 1: n - minLength;
  }
  public static void main(String[] args) {
//    Node root = new Node(1, null, null);
//
//    Node leftNode = new Node(2, null, null);
//    Node rightNode = new Node(3, null, null);
//    root.left = leftNode;
//    root.right = rightNode;
//
//    System.out.println(root.left.val+" "+leftNode);
//
//    leftNode = null;
//    System.out.println(root.left+" "+
//        leftNode);
//    [1,2,1,2,3,2,3]
//    int[] arr = {1,2,3,4,5};
//    int[][] pairs = {{1,2}, {1,1}, {2,2}, {3,3}, {4,4}};
//    System.out.println(getBeauty(5, arr,5, pairs));
//    List<Integer> lst = new ArrayList<>(Arrays.asList(1,1,2,2));
//    String stringValue = "??0?1?1";
//System.out.println(extraOrdinary("asdf"));
//    playingWithStreams();
    String[] words = {"word", "hwll", "wword"};
    System.out.println(optimize1("aaaaa"));
  }
}
