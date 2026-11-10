package com.myblog.controller;

import com.myblog.model.BlogProfile;
import com.myblog.model.PersonalProfile;
import com.myblog.service.IdentityProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Week 01 - /hello：MyBlog 的第一句话（I Exist）。
 * Week 02 - /me：从 String 升级为 JSON（I Speak）。
 * Week 03 - /me 与 /profile 的身份保持一致（I Am Someone）。
 */
@RestController
public class HelloController {

    private final IdentityProvider identity;

    public HelloController(IdentityProvider identity) {
        this.identity = identity;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello MyBlog, I am " + identity.get().owner + ".";
    }

    @GetMapping("/me")
    public BlogProfile me() {
        PersonalProfile who = identity.get();
        BlogProfile p = new BlogProfile();
        p.name = who.blogName;
        p.owner = who.owner;
        p.message = "Nice to meet you. " + who.introduction;
        return p;
    }
}
