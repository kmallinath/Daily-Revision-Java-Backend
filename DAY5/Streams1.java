import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Streams1
{


    public static void main(String[] args) {

        // Streams

        String s = "I am aa aa  the string you you are usinggggggggggggggggggggg to to learn streams in javaaaaaaaaaaaaaaaa";

        String s1 = Arrays.stream(s.split(" ")).min(Comparator.comparingInt(String::length)).get();
        System.out.println(s1);

        //return after removing duplicates and send in same order

        String ans = Arrays.stream(s.split(" ")).distinct().map(x -> x + " ").collect(Collectors.joining()).trim();

        System.out.println(ans);

        //2nd Higesht Length

        List<String> ans1 = Arrays.stream(s.split(" ")).sorted((a, b) -> a.length() - b.length()).collect(Collectors.toList());

        String ans2 = Arrays.stream(s.split(" ")).sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst().get();

        System.out.println(ans1.get(ans1.size() - 2));

        System.out.println(ans2);

        //Collecting each occurence of word

        Map<String, Long> ans4 = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        System.out.println(ans4);

        //Collecting occurence of each letter

        Map<Character, Long> ans5 = s.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x -> (char) x, Collectors.counting()));
        System.out.println(ans5);

        // Print words only with two vowels
        String s2= "I am learning streams api in java";

        List<String> ans6= Arrays.stream(s2.split(" ")).filter(x->countVowels(x)).collect(Collectors.toList());;
        System.out.println(ans6);
    }

    private static boolean countVowels(String x) {

        Long count=x.chars().mapToObj(y->(char)y).filter(z->"aeiou".contains(z.toString())).count();

        if(count==2) return true;
        return false;
    }

}