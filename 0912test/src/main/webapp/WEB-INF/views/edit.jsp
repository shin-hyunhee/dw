<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Phonebook</title>
</head>
<body>
    <h1>Edit Phonebook</h1>
    <form:form modelAttribute="phonebook" action="${phonebook.id == 0 ? '/phonebook/save' : '/phonebook/update'}" method="post">
        <input type="hidden" name="id" value="${phonebook.id}"/>
        <div>
            <label for="name">Name:</label>
            <form:input path="name" id="name"/>
        </div>
        <div>
            <label for="hp">Phone:</label>
            <form:input path="hp" id="hp"/>
        </div>
        <div>
            <label for="memo">Memo:</label>
            <form:textarea path="memo" id="memo"/>
        </div>
        <div>
            <button type="submit">Save</button>
        </div>
    </form:form>
    <a href="<c:url value='/phonebook/list'/>">Back to List</a>
</body>
</html>
