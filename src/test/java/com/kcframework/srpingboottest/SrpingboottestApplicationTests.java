package com.kcframework.srpingboottest;

import com.kcframework.srpingboottest.controller.Scheduler2Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableScheduling//定时服务
public class SrpingboottestApplicationTests {

    @Autowired
    private Scheduler2Task t1;
    @Autowired
    private Scheduler2Task t2;
//    @Autowired
//    private HelloSender helloSender;
//
//    @Test
//    public void hello() throws Exception {
//        helloSender.send();
//    }

//    @Test
//    public void oneToMany() throws Exception {
//        for (int i = 0; i < 100; i++) {
//            helloSender.send(i);
//        }
//    }
    @Test
    public void contextLoads() {
        t1.reportCurrentTime();t2.reportCurrentTime();
    }

}
