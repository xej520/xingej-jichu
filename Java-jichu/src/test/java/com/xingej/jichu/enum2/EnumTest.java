package com.xingej.jichu.enum2;

public class EnumTest {
    public static void main(String[] args) {

        // name()方法，默认提供的
        // 更加提倡使用name()来获取属性
        System.out.println("FAILED".equals(NodeState.FAILED.name()));

        // 使用自定义的getNodeState()方法来获取
        System.out.println("WAITING".equals(NodeState.WAITING.getNodeState()));
    }
}
