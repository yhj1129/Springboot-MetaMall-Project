package shop.mtcoding.metamall.core.exception;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import shop.mtcoding.metamall.dto.ResponseDto;
import shop.mtcoding.metamall.model.log.err.ErrorLog;
import shop.mtcoding.metamall.model.log.err.ErrorLogRepository;


// 유효성 실패
@Getter
public class Exception400 extends RuntimeException {

    public Exception400(String message) {
        super(message);
    }

    public ResponseDto<?> body(){
        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.fail(HttpStatus.BAD_REQUEST, "badRequest", getMessage());
        return responseDto;
    }

    public HttpStatus status(){
        return HttpStatus.BAD_REQUEST;
    }
}