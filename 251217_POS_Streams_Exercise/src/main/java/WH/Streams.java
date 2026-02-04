package WH;

import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    //Given a list of integers, return a list of those numbers, omitting any that are between 13 and 19 inclusive.
    public List<Integer> noTeen(List<Integer> nums) {
        return nums.stream()
                   .filter(n -> n < 13 || n > 19)
                   .collect(Collectors.toList());
    }

    //Given a list of strings, return a list where each string has "*" added at its end.
    public List<String> addStar(List<String> strings) {
        return strings.stream()
                      .map(s -> s + "*")
                      .collect(Collectors.toList());
    }

    public List<Integer> dev2(List<Integer> ints) {
        return ints.stream()
                .map(s -> s * 2)
                .collect(Collectors.toList());
    }

    //Given a list of integers, return an integer list of the rightmost digits.
    public List<Integer> rightmost(List<Integer> nums) {
        return nums.stream()
                .map(n -> n % 10)
                .collect(Collectors.toList());
    }

    //Given a list of non-negative integers, return a list of those numbers multiplied by 2,
    //omitting any of the resulting numbers that end in 2.
    public class No2 {
        public static List<Integer> no2(List<Integer> nums) {
            return nums.stream()
                    .map(n -> n * 2)
                    .filter(n -> n % 10 != 2)
                    .toList();
        }
    }

    //Given a list of integers, return a list where each integer is multiplied by 2.
    public List<Integer> doubling(List<Integer> nums) {
        return nums.stream()
                   .map(n -> n * 2)
                   .collect(Collectors.toList());
    }

    //Given a list of strings, return a list where each string has all its "x" removed.
    public List<String> noX(List<String> strings) {
        return strings.stream()
                      .map(s -> s.replace("x", ""))
                      .collect(Collectors.toList());
    }

    //Given a list of strings, return a list of the strings, omitting any string that contains a "Z".
    public List<String> noZ(List<String> strings) {
        return strings.stream()
                      .filter(s -> !s.contains("Z"))
                      .collect(Collectors.toList());
    }

    //Given a list of strings, return a list where each string has "y" added at its end,
    //omitting any resulting strings that contain "y" as a substring anywhere.
    public List<String> noYY(List<String> strings) {
        return strings.stream()
                      .filter(s -> !s.contains("y"))
                      .map(s -> s + "y")
                      .collect(Collectors.toList());
    }

    //Given a list of non-negative integers, return a list of those numbers except omitting any that end with 9.
    public List<Integer> nonnegatives(List<Integer> non) {
        return non.stream()
                   .filter(n -> n % 10 != 9)
                   .collect(Collectors.toList());
    }

    //Given a list of integers, return a list where each integer is added to 1 and the result is multiplied by 10.
    public List<Integer> math1(List<Integer> nums) {
        return nums.stream()
                   .map(n -> (n + 1) * 10)
                   .collect(Collectors.toList());
    }

    static void main() {
        System.out.println("Streams");
    }
}
