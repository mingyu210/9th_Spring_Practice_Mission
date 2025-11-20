package umc.domain.mission.converter;

import umc.domain.mission.dto.res.MissionResDTO;
import umc.domain.mission.entity.Mission;

public class MissionConverter {
    public static MissionResDTO.MissionResponseDTO toMissionResponseDTO(Mission mission) {
        return MissionResDTO.MissionResponseDTO.builder()
                .id(mission.getId())
                .content(mission.getContent())
                .point(mission.getPoint())
                .period(mission.getPeriod())
                .storeName(mission.getStore().getName())
                .build();
    }
}
