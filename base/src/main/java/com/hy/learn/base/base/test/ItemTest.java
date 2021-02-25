package com.hy.learn.base.base.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Created by hy
 * @date on 2020/9/24 16:48
 */
public class ItemTest {

    private static List<BaseItem> baseItems = new ArrayList<>();

    public static void main(String[] args) {
        AItem aItem1 = new AItem();
        AItem aItem2 = new AItem();
        AItem aItem3 = new AItem();

        BItem bItem1 = new BItem();
        BItem bItem2 = new BItem();
        BItem bItem3 = new BItem();

        baseItems.add(aItem1);
        baseItems.add(aItem2);
        baseItems.add(aItem3);

        baseItems.add(bItem1);
        baseItems.add(bItem2);
        baseItems.add(bItem3);
        List<AItem> items = baseItems.stream().filter(item -> (item instanceof AItem)).map(item -> ((AItem) item)).collect(Collectors.toList());
        System.out.println(items);

        List<AItem> aItems = filterClass(AItem.class);
        System.out.println(aItems);
    }

    public static  <T extends BaseItem> List<T> filterClass(Class<T> target){
        return baseItems.stream().filter(item -> (target.isInstance(item))).map(item -> ( target.cast(item))).collect(Collectors.toList());
    }

}
