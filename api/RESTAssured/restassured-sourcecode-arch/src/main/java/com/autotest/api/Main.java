package com.autotest.api;

import com.autotest.api.endpoits.ServiceUrlMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        ServiceUrlMap smap = new ServiceUrlMap();

        System.out.println(smap.getPOSTS_URL());
        System.out.println(smap.getCOMMENTS_URL());
        System.out.println(smap.getALBUMS_URL());
        System.out.println(smap.getPHOTOS_URL());
        System.out.println(smap.getTODOS_URL());
        System.out.println(smap.);

    }
}