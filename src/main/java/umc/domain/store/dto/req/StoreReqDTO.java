package umc.domain.store.dto.req;

import umc.domain.region.entity.Region;

public class StoreReqDTO {
    public record CreateRequestDTO(
            String name,
            String info,
            Long regionId
    ){}
}
