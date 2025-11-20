package umc.domain.mission.dto.res;

import lombok.Builder;

public class MissionResDTO {
    @Builder
    public record CreateResDTO(
            Long missionId
    ){}
}
