package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

public class FwCollectionUtils {

    private FwCollectionUtils(){}

    public static <T> List<T> emptyList(){
        return new ArrayList<>();
    }

    public static <T> List<T> singletonList(T value){
        List<T> list = new ArrayList<>();
        list.add(value);
        return list;
    }
}
