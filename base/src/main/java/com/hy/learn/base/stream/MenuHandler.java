package com.hy.learn.base.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuHandler {

    public Menu getMenuTree() {
        List<Menu> menuList = generatorMenu();
        //首先将list转成Map，key为菜单ID
        //遍历list，将PID为0的作为根节点，
        Map<Integer, Menu> map = menuList.stream()
                .collect(
                        Collectors.toMap(Menu::getId, v -> v)
                );
        //根节点
        Menu rootMenu = null;
        for (Menu menu : menuList) {
            if (menu.getPid() == 0) {
                rootMenu = menu;
            } else {
                //根据父节ID点找出对应父节点
                Menu pMenu = map.get(menu.getPid());
                //addChildren方法要自己写
                addChildren(pMenu, menu);
            }
        }
        //最后return出，根节点
        return rootMenu;
    }

    private void addChildren(Menu pMenu, Menu menu) {
        pMenu.setChildren(pMenu.getChildren() == null ? new ArrayList<>() : pMenu.getChildren());
        pMenu.getChildren().add(menu);
    }

    private List<Menu> generatorMenu() {
        Menu menu = new Menu();
        menu.setId(1);
        menu.setName("根节点");
        menu.setPid(0);

        Menu menu1 = new Menu();
        menu1.setId(2);
        menu1.setName("节点2");
        menu1.setPid(1);

        Menu menu2 = new Menu();
        menu2.setId(3);
        menu2.setName("节点3");
        menu2.setPid(1);

        Menu menu3 = new Menu();
        menu3.setId(4);
        menu3.setName("节点4");
        menu3.setPid(3);

        Menu menu4 = new Menu();
        menu4.setId(5);
        menu4.setName("节点5");
        menu4.setPid(3);


        List<Menu> menus = new ArrayList<>();
        menus.add(menu);
        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
        menus.add(menu4);
        return menus;
    }

}
