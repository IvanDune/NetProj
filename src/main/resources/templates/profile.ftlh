<#import "parts/common.ftlh" as c>
<@c.page>

    <h4>${user.nickname}, it's your profile </h4>

    <form action="profile" method="post">
        <label>Nickname: <input type="text" name="nickname" value="${nickname}"></label>
        <label>Email: <input type="text" name="email" value="${email!""}"></label>
        <input type="hidden" value="${_csrf.token}" name = "_csrf">
        <button type="submit">Save</button>
    </form>



</@c.page>