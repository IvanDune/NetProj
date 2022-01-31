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
    <h4><font color="#dc143c">${message!""}</font></h4>
    <table class="table table-hover">
        <thead>
        <tr>
            <th class="align-middle text-center">Id</th>
            <th class="align-middle text-center">Name</th>
            <th class="align-middle text-center">Nickname</th>
            <th class="align-middle text-center">Email</th>
            <th class="align-middle text-center">Role</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td class="align-middle text-center" >${user.id}</td>
                <td class="align-middle text-center" >${user.login}</td>
                <td class="align-middle text-center" >${user.nickname}</td>
                <td class="align-middle text-center" >${user.email}</td>
                <td class="align-middle text-center" ><#list user.roles as role>${role}<#sep>, </#list></td>
                <td class="align-middle text-center" ><a href="/user/${user.id}">edit</a></td>

            </tr>
        <#else>
            No users
        </#list>
        </tbody>
    </table>

</@c.page>

