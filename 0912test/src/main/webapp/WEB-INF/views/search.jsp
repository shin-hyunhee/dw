<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Phonebook</title>
</head>
<body>
    <h1>Search Phonebook</h1>
    <form:form modelAttribute="searchCriteria" action="/phonebook/search" method="post">
        <div>
            <label for="search">Search:</label>
            <form:input path="search" id="search"/>
        </div>
        <div>
            <button type="submit">Search</button>
        </div>
    </form:form>

    <h2>Results:</h2>
    <c:forEach var="entry" items="${phonebookList}">
        <div>
            <p>Name: ${entry.name}</p>
            <p>Phone: ${entry.hp}</p>
            <p>Memo: ${entry.memo}</p>
            <a href="<c:url value='/phonebook/view?id=${entry.id}'/>">View Details</a>
        </div>
        <hr/>
    </c:forEach>
</body>
</html>
