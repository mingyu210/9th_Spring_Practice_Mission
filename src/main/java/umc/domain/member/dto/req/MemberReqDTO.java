package umc.domain.member.dto.req;

import umc.domain.member.entity.mapping.MemberFood;
import umc.domain.member.enums.Gender;
import umc.global.annotation.ExistFoods;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {

    public record SignupRequestDTO(
            String name,
            String password,
            Gender gender,
            LocalDate birthday,
            String address,
            String phone,
            String email,
            @ExistFoods
            List<Long> preferCategory
    ){

    }
}
