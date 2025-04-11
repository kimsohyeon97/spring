<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>user1::modify</title>
</head>
<body>
<h3>user1 수정</h3>
<a href="/ch05">처음으로</a>
<a href="/ch05/user2/list">목록이동</a>

<form action="/ch05/user2/modify" method="post">
    <table border="1">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="uid" value="${user2DTO.uid}" readonly placeholder="아이디 입력"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" value="${user2DTO.name}" placeholder="이름 입력"></td>
        </tr>
        <tr>
            <td>휴대폰</td>
            <td><input type="text" name="hp" value="${user2DTO.hp}" placeholder="휴대폰 입력"></td>
        </tr>
        <tr>
            <td>나이</td>
            <td><input type="number" name="age" value="${user2DTO.age}" placeholder="나이 입력"></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="addr" value="${user2DTO.addr}" placeholder="주소 입력"></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="수정하기">
            </td>
        </tr>
    </table>
</form>
</body>
</html>