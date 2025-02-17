package shop.mtcoding.metamall.core.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import shop.mtcoding.metamall.dto.ResponseDto;
import shop.mtcoding.metamall.model.log.err.ErrorLog;
import shop.mtcoding.metamall.model.log.err.ErrorLogRepository;


// 권한 없음
@Getter
public class Exception403 extends RuntimeException {

    public Exception403(String message) {
        super(message);
    }

    public ResponseDto<?> body(){
        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.fail(HttpStatus.FORBIDDEN, "forbidden", getMessage());
        return responseDto;
    }

    public HttpStatus status(){
        return HttpStatus.FORBIDDEN;
    }
}