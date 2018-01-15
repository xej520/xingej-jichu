package com.xingej.jichu.enum2;

/**
 * 枚举 ：产品
 * 
 * 枚举类:构造方法私有化，提供外界访问的接口API
 * 
 * @author erjun 2017年12月10日 上午5:34:18
 */
public enum ProductStatusEnums {

    UP(0, "上架"), DOWN(1, "下架");

    // 注意，这里有两个属性，一个code， 一个message
    private Integer code;

    private String message;

    // 注意，枚举类的构造方法，也是
    // 私有的哦
    private ProductStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    // 枚举类里，
    // 提供外界访问的
    // 私有方法
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {
        System.out.println("---->:\t" + ProductStatusEnums.UP.getCode());
    }
}
