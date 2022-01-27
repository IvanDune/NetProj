<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>

<h1>Welcome to our calendar</h1>
    ${message!""}

    <nav class="navbar navbar-dark bg-light col-sm-5">
        <div class="container-fluid">
    <div class="form-group col-md-6">
        <form method="post" action="calendar" class="form-inline">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="col-sm-7">
            <input type="text" name="filter" class="form-control" value="${filter!""}" placeholder="Search by name">
            </div>
            <button type="submit" class="btn btn btn-primary ml-2 mt-2">Search</button>
        </form>
    </div>
</div>
    </nav>


<div>List of games</div>

    <table >
        <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
<#--            <th>Gamers</th>-->
            <th>System</th>
            <th>Discord</th>
            <th>Date</th>
            <th>Registration</th>
        </tr>
        </thead>
        <tbody>

<#--        style="text-align: center"-->

        <#list games as game>
            <tr>
                <td style="text-align: center">${game.name}</td>
                <td style="text-align: center">${game.description}</td>
<#--                <td >${game.getSubscribers().size()}</td>-->
                <td style="text-align: center">${game.system}</td>
                <td style="text-align: center">${game.discord}</td>
                <td style="text-align: center">${game.date}</td>
                <td style="text-align: center">
                    <form action="/note" method="post">
                        <input type="hidden" name="game" value="${game.name}"/>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-primary ml-2 mt-2" name="regist">Click</button>
                    </form>
                    </td>

            </tr>
        <#else>
            No games
        </#list>
        </tbody>
    </table>

<br>
    <#list userChannel.roles as role>
        <#if role  = "MASTER">
<h5>Add new game</h5>
<div class="form-row align-items-center mt-3">
<form action="/add" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>



        <div class="col-auto my-1">
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">System: </label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="system" value="">
                <option selected>Game</option>
                <option>DUNGEONSANDDRAGONS</option>
                <option>WARHAMMER</option>
                <option>CTHULHU</option>
            </select>
        </div>

        <div class="col-auto my-1">
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Game name: </label>
            <div class="col-sm-5">
            <input type="text" name="name" class="form-control"/>
            </div>
        </div>

        <div class="col-auto my-1">
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Description: </label>
            <div class="col-sm-5">
            <input type="text" name="description" class="form-control"/>
            </div>
        </div>

        <div class="col-auto my-1">
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Discord: </label>
            <div class="col-sm-5">
            <input type="text" name="discord" class="form-control"/>
            </div>
        </div>

        <div class="col-auto my-1">
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Date: </label>
            <div class="col-sm-5">
            <input type="date" name="date" class="form-control"/>
            </div>
        </div>

        <div class="col-auto my-1">
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Time: </label>
            <div class="col-sm-5">
            <input type="time" name="time" class="form-control"/>
            </div>
        </div>

        <button type="submit" class="btn btn-primary ml-2 mt-2">Create</button>

    </div>
</form>
        </#if>
    </#list>

</@c.page>