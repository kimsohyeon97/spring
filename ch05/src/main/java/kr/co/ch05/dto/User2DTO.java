package kr.co.ch05.dto;

public class User2DTO {
    private String uid;
    private String name;
    private String hp;
    private int age;
    private String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User2DTO{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", hp='" + hp + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
