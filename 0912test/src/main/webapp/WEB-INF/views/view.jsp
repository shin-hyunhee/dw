<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>전화번호부 상세정보</title>
</head>
<body>
    <h1>전화번호부 상세정보</h1>
    <table border="1">
        <tr>
            <th>이름</th>
            <td>${phonebook.name}</td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td>${phonebook.hp}</td>
        </tr>
        <tr>
            <th>메모</th>
            <td>${phonebook.memo}</td>
        </tr>
    </table>
    <a href="list.jsp">목록으로 돌아가기</a>
    <a href="edit.jsp?id=${phonebook.id}">수정하기</a>
    <a href="delete.jsp?id=${phonebook.id}">삭제하기</a>
</body>
</html>
