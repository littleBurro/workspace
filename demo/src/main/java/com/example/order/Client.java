package com.example.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
//        Receiver receiver = new Receiver();
//        Command command = new ConcreteCommand(receiver);
//        Invoker invoker = new Invoker();
//        invoker.setCommand(command);
//        invoker.action();

//        String string = "native_cgj_third_party_topic_appointmentOrderAdd";
//        System.out.println(string.substring(string.lastIndexOf("_") + 1));
//
//        Map<String, Integer> map = new HashMap<>();
//        map.put("test", 1);
//        List<Map<String, Integer>> list = new ArrayList<>();
//        list.add(map);
//        map.put("test", 2);
//        System.out.println(list.get(0).get("test"));

        Map<User, String> map = new HashMap<>();
        User user;
        map.put(user = new User(), "1");
        user.setName("张三");
        System.out.println(map.get(user));
    }
}
