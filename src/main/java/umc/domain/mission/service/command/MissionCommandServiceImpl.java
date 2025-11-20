package umc.domain.mission.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.domain.mission.code.MissionErrorCode;
import umc.domain.mission.converter.MissionConverter;
import umc.domain.mission.dto.req.MissionReqDTO;
import umc.domain.mission.dto.res.MissionResDTO;
import umc.domain.mission.entity.Mission;
import umc.domain.mission.exception.MissionException;
import umc.domain.mission.repository.MissionRepository;
import umc.domain.store.entity.Store;
import umc.domain.store.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public MissionResDTO.CreateResDTO createMission(
            MissionReqDTO.CreateReqDTO dto
    ){
        Store store = storeRepository.findById(dto.storeId())
                .orElseThrow(() -> new MissionException(MissionErrorCode.STORE_NOT_FOUND));
        Mission mission = Mission.builder()
                .content(dto.content())
                .authCode(dto.authCode())
                .period(dto.period())
                .point(dto.point())
                .store(store)
                .build();

        missionRepository.save(mission);

        return MissionConverter.toCreateResDTO(mission);
    }
}
