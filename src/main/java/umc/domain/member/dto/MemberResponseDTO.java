package umc.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
    private Integer point;
}
