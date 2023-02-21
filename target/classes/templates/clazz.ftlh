<#import "parts/common.ftlh" as c>
<@c.page>
    <h3>Choose your class</h3>
    <table class="table table-hover">
        <thead>
        <tr>
            <th class="align-middle text-center" >Name</th>
            <th class="align-middle text-center" >Description</th>
            <th class="align-middle text-center" >Hit Dice</th>

        </tr>
        </thead>
        <tbody>
        <#list clazzes as clazz>
            <tr>
                <td class="align-middle text-center" >${clazz.name}</td>
                <td class="align-middle text-center" ><a href="/character/class/${clazz.id}">Description</a></td>
                <td class="align-middle text-center" >${clazz.hitDice}</td>


            </tr>
        </#list>
        </tbody>
    </table>

</@c.page>