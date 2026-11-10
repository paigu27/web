package com.myblog.controller;

import com.myblog.model.PersonalProfile;
import com.myblog.service.IdentityProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Week 03 - GET /profile：完整身份画像。
 */
@RestController
public class ProfileController {

    private final IdentityProvider identity;

    public ProfileController(IdentityProvider identity) {
        this.identity = identity;
    }

    @GetMapping("/profile")
    public PersonalProfile profile() {
        return identity.get();
    }
}
