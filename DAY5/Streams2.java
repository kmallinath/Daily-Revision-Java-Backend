import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams2 {

    public static  void main(String [] args)
    {
        ArrayList<Integer> al=new ArrayList<Integer>(Arrays.asList(2,2,3,3,4,5,6,7,8,9,10,33,44,11,13,23,66));
        //ascendingorder
        al.stream().sorted().forEach(x->System.out.print(x+ " "));
        //decendeing order
        al.stream().sorted(Comparator.reverseOrder()).forEach((x->System.out.print(x+" ")));


        // sum of elements
        System.out.println();
        int sum= al.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);


        // sum of unique elements

        int sumofUnique=al.stream().distinct().reduce(0, Integer::sum);
        System.out.println(sumofUnique);

        // Find the first non repeated character in java
        String s="abcccbdeeffj";
        Map<Character,Long>map= s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(x->x,LinkedHashMap::new,Collectors.counting()));

        char c=map.entrySet().stream().filter(x->x.getValue()==1).findFirst().get().getKey();
        System.out.println(c);

        //2nd way

        String c2=Arrays.stream(s.split("")).filter(x->s.indexOf(x)==s.lastIndexOf(x)).findFirst().get();
        System.out.println(c2);

        // Find the first  repeated character in java

        String c3=Arrays.stream(s.split("")).filter(x->s.indexOf(x)!=s.lastIndexOf(x)).findFirst().get();
        System.out.println(c3);

        //2nd way

        Map<Character,Long>map2=s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(x->x,Collectors.counting()));
        char ans=map2.entrySet().stream().filter(x->x.getValue()!=1).findFirst().get().getKey();
        System.out.println(ans);


        //Grouping by range

        Map<Integer,List<Integer>>map3= al.stream().collect(Collectors.groupingBy(x->(int)((x/10)*10),LinkedHashMap::new,Collectors.toList()));

        System.out.println(map3);

        //filter integrs in string

        List<String> al2= new ArrayList<>(Arrays.asList("abc","123","43","1"));

        List<Integer>ans2=al2.stream().filter(x->x.matches("[0-9]+")).map(x->Integer.valueOf(x)).toList();
        System.out.println(ans2);

        //find product of 1st two number in java

        int ans4= al.stream().limit(2).reduce(1,(x, y)->(int)(x*y));
        System.out.println(ans4);

        //anagrams

        String[] s2 = {
                "pat",
                "tap",
                "pan",
                "nap",
                "Team",
                "tree",
                "meat"
        };

        List<String> list = Arrays.asList(s2);

        Map<List<String>,List<String>>ans5=list.stream().collect(Collectors.groupingBy(x-> Arrays.stream(x.split("")).sorted().collect(Collectors.toList()),Collectors.toList()));
        System.out.println(ans5);

        //multiply alternative numbers in  java

        int ans6=IntStream.range(0,al.size()).filter(x->x%2==0).map(x->al.get(x)).reduce(1,(x,y)->x*y);
        System.out.println(ans6);

    }
}
