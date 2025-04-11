package kr.co.ch05.service;

import kr.co.ch05.dao.User2Mapper;
import kr.co.ch05.dto.User2DTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2Service {

    private final User2Mapper user2Mapper;

    public User2Service(User2Mapper user2Mapper) {
        this.user2Mapper = user2Mapper;
    }

    public void register(User2DTO user2DTO){
        user2Mapper.insertUser2(user2DTO);
    }

    public List<User2DTO> findAll(){
        return user2Mapper.selectAllUser2();
    }

    public User2DTO findById(String uid){
        return user2Mapper.selectUser2(uid);
    }

    public void modify(User2DTO user2DTO){
        user2Mapper.updateUser2(user2DTO);
    }

    public void delete(String uid){
        user2Mapper.deleteUser1(uid);
    }
}
