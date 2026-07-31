import java.util.*;
public class TwoSum {
    public static void main(String[]args){
        int target =26;
        int[] array = {2,7,11,15};
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<array.length;i++){
           int complement = target-array[i];
           if(map.containsKey(complement)){
               System.out.println("["+map.get(complement)+","+i+"]");
               return;
           }
           map.put(array[i],i);
       }
    }
}
