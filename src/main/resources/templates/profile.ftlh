<#import "parts/common.ftlh" as c>
<@c.page>


    <form action="/privateOffice" method="post">
        Nickname: <input type="text" name="nickname" value="${nickname}">
        Email: <input type="text" name="email" value="${email!""}">
        <input type="hidden" value="${_csrf.token}" name = "_csrf">
        <button type="submit">Save</button>
    </form>

</@c.page>