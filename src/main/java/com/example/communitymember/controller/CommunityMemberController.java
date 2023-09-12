package com.example.communitymember.controller;


import com.example.communitymember.domain.entity.CommunityMember;
import com.example.communitymember.domain.request.CommunityMemberReqeust;
import com.example.communitymember.service.CommunityMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/communitymember")
public class CommunityMemberController {
    private final CommunityMemberService communityMemberService;

    @PostMapping("/{communityId}")
    public void saveCommunityMember(@PathVariable("communityId") Long communityId,
                                    @RequestBody CommunityMemberReqeust communityMemberReqeust){
        communityMemberService.saveCommunityMember(communityMemberReqeust,communityId);
    }

    @GetMapping("/communityid/{communityId}")
    public List<CommunityMember> findAllByCommunityId(@PathVariable("communityId") Long communityId){
        return communityMemberService.findAllByCommunityId(communityId);
    }

    @GetMapping("/memberid/{memberId}")
    public List<CommunityMember> findAllByMemberId(@PathVariable("memberId") Long memberId){
        return communityMemberService.findAllByMemberId(memberId);
    }


    @PutMapping("/updatecommunity/{communityId}")
    public void updateCommunityInCommunityMember(
            @RequestBody CommunityMemberReqeust communityMemberReqeust,
            @PathVariable("communityId") Long communityId){
        communityMemberService.updateCommunityInCommunityMember(communityMemberReqeust,communityId);
    }

    @PutMapping("/updatemember/{memberId}")
    public void updateMemberInCommunityMember(
            @RequestBody CommunityMemberReqeust communityMemberReqeust,
            @PathVariable("memberId") Long memberId){
        communityMemberService.updateMemberInCommunityMember(communityMemberReqeust,memberId);
    }


    @Transactional
    @DeleteMapping("/memberid/{memberId}/communityid/{communityId}")
    public void deleteCommunityMember(
            @PathVariable("memberId") Long memberId,
            @PathVariable("communityId")Long communityId){
        communityMemberService.deleteCommunityMember(memberId,communityId);
    }

}
