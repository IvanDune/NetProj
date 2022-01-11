<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>

<div>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="text" name="login" placeholder="Enter user's login"/>
        <input type="text" name="password" placeholder="Enter user's password"/>
        <input type="text" name="nickname" placeholder="Enter user's nickname"/>
        <input type="text" name="email" placeholder="Enter user's email"/>
        <button type="submit">Submit</button>
    </form>
</div>

<form method="get" >
    <input type="text" name="filter" value="${filter}" placeholder="Enter user's nickname">
    <button type="submit">Find</button>
</form>

<div>List of users</div>
${message!""}
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Password</th>
            <th>Nickname</th>
            <th>Email</th>
            <th>Role</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.nickname}</td>
                <td>${user.email}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
        <#else>
            No users
        </#list>
        </tbody>
    </table>

    <a href="/main">Here our main page</a>

</@c.page>

