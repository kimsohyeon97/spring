package kr.co.ch06.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2DTO {
    String uid;
    String name;
    String birth;
    String addr;
}
