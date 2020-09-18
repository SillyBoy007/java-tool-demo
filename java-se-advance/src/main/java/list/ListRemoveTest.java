package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author wxy
 * @since 2020-09-18
 */
public class ListRemoveTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);

//        System.out.println(list.remove(2));
        System.out.println(list.size());

//        list.forEach(item->{
//            if (Objects.equals(item, 2)){
//                System.out.println(list.remove(2));
//
//            }
//
//        });
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            Integer next = iterator.next();

            if (Objects.equals(next,2)) {
                iterator.remove();
            }
        }

        System.out.println(list.size());
    }
}
