package com.hello.hellospring.controller;

import com.hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 디펜던시 인젝션 DI
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;

    }
}
