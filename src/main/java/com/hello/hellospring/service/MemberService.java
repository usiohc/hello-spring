package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.reopsitory.MemberRepository;
import com.hello.hellospring.reopsitory.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();


    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름을 가진 중복 회원 X
        validateDuplicateMember(member);
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//                throw new IllegalStateException("이미 존재하는 회원입니다.");}
//        );

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                }
        );
    }


    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findByid(memberId);
    }
}
