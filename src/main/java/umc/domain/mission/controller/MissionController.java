package umc.domain.mission.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.domain.mission.dto.MissionResponseDTO;
import umc.domain.mission.service.MissionQueryService;
import umc.global.apiPayload.dto.PageResponseDTO;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {
    private final MissionQueryService missionQueryService;

    @GetMapping("/available")
    public ResponseEntity<PageResponseDTO<MissionResponseDTO>> getAvailableMissions(
            @RequestParam Long regionId,
            @RequestParam Long memberId,
            Pageable pageable
    ) {
        PageResponseDTO<MissionResponseDTO> result =
                missionQueryService.getAvailableMissions(regionId, memberId, pageable);

        return ResponseEntity.ok(result);
    }
}
