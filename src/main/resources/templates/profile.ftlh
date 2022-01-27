<#import "parts/common.ftlh" as c>
<@c.page>
<#--    <property name="hibernate.enable_lazy_load_no_trans" value="true"/>-->
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

<#--    <#if games.size() != 0>-->

    <table >
        <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
           <th>Gamers</th>
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
                <td >${game.gamerValue()}</td>
                <td style="text-align: center">${game.system}</td>
                <td style="text-align: center">${game.discord}</td>
                <td style="text-align: center">${game.date}</td>
                <td style="text-align: center">
                    <form action="/unsub" method="post">
                        <input type="hidden" name="game" value="${game.name}"/>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-primary ml-2 mt-2" name="unsub">Unsub</button>
                    </form>
                </td>

            </tr>
        <#else>
            No games
        </#list>
        </tbody>
    </table>

<#--    </#if>-->




</@c.page>