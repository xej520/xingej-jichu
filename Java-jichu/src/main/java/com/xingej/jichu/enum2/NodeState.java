package com.xingej.jichu.enum2;

/**
 * 枚举类型 测试
 * 
 * 使用枚举来定义常量的好处？
 * 
 * 1、可以使用用switch语句中；2、枚举类型的常量属于 稳态性
 * 
 * 
 * @author erjun 2017年11月13日 下午6:03:15
 */
public enum NodeState {
    WAITING("WAITING"), RUNNING("RUNNING"), STOPPED("STOPPED"), FAILED("FAILED");

    private String nodeSate;

    //
    private NodeState(String nodeState) {
        this.nodeSate = nodeState;
    }

    public String getNodeState() {
        return nodeSate;
    }

    @Override
    public String toString() {
        return String.valueOf(this.nodeSate);
    }
}
