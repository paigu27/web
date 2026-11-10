package com.myblog.service;

import com.myblog.model.PersonalProfile;
import org.springframework.stereotype.Component;

/**
 * Week 05 (Level 3) - 身份的独立 provider：
 * /profile 与 /me 都从这里取身份，不再重复，永远说同一套话。
 */
@Component
public class IdentityProvider {

    public PersonalProfile get() {
        PersonalProfile p = new PersonalProfile();
        p.blogName = "MyBlog";
        p.owner = "Alex";
        p.introduction = "I build things that matter.";
        p.interests = "systems, long-form writing";
        p.vision = "a blog that outlives the course";
        return p;
    }
}
