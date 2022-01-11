<!DOCTYPE html>
<html>
<head>

</head>
<body>
<h1>Welcome to our calendar</h1>
<form method="post" action="calendar">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="text" name="filter">
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
        <span>${game.dateTime}</span>
    </div>
</#list>

<p></p>

Add new Game
${game!""}

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
    <div><label> Date: <input type="date" name="dateTime"/> </label></div>

    <div><input type="submit" value="Create"/></div>

</form>
<a href="/main">Here our main page</a>
</body>
</html>