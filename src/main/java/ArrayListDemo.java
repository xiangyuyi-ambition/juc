import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-14 13:27
 * //解决方案：
 * 1.使用vector
 * 2.使用Collections.synchronizedList
 * 3.使用CopyOnWriteArrayList
 **/
public class ArrayListDemo {

    public static void main(String[] args) {
        //List<String> arrayList = new ArrayList<>();
        //List<String> arrayList = new Vector<>();
        //List<String> arrayList = Collections.synchronizedList(new ArrayList<>());
        List<String> arrayList = new CopyOnWriteArrayList<>();
        for(int i=0; i<30;i++){
            new Thread(() -> {
                arrayList.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(arrayList);
            },"").start();
        }

    }
}
