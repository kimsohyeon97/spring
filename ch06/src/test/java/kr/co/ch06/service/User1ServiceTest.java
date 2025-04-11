package kr.co.ch06.service;

import kr.co.ch06.dto.User1DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.ExpectedCount;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class User1ServiceTest {

    @Autowired
    private User1Service user1Service;

    @Test
    void register() {

        //given
        User1DTO givenUser = User1DTO.builder()
                .uid("test101")
                .name("수정 테스트")
                .hp("010-2211-1115")
                .age(22)
                .build();

        //when
        user1Service.register(givenUser);

        //then
        User1DTO expected = user1Service.findById(givenUser.getUid());
        Assertions.assertNotNull(expected);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void modify() {
    }

    @Test
    void delete() {
    }
}