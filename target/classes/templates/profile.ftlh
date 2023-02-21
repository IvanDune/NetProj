<#import "parts/common.ftlh" as c>
<@c.page>
<#--    <property name="hibernate.enable_lazy_load_no_trans" value="true"/>-->
    <h3><font color="#dc143c">${message!""}</font></h3>
    <h4>${user.nickname}, it's your profile </h4>
    <nav class="navbar navbar-dark bg-light col-sm-5">
        <div class="container-fluid">
        <div class="form-group col-md-6">
            <form action="profile" method="post">
                <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Nickname: </label>
                <div class="col-sm-5">
                    <input type="text" name="nickname" value="${nickname}"></label>
                </div>

                <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Email: </label>
                <div class="col-sm-5">
                <input type="text" name="email" value="${email}"></label>
                </div>
                <input type="hidden" value="${_csrf.token}" name = "_csrf">
                <button type="submit" class="btn btn-primary ml-2 mt-2">Save</button>
            </form>
        </div>
        </div>
    </nav>


    <#if user.gameValue()!=0>
    <table class="table table-hover" >
        <thead>
        <tr>
            <th class="align-middle text-center">Name</th>
            <th class="align-middle text-center">Description</th>
            <th class="align-middle text-center">Gamers</th>
            <th class="align-middle text-center">System</th>
            <th class="align-middle text-center">Discord</th>
            <th class="align-middle text-center">Date</th>
            <th class="align-middle text-center">Registration</th>
        </tr>
        </thead>
        <tbody>



        <#list games as game>
            <tr>
                <td class="align-middle text-center">${game.name}</td>
                <td class="align-middle text-center">${game.description}</td>
                <td class="align-middle text-center">${game.gamerValue()}</td>
                <td class="align-middle text-center">${game.system}</td>
                <td class="align-middle text-center">${game.discord}</td>
                <td class="align-middle text-center">${game.date}</td>
                <td class="align-middle text-center">
                    <form action="/unsub" method="post">
                        <input type="hidden" name="game" value="${game.name}"/>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-outline-primary ml-2 mt-2" name="unsub">Unsub</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    </#if>

    <#if user.characterValue()!=0>
    <table class="table table-hover" >
        <thead>
        <tr>
            <th class="align-middle text-center">Name</th>
            <th class="align-middle text-center">Level</th>
            <th class="align-middle text-center">Class</th>
            <th class="align-middle text-center">Race</th>
            <th class="align-middle text-center">Description</th>
            <th class="align-middle text-center">Delete</th>
        </tr>
        </thead>
        <tbody>



        <#list characters as character>
            <tr>
            <td class="align-middle text-center">${character.name}</td>
            <td class="align-middle text-center">${character.level}</td>
            <td class="align-middle text-center">${character.className}</td>
            <td class="align-middle text-center">${character.raceName}</td>
            <td class="align-middle text-center"><a href="/${user.id}/${character.id}">Description</a></td>
            <td class="align-middle text-center">
                <form action="/deleteCharacter" method="post">
                        <input type="hidden" name="characterId" value="${character.getId()}"/>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-outline-primary ml-2 mt-2" name="unsub">Delete</button>
                </form>
            </td>
            </tr>
        </#list>
        </tbody>
    </table>

    </#if>
</@c.page>