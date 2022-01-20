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

<#list games as game>
    <div>
        <b>${game.id}</b>
        <span>${game.name}</span>
        <span>${game.description}</span>
        <span>${game.system}</span>
        <span>${game.discord}</span>
        <span>${game.date}</span>
    </div>
</#list>

<p></p>

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

</form>
<a href="/main">Here our main page</a>
</@c.page>