package com.hy.learn.base.exam;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 得到菜单的树形结构
 * @author Created by hy
 * @date on 2020/7/9 10:11
 */
public class ExamMenu {

    public static void main(String[] args) {

        Menu menu0 = new Menu(0, 0);
        Menu menu1 = new Menu(1, 0);
        Menu menu2 = new Menu(2, 0);
        Menu menu3 = new Menu(3, 1);
        Menu menu4 = new Menu(4, 2);
        Menu menu5 = new Menu(5, 3);

        ArrayList<Menu> menus = Lists.newArrayList(menu0, menu1, menu2, menu3, menu4, menu5);
        Menu menuTree = getMenuTree(menus);
        System.out.println(menuTree);
    }

    public static Menu getMenuTree(List<Menu> menuList) {
        Map<Integer, Menu> map = menuList.stream().collect(Collectors.toMap(Menu::getId, v -> v, (k1, k2) -> k1));
        Menu rootMenu = new Menu();
        for (Menu menu : menuList) {
            if (menu.getId() == 0) {
                rootMenu = menu;
            }else {
                Menu pMenu = map.get(menu.getPid());
                //将子menu添加到父menu的ChildrenList中
                List<Menu> childrenList = pMenu.getChildren();
                if (childrenList != null){
                    childrenList.add(menu);
                    pMenu.setChildren(childrenList);
                }else {
                    pMenu.setChildren(Lists.newArrayList(menu));
                }
            }
        }
        return rootMenu;
    }

}
