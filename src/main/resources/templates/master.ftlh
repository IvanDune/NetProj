<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>
        <@l.logout/>
    </div>

    <div><h2>Имя первого мастера</h2></div>
    <div><h4>Описание первого мастера</h4></div>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="text" name="mess" placeholder="Enter your message"/></div>
        <button type="submit">Send</button>
    </form>
    <#list messages as message>
        <div>
        <span>${message.id}</span>
        <span>${message.text}</span>
        <strong>${message.getAuthorName()}</strong>
        </div>
    </#list>


    <a href="/main">Here our main page</a>
    <p><a href="/calendar">Here our calendar</a></p>


</@c.page>