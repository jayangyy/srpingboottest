/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.srpingboottest.controller;

import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jayan
 */
@RestController
public class RdistTestController {

    @RequestMapping("/getUser")
    @Cacheable(value = "user-key")
    public User getUser() {
        User o = new User();
        o.setName("");
        o.setRoles(null);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return o;
    }
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
//    @Cacheable(value="signonCache", key="'petstore:signon:'+#username", unless="#result==null")
//public Signon findByName(String username) {
//    return dao.fetchOneByUsername(username);
//}
//
//@CacheEvict(value="signonCache", key="'petstore:signon:'+#user.username")
//public void update(Signon user) {
//    dao.update(user);
//}
}
