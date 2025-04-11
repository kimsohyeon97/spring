package kr.co.ch06.service;

import kr.co.ch06.dao.User2Mapper;
import kr.co.ch06.dto.User2DTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class User2Service {

    private final User2Mapper user2Mapper;

    public void insertUser2(User2DTO user2DTO) {
        user2Mapper.insertUser2(user2DTO);
    }

    public User2DTO selectUser2(String uid) {
        return user2Mapper.selectUser2(uid);
    }

    public List<User2DTO> selectAllUser2() {
        return user2Mapper.selectAllUser2();
    }

    public void updateUser2(User2DTO user2DTO) {
        user2Mapper.updateUser2(user2DTO);
    }

    public void deleteUser2(String uid) {
        user2Mapper.deleteUser2(uid);
    }

}
