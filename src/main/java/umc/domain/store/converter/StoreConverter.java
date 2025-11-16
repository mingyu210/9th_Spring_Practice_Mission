package umc.domain.store.converter;

import umc.domain.store.dto.req.StoreReqDTO;
import umc.domain.store.dto.res.StoreResDTO;
import umc.domain.store.entity.Store;

public class StoreConverter {
    // Entity -> DTO
    public static StoreResDTO.CreateResDTO toCreateDTO(
            Store store
    ){
        return StoreResDTO.CreateResDTO.builder()
                .storeId(store.getId())
                .build();
    }

    // DTO -> Entity
    public static Store toStore(
            StoreReqDTO.CreateRequestDTO dto
    ){
        return Store.builder()
                .name(dto.name())
                .info(dto.info())
                .build();
    }
}
