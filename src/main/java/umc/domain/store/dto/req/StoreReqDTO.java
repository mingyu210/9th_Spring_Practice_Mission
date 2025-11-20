package umc.domain.store.dto.req;


public class StoreReqDTO {
    public record CreateRequestDTO(
            String name,
            String info,
            Long regionId
    ){}
}
