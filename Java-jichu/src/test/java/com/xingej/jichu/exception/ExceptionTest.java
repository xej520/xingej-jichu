package com.xingej.jichu.exception;

import org.junit.Test;

/**
 * 异常测试
 * 
 * @author erjun 2017年11月14日 下午4:07:42
 */
public class ExceptionTest {

    // 目的是 测试 ：在循环中，如果有一次出现异常了，程序是否还继续循环
    @Test
    public void testIsContinue() {
        for (int i = 10; i > 0; i--) {

            try {
                System.out.printf("%d / %d = %d\t", i, (i - 4), i / (i - 4));
            } catch (Exception e) {
                // 虽然这里，捕获到了异常，但是，仅仅是打印出来了
                System.out.println("\n-------出问题-----------");
                // 仅仅是打印 错误信息，
                e.printStackTrace();

                // 程序，还会继续循环执行的
            }

        }
    }

}
