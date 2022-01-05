<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>

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

    <p>
        <a href="/calendar">Here our calendar</a>

</@c.page>

