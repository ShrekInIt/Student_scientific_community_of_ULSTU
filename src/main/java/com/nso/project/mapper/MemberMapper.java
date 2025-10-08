package com.nso.project.mapper;

import com.nso.project.dto.card.MemberCard;
import com.nso.project.entity.MemberEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public MemberCard toMember(MemberEntity memberEntity) {
        return new MemberCard(
                memberEntity.getId(),
                memberEntity.getPhotoUrl(),
                memberEntity.getNameAuthor(),
                memberEntity.getSurNameAuthor(),
                memberEntity.getPatronymicAuthor(),
                memberEntity.getPost(),
                memberEntity.getEmail(),
                memberEntity.getPassword(),
                memberEntity.getContactPhone(),
                memberEntity.getAboutMe(),
                memberEntity.getEvents(),
                memberEntity.isAvailable()
        );
    }

    public MemberEntity toEntity(MemberCard member) {
        return new MemberEntity(
                member.getId(),
                member.getPhotoUrl(),
                member.getNameAuthor(),
                member.getSurNameAuthor(),
                member.getPatronymicAuthor(),
                member.getPost(),
                member.getEmail(),
                member.getPassword(),
                member.getContactPhone(),
                member.getAboutMe(),
                member.getEvents(),
                member.isAvailable()
        );
    }

}
