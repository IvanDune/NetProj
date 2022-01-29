<#import "parts/common.ftlh" as c>

<@c.page>

<form method="post" action="user" >
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="col-sm-5">
    <input type="text" name="filter" class="form-control" value="${filter!""}" placeholder="Enter user's login">
    </div>
    <button type="submit" class="btn btn-primary ml-2 mt-2">Find</button>
</form>

    <div><h5>List of users</h5></div>
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

</@c.page>

