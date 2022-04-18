<#import "parts/common.ftlh" as c>
<@c.page>
    <h3>Hello, ${user.nickname}</h3>
    This is where your character creation begins.
   <br> Do you confirm your starting characteristics?
    <table class="table table-hover">
        <thead>
        <tr>
            <th class="align-middle text-center" >#</th>
            <th class="align-middle text-center" >Strength</th>
            <th class="align-middle text-center" >Dexterity</th>
            <th class="align-middle text-center" >Constitution</th>
            <th class="align-middle text-center" >Wisdom</th>
            <th class="align-middle text-center" >Intelligence</th>
            <th class="align-middle text-center" >Charisma</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">Characteristic</th>
        <#list characteristics as charact>
                <td class="align-middle text-center" >${charact}</td>
        </#list>
        </tr>
        <tr>
            <th scope="row">Modifier</th>
            <#list characteristicsMod as charactM>
            <td class="align-middle text-center" >${charactM}</td>
        </#list>
        </tr>
        </tbody>
    </table>

    <form method="post">
        <button type="submit" class="btn btn-outline-primary ml-2 mt-2" name="regen">ReGenerate</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>

    <form method="post" action="character/goRace">
        <button type="submit" class="btn btn-outline-primary ml-2 mt-2" name="goRace">Next</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</@c.page>