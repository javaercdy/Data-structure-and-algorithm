package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author chenDY
 * @create 2022-04-06-11:17
 */
public class Greedy {


    public static void main(String[] args) {

        //需求:选出覆盖全部城市的电台集合

        //准备: set存放,待覆盖的城市, arrayList存放广播key
        //hashmap 存放,广播key和覆盖城市--存放广播对象

        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        HashSet<String> areas = new HashSet<>();

        areas.add("北京");
        areas.add("上海");
        areas.add("天津");
        areas.add("广州");
        areas.add("深圳");
        areas.add("成都");
        areas.add("杭州");
        areas.add("大连");

        HashSet<String> k1 = new HashSet<>();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");

        HashSet<String> k2 = new HashSet<>();
        k2.add("广州");
        k2.add("北京");
        k2.add("深圳");

        HashSet<String> k3 = new HashSet<>();
        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");
        HashSet<String> k4 = new HashSet<>();
        k4.add("上海");
        k4.add("天津");
        HashSet<String> k5 = new HashSet<>();
        k5.add("杭州");
        k5.add("大连");

        broadcasts.put("1",k1);
        broadcasts.put("2",k2);
        broadcasts.put("3",k3);
        broadcasts.put("4",k4);
        broadcasts.put("5",k5);

        ArrayList<String> greedy = greedy(broadcasts, areas);
        for (String s : greedy) {
            System.out.print(s+",");
        }
        


    }

    public static ArrayList<String> greedy(HashMap<String,HashSet<String>> broadcasts,HashSet<String> allAreas){
        ArrayList<String> selects = new ArrayList<>();

        while(allAreas.size()>0){
            String maxKey=null;
            int maxTemp=0;
            for (String key:broadcasts.keySet()){

                //当前key的剩余覆盖城市
                HashSet<String> cities = broadcasts.get(key);
                cities.retainAll(allAreas);

                if (maxKey==null||cities.size()> maxTemp){
                    maxKey=key;
                    maxTemp= cities.size();
                }
            }

            if (maxKey!=null){
                HashSet<String> cities = broadcasts.get(maxKey);
                cities.retainAll(allAreas);
                allAreas.removeAll(cities);
                selects.add(maxKey);
                broadcasts.remove(maxKey);
            }
        }
        return selects;
    }






















    public static ArrayList<String> greedy2(HashMap<String, HashSet<String>> broadcasts, HashSet<String> allAreas){
        ArrayList<String> selects = new ArrayList<>();
        String maxKey;
        int maxTemp;
        HashSet<String> tempSet = new HashSet<>();
        while(allAreas.size() != 0){
            maxKey = null;
            maxTemp = 0;
            for(String key : broadcasts.keySet()){
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > maxTemp)){
                    maxKey = key;
                    maxTemp = tempSet.size();
                }
            }
            if(maxKey != null){
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
                broadcasts.remove(maxKey);
            }
        }
        return selects;
    }
}
