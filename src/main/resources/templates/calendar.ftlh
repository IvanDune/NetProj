<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>
        <@l.logout/>
    </div>
<h1>Welcome to our calendar</h1>
    ${message!""}

<form method="post" action="calendar">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="text" name="filter" value="${filter!""}">
    <button type="submit">Find</button>
</form>

<div>List of games</div>

    <table >
        <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>System</th>
            <th>Discord</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <#list games as game>
            <tr>
                <td style="text-align: center">${game.name}</td>
                <td style="text-align: center">${game.description}</td>
                <td style="text-align: center">${game.system}</td>
                <td style="text-align: center">${game.discord}</td>
                <td style="text-align: center">${game.date}</td>
            </tr>
        <#else>
            No games
        </#list>
        </tbody>
    </table>

<br>
    <#list userChannel.roles as role>
        <#if role  = "MASTER">
Add new Game


<form action="/add" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><label> Game Name : <input type="text" name="name"/> </label></div>
    <div><label> Description: <input type="text" name="description"/> </label></div>
    <div><label> System: <select name="system">
        <option>DUNGEONSANDDRAGONS</option>
        <option>WARHAMMER</option>
        <option>CTHULHU</option>
    </select> </label></div>
    <div><label> Discord: <input type="text" name="discord"/> </label></div>
    <div><label> Date: <input type="date" name="date"/> </label></div>
    <div><label> Time: <input type="time" name="time"/> </label></div>

    <div><input type="submit" value="Create"/></div>
        </#if>
    </#list>

</form>
<a href="/main">Here our main page</a>
</@c.page>