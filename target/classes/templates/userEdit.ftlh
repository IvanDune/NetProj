<#import "parts/common.ftlh" as c>
<@c.page>
    <br><h5>It's ${user.login} roles </h5>

<nav class="navbar navbar-dark bg-light col-sm-5">
    <div class="container-fluid">
        <div class="form-group col-md-6">
    <form action="/user/${user.id}" method="post">
        <#list roles as role>
            <div>
                <label><input  class="form-check-input" type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name = "userId">
        <input type="hidden" value="${_csrf.token}" name = "_csrf">
        <button type="submit" class="btn btn-primary ml-2 mt-2">Save</button>
    </form>
        </div>
    </div>
</nav>
</@c.page>

