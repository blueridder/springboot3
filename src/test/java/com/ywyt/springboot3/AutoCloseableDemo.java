package com.ywyt.springboot3;

import org.junit.Test;

/**
 * @author xiejin
 * @date 2019/11/6 9:43
 */
public class AutoCloseableDemo {

    @Test
    public void test1() {
        try (AutoCloseableObject app = new AutoCloseableObject()) {
            System.out.println("-----执行测试方法-----");
        } catch (Exception e) {
            System.out.println("----exception----");
        }
    }


    public class AutoCloseableObject implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("----closed----");
        }
    }
}



