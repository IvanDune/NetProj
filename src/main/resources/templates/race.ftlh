<#import "parts/common.ftlh" as c>
<@c.page>
    <table class="table table-hover">
        <thead>
        <tr>
            <th class="align-middle text-center" >Name</th>
            <th class="align-middle text-center" >Description</th>
            <th class="align-middle text-center" >Age</th>
            <th class="align-middle text-center" >Speed</th>
        </tr>
        </thead>
        <tbody>
        <#list races as race>
            <tr>
                <td class="align-middle text-center" >${race.name}</td>
                <td class="align-middle text-center" ><a href="/character/race/${race.id}">Description</a></td>
                <td class="align-middle text-center" >${race.age}</td>
                <td class="align-middle text-center" >${race.speed}</td>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.page>