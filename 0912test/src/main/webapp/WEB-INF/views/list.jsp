<!DOCTYPE html>
<html>
<head>
    <title>Phonebook List</title>
</head>
<body>
    <h1>Phonebook List</h1>
    <form action="/phonebook/add" method="post">
        <input type="text" name="name" placeholder="Name" required>
        <input type="text" name="hp" placeholder="Phone Number" required>
        <input type="text" name="memo" placeholder="Memo">
        <button type="submit">Add</button>
    </form>

    <form action="/phonebook/search" method="get">
        <input type="text" name="search" placeholder="Search">
        <button type="submit">Search</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Phone Number</th>
                <th>Memo</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="phonebook" items="${phonebooks}">
                <tr>
                    <td><c:out value="${phonebook.name}"/></td>
                    <td><c:out value="${phonebook.hp}"/></td>
                    <td><c:out value="${phonebook.memo}"/></td>
                    <td>
                        <a href="/phonebook/view/${phonebook.id}">View</a>
                        <form action="/phonebook/delete/${phonebook.id}" method="post" style="display:inline;">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
