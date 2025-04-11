<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>user1::list</title>
</head>
<body>
<h3>user1 목록</h3>
<a href="/ch05">처음으로</a>
<a href="/ch05/user2/register">등록하기</a>
<table border="1">
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>휴대폰</th>
        <th>나이</th>
        <th>주소</th>
    </tr>
    <c:forEach var="user2" items="${user2DTOs}">
        <tr>
            <td>${user2.uid}</td>
            <td>${user2.name}</td>
            <td>${user2.hp}</td>
            <td>${user2.age}</td>
            <td>${user2.addr}</td>
            <td>
                <a href="/ch05/user2/modify?uid=${user2.uid}">수정</a>
                <a href="/ch05/user2/delete?uid=${user2.uid}">삭제</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>