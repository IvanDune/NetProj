<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container row col-sm">
    <#list gameSystems as gameSystem>

        <h3>Название системы: ${gameSystem.getName()}</h3>
        <div class="col-auto my-1">
            <div class="col-sm-8"><h5>Описание: </h5>
                <h6><p class="text-justify">${gameSystem.getDescription()!"Без описания"}</p></h6></div></div>
        <h5>Кому подойдет: ${gameSystem.getComments()}</h5>
        <h5>Используемые кубы: ${gameSystem.getDices()}</h5>



    </#list>
        </div>
</@c.page>