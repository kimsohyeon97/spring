package kr.co.ch07.repository;

import kr.co.ch07.entity.Child;
import kr.co.ch07.entity.Parent;
import kr.co.ch07.entity.User1;
import kr.co.ch07.entity.User2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ByUid() {

        // given
        String uid = "a101";

        // when
        User1 user1 = user1Repository.findUser1ByUid(uid);

        // then
        System.out.println(user1);
    }

    @Test
    void findUser1ByName() {

        List<User1> user1List = user1Repository.findUser1ByName("김모카무스");
        System.out.println(user1List);

    }

    @Test
    void findUser1ByNameNot() {
        List<User1>  user1List =  user1Repository.findUser1ByName("김모카무스");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByUidAndName() {
        User1 user1 = user1Repository.findUser1ByUidAndName("a101", "김모카무스");
        System.out.println(user1);
    }

    @Test
    void findUser1ByUidOrName() {
        List<User1> user1List = user1Repository.findUser1ByUidOrName("A101", "김모카무스");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeGreaterThan() {
        List<User1> user1List = user1Repository.findUser1ByAgeGreaterThan(10);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
        List<User1> user1List = user1Repository.findUser1ByAgeGreaterThanEqual(10);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeLessThan() {
        List<User1> user1List = user1Repository.findUser1ByAgeLessThan(10);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
        List<User1> user1List = user1Repository.findUser1ByAgeLessThanEqual(10);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeBetween() {
        List<User1> user1List = user1Repository.findUser1ByAgeBetween(10, 20);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameLike() {
        List<User1> user1List = user1Repository.findUser1ByNameLike("%김%");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameContains() {
        List<User1> user1List = user1Repository.findUser1ByNameContains("김");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameStartsWith() {
        List<User1> user1List = user1Repository.findUser1ByNameStartsWith("김");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameEndsWith() {
        List<User1> user1List = user1Repository.findUser1ByNameEndsWith("스");
        System.out.println(user1List);
    }


    @Test
    void findUser1ByOrderByName() {
        List<User1> user1List = user1Repository.findUser1ByOrderByName();
        System.out.println(user1List);
    }

    @Test
    void findUser1ByOrderByUid() {
        List<User1> user1List = user1Repository.findUser1ByNameOrderByUid("김모카무스");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByOrderByAgeASC() {
        List<User1> user1List = user1Repository.findUser1ByOrderByAgeAsc();
        System.out.println(user1List);
    }

    @Test
    void findUser1ByOrderByAgeDESC() {
        List<User1> user1List = user1Repository.findUser1ByOrderByAgeDesc();
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDESC() {
        List<User1> user1List = user1Repository.findUser1ByAgeGreaterThanOrderByAgeDesc(10);
        System.out.println(user1List);
    }

    @Test
    void countUser1ByName() {
        int count = user1Repository.countUser1ByName("김모카무스");
        System.out.println(count);
    }

    @Test
    void selectUser1UnderAge30() {
        List<User1> list = user1Repository.selectUser1UnderAge30();
        System.out.println(list);
    }

    @Test
    void selectUser1ByName() {
        List<User1> List = user1Repository.selectUser1ByName("김모카무스");
        System.out.println(List);
    }

    @Test
    void selectUser1ByNameParam() {
        List<User1> list = user1Repository.selectUser1ByNameParam("김모카무스");
        System.out.println(list);
    }

    @Test
    void selectUser1ByUid() {
        List<Object[]> list = user1Repository.selectUser1ByUid("a101");

        for(Object[] arr : list){
            String uid = (String) arr[0];
            String name = (String) arr[1];
            int age = (Integer) arr[2];
            System.out.println("uid : " + uid + " name : " + name + " age : " + age);
        }
    }

    @Test
    void selectAllParentWithChild() {

        // given
        String pid = "p101";

        // when
        List<Object[]> list = user1Repository.selectAllParentWithChild(pid);

        // then
        for(Object[] arr : list){
            Parent parents = (Parent) arr[0];
            Child child = (Child) arr[1];

            System.out.println(parents);
            System.out.println(child);
        }

    }
}