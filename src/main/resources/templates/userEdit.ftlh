<#import "parts/common.ftlh" as c>
<@c.page>
    User editor
    ${message!""}
    <br>It's ${user.login} roles
    <form action="/user/${user.id}" method="post">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name = "userId">
        <input type="hidden" value="${_csrf.token}" name = "_csrf">
        <button type="submit">Save</button>
    </form>

    <a href="/main">Here our main page</a>
    <p><a href="/user">User list</a></p>
</@c.page>

