package umc.domain.store.dto.req;


import umc.global.annotation.ExistFood;

public class StoreReqDTO {
    public record CreateRequestDTO(
            String name,
            String info,
            Long regionId,
            @ExistFood
            Long foodId
    ){}
}
