package com.nso.project.controller;

import com.nso.project.dto.card.MemberCard;
import com.nso.project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    private final MemberService service;

    @GetMapping
    public ResponseEntity<List<MemberCard>> findAllMembers() {
        log.info("[Controller] find all members");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberCard> findMemberById(@PathVariable Long id) {
        log.info("[Controller] find member by id: {}", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<MemberCard> createMember(@RequestBody MemberCard memberCard) {
        log.info("[Controller] Create a new member: {}", memberCard);
        return ResponseEntity.ok(service.create(memberCard));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberCard> updateMember(
            @PathVariable Long id,
            @RequestBody MemberCard memberCard
    ) {
        log.info("[Controller] Update a member: {}", memberCard);
        return ResponseEntity.ok(service.update(id, memberCard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MemberCard> deleteMember(@PathVariable Long id) {
        log.info("[Controller] Delete a member: {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
