<#import "parts/common.ftlh" as c>

<@c.page>

<h1>Welcome to our calendar</h1>

    <h4><font color="#dc143c">${messageEr!""}</font></h4>
    <h4><font color="#006400">${message!""}</font></h4>

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


<div><h4>List of games</h4></div>
    <#if gameSize!=0>
    <table class="table table-hover">
        <thead>
        <tr>
            <th class="align-middle text-center" >Name</th>
            <th class="align-middle text-center" >Description</th>
            <th class="align-middle text-center" >Gamers</th>
            <th class="align-middle text-center" >System</th>
            <th class="align-middle text-center" >Discord</th>
            <th class="align-middle text-center" >Date</th>
            <th class="align-middle text-center" >Registration</th>
        </tr>
        </thead>
        <tbody>

        <#list games as game>
            <tr>
                <td class="align-middle text-center" >${game.name}</td>
                <td class="align-middle text-center" ><a href="/calendar/${game.id}">Description</a></td>
                <td class="align-middle text-center" >${game.gamerValue()}</td>
                <td class="align-middle text-center" >${game.system}</td>
                <td class="align-middle text-center" >${game.discord}</td>
                <td class="align-middle text-center" >${game.date}</td>
                <td class="align-middle text-center" >
                    <form action="/note" method="post">
                        <input type="hidden" name="game" value="${game.name}"/>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-outline-primary ml-2 mt-2" name="regist">Click</button>
                    </form>
                    </td>
                <td class="align-middle text-center" >
                    <#list userChannel.roles as role>
                        <#if role  = "ADMIN">
                            <form action="/delete" method="post">
                                <input type="hidden" name="game" value="${game.name}"/>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <button type="submit" class="btn btn-outline-danger ml-2 mt-2" name="delete">Delete</button>
                            </form>
                        </#if>
                    </#list>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
            <#else>
                <div class="alert alert-primary col-sm-5" role="alert">
                    There are no games!
                </div>

        </#if>



    <#list userChannel.roles as role>
        <#if role  = "MASTER">
            <h4><font color="#dc143c">${messageError!""}</font></h4>

            <br><h5>Add new game</h5>
<div class="form-row align-items-center mt-3">
<form action="/add" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="col-auto my-1">
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">System: </label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="system" value="">
                <option selected>Game</option>
                <option>DUNGEONS_AND_DRAGONS</option>
                <option>WARHAMMER</option>
                <option>CTHULHU</option>
                <option>CORIOLIS</option>
                <option>WITCHER</option>
                <option>BLADES_IN_THE_DARK</option>
                <option>ALIEN</option>
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

        <button type="submit" class="btn btn-primary ml-2 mt-2 mb-2">Create</button>
</form>
    </div>

        </#if>
    </#list>


</@c.page>