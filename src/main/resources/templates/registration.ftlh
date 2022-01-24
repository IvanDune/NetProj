<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <h4 class="mb-1">${user!""}</h4>
    <@l.login "/registration" true />
</@c.page>

<!-- В видео использовался макрос для логина и регистрации.
 У меня в регистрации на 2 поля больше. Что делать?-->