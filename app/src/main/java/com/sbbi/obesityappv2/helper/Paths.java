package com.sbbi.obesityappv2.helper;

/**
 * Created by bsilva on 1/26/17.
 */

public class Paths {

    //development path
    //public static String myPc = "http://129.93.164.34:5150";
    //production path
    public static String myPc = "http://sbbi-panda.unl.edu:8080/obesity";

    public static String signup = myPc + "/user/signup";
    public static String finger = myPc + "/user/finger";
    public static String login = myPc + "/login";
    public static String meal = myPc + "/meal/user";
    public static String recommendation = myPc + "/meal/recommendation";

}
