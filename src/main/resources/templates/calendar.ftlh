<!DOCTYPE html>
<html>
<head>

</head>
<body>
Welcome to our calendar
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
    </div>
</#list>

<p></p>

Add new Game
${game!""}

<form action="add" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}$"/>
    <div><label> Game Name : <input type="text" name="name"/> </label></div>
    <div><label> Description: <input type="text" name="description"/> </label></div>
    <div><label> System: <select name="system">
        <option>DUNGEONSANDDRAGONS</option>
        <option>WARHAMMER</option>
        <option>CTHULHU</option>
    </select> </label></div>
    <div><label> Discord: <input type="text" name="discord"/> </label></div>

    <div><input type="submit" value="Create"/></div>

</form>
</body>
</html>