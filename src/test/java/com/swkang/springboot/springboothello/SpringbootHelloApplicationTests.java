package com.swkang.springboot.springboothello;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootHelloApplication.class})
public class SpringbootHelloApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Test
    public void testOne(){
        System.out.println("test hello 1");
        TestCase.assertEquals(1, 1);
    }

    @Test
    public void testTwo(){
        System.out.println("test hello 2");
        TestCase.assertEquals(1, 1);
    }

    @Before  //执行测试之前执行
    public void testBefore(){
        System.out.println("before");
    }

    @After //执行测试之后执行
    public void testAfter(){
        System.out.println("after");
    }

}
