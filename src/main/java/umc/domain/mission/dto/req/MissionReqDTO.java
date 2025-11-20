package umc.domain.mission.dto.req;

import umc.global.annotation.ExistStore;

public class MissionReqDTO {
    public record CreateReqDTO(
            String content,
            Integer point,
            String authCode,
            Integer period,
            @ExistStore
            Long storeId
    ){}
}
