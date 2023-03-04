import java.util.*;
import java.lang.*;
public class Main {
    static Scanner s = new Scanner(System.in);
    static String time;
    public static void main(String[] args) {
       Map<String,Double> m = new HashMap<>();// using hash map

       for(int i = 0 ; i < 13 ;i++) // inserting the name in the first and the days in the second
       {
           time = "";
           String name = Getname();
           m.put(name,convert(time));
       }
        List<Map.Entry<String, Double>> nlist = new ArrayList<>(m.entrySet());// copy the map to an array list
        nlist.sort(Map.Entry.comparingByValue());// sorting the array list
        System.out.println("the names after sorting");
        nlist.forEach(System.out::println);// printing
    }
    static String Getname()
    {
        String name = "";
        String  in = s.nextLine();
        boolean flag = true;
        for(int i = 0 ;i  < in.length();i++)
        {
            if(in.charAt(i)=='-'){flag = false; continue;};
            if(flag)name+=in.charAt(i);
            else if(in.charAt(i)!=' ') time += in.charAt(i);
        }
        return name;
    }
    static double convert(String t)// to convert the time to the number of days
    {
        double d=0;
        if(t.substring(0,3) == "Jan")d+=31;
        else if(t.substring(0,3) == "Feb")d+=31;
        else if(t.substring(0,3) == "Mar")d+=31+28;
        else if(t.substring(0,3) == "Apr")d+=31+28+31;
        else if(t.substring(0,3) == "May")d+=31+28+31+30;
        else if(t.substring(0,3) == "Jun")d+=31+28+31+30+31;
        else if(t.substring(0,3) == "Jul")d+=31+28+31+30+31+30;
        else if(t.substring(0,3) == "Aug")d+=31+28+31+30+31+30+31;
        else if(t.substring(0,3) == "Sep")d+=31+28+31+30+31+30+31+30;
        else if(t.substring(0,3) == "Oct")d+=31+28+31+30+31+30+31+30+31;
        else if(t.substring(0,3) == "Nov")d+=31+28+31+30+31+30+31+30+31+30;
        else if(t.substring(0,3) == "Dec")d+=31+28+31+30+31+30+31+30+31+30+31;
        int temp = Integer.parseInt(t.substring(3,5));
        d+= temp;
        temp = Integer.parseInt(t.substring(6,10));
        d+= temp*365;
        int temp2;
        if(t.charAt(12)!=':')
        {
            temp = Integer.parseInt(t.substring(11,13));
            temp2 = Integer.parseInt(t.substring(14,16));
        }
        else
        {
            temp = Integer.parseInt(t.substring(11,12));
            temp2 = Integer.parseInt(t.substring(13,15));
        }
        if(t.charAt(t.length()-2)=='P')temp+=12;
        d+=temp/24.0;
        d+=temp2/(24.0*60.0);
        return d;
    }
}