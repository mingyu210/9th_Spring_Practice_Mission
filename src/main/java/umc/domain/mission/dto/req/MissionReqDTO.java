package umc.domain.mission.dto.req;

public class MissionReqDTO {
    public record CreateReqDTO(
            String content,
            Integer point,
            String authCode,
            Integer period,
            Long storeId
    ){}
}
