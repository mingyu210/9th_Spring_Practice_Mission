package umc.domain.member.converter;

import umc.domain.member.dto.MemberResponseDTO;
import umc.domain.member.entity.Member;

public class MemberConverter {

    public static MemberResponseDTO toResponseDTO(Member member) {
        return MemberResponseDTO.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .address(member.getAddress())
                .point(member.getPoint())
                .build();
    }
}
