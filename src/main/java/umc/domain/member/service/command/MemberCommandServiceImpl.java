package umc.domain.member.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.domain.member.dto.req.MemberReqDTO;
import umc.domain.member.dto.res.MemberResponseDTO;
import umc.domain.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    @Override
    public MemberResponseDTO.SignupResponseDTO signup(
            MemberReqDTO.SignupRequestDTO dto
    ){
        return null;
    }
}
