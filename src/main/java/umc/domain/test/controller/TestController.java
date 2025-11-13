package umc.domain.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.domain.test.converter.TestConverter;
import umc.domain.test.dto.res.TestResDTO;
import umc.domain.test.exception.TestException;
import umc.global.apiPayload.ApiResponse;
import umc.global.apiPayload.code.GeneralErrorCode;
import umc.global.apiPayload.code.GeneralSuccessCode;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temp")
public class TestController {

    @GetMapping("/test")
    public ApiResponse<TestResDTO .Testing> test() throws Exception{
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        throw new TestException(GeneralErrorCode.NOT_FOUND);
/*        return ApiResponse.onSuccess(
                code,
                TestConverter.toTestingDTO("This is Test!")
        );*/
    }
}
