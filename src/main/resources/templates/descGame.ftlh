<#import "parts/common.ftlh" as c>
<@c.page>


<#--    <nav class="navbar navbar-dark bg-light col-sm-5">-->
    <div class=" col-sm col-auto my-1 ">
    <div class="col-sm-5">
        <h5>Название игры: </h5>
        <h6><p class="text-justify">${game.name}</p></h6>
        <h5>Описание:</h5>
        <h6><p class="text-justify"> ${game.description} </p></h6>
        <h5>Gamers: </h5>
        <h6><p class="text-justify"> ${game.gamerValue()} </p></h6>
        <h5>System: </h5>
        <h6><p class="text-justify"> ${game.system} </p></h6>
        <h5>Discord: </h5>
        <h6><p class="text-justify"> ${game.discord} </p></h6>
        <h5>Date: </h5>
        <h6><p class="text-justify"> ${game.date} </p></h6>
            <form action="/note" method="post">
                <input type="hidden" name="game" value="${game.name}"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-outline-primary ml-2 mt-2" name="regist">Click</button>
            </form>

    </div>
    </div>

</@c.page>