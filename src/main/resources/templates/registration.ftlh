<#import "parts/common.ftlh" as c>
<@c.page>
Add new User
<br>${user!""}
<form action="/registration" method="post">
    <div><label> User Name : <input type="text" name="login"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><label> Nickname: <input type="test" name="nickname"/> </label></div>
    <div><label> Email: <input type="text" name="email"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><input type="submit" value="Sign In"/></div>
</form>
</@c.page>

<!-- В видео использовался макрос для логина и регистрации.
 У меня в регистрации на 2 поля больше. Что делать?-->