package kr.co.ch09.controller;

import jakarta.validation.Valid;
import kr.co.ch09.dto.User1DTO;
import kr.co.ch09.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service user1Service;

    // @ResponsBody는 메서드의 반환값을 응답객체 본문으로 출력하기 위한 어노테이션, 자동 JSON 변환 출력
    @ResponseBody
    @GetMapping("/user1")
    public List<User1DTO> list(){
        return user1Service.findAll();
    }

    @ResponseBody
    @GetMapping("/user1/{uid}")
    public User1DTO user(@PathVariable("uid") String uid){ //@PathVariable는 주소 파라미터 값을 바인딩하기 위한 어노테이션
        return user1Service.findById(uid);
    }

    /*
        @RequestBody
        - 요청본문 내용에 포함된 데이터를 Java 객체로 변환하는 어노테이션, JSON 데이터 수신

        @Valid
        - REST API 서비스 특성상 클라이언트에서 유효성검사를 하기 어렵기 때문에 백엔드에서 유효성검사르 수행
        - 수신 처리되는 DTO의 유효성검사 하기 위해 어노테이션(@NotBlank, @NotEmpty, @NotNUll, @Email...)를 사용
        - @Valid 어노테이션으로 유효성검사 어노테이션을 수행
     */


    // 1. 보낼 때 Json으로 전송함
    @PostMapping("/user1")
    public ResponseEntity<User1DTO> register(@Valid @RequestBody User1DTO user1DTO){ // 요청본문 내용에 포함된 데이터를 Java 객체로 변환하는 어노테이션, Json 데이터 수신, Json User1DTO로 변환
                                                    // 2. json을 DTO로 변환
        log.info("user1DTO: {}", user1DTO);

        User1DTO savedUser1 = user1Service.save(user1DTO);

        // ResponseEntitiy 응답객체를 반환하면 @ResponseBody 어노테이션은 생략가능
        return  ResponseEntity.ok(savedUser1);
        // 3. 다시 JSON으로 변환해서 리턴
    }

    @PutMapping("/user1")
    public ResponseEntity<User1DTO> modify(@RequestBody User1DTO user1DTO){
        User1DTO modifiedUser1 = user1Service.save(user1DTO);
        // ResponseEntitiy 응답객체를 사용하면 요청결과에 대한 다양한 사용자 정의가 가능하기 때문에 개발의 유연성이 높음
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(modifiedUser1);
    }

    @DeleteMapping("/user1/{uid}")
    public ResponseEntity<String> delete(@PathVariable("uid") String uid){

        log.info("uid : {}", uid);

        boolean isDeleted = user1Service.delete(uid);

        log.info("deletedUser1 : {}", isDeleted);

        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("success"); // 4. JSON 아니고 문자열 반환
        }
        return ResponseEntity.notFound().build();
    }
}
