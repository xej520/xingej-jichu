package com.xingej.jichu.enum2;

/**
 * 枚举作用？或者说，使用场景：定义常量值
 * 
 * 不能提供setXXX方法
 * 
 * @author erjun 2017年12月7日 上午5:49:13
 */
public enum ExpressionEnum {
    // dot，separator。。。。。就是当前枚举类ExpressionEnum的实例对象名称
    // ".","/" 是传入的参数
    dot("."), separator("/"), dollar("$"), openBracket("["), closeBracket("]"), equal("="), comma(",")

    // xml 这个是文件名后缀
    , xml("xml")

    // 这个是前缀
    , xmlFilePre("/cn/javass/xgenconfxml");
    private String expr;

    private ExpressionEnum(String expr) {
        this.expr = expr;
    }

    // 通过这个方法，可以将".","/"取出来
    public String getExpr() {
        return this.expr;
    }

    // 简单测试
    public static void main(String[] args) {
        System.out.println(ExpressionEnum.dollar.getExpr());// 获得的是，传入的参数值
        System.out.println(ExpressionEnum.dollar.name()); // name()得到的是，对象名称
        System.out.println(ExpressionEnum.dollar.values().length); // 对象名称的长度

    }

}