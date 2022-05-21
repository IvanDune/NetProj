<#import "parts/common.ftlh" as c>

<@c.page>


<div class=" col-sm col-auto my-1 ">
    <div class="col-sm-5">
        <h5>Race name: </h5>
        <h6><p class="text-justify">${race.name}</p></h6>
        <h5>Description:</h5>
        <h6><p class="text-justify"> ${race.description} </p></h6>
        <h5>Speed: </h5>
        <h6><p class="text-justify"> ${race.speed} </p></h6>
        <h5>Age: </h5>
        <h6><p class="text-justify"> ${race.age} </p></h6>
        <h5>Buffs: </h5>
        <#list race.buffs as buff>
            <h6><p class="text-justify"> ${buff.getName()}: ${buff.getMod()}</p></h6>
        </#list>
        <h5>Abilities: </h5>
        <#list race.raceAbilitiesSet as ability>
            <h6><p class="text-justify"> ${ability.name}: ${ability.description}</p></h6>
        </#list>
        <form method="post" action="goClass">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="hidden" name="raceId" value="${race.getId()}"/>

            <#if raceVariety==0>
            <button type="submit" class="btn btn-outline-primary ml-2 mt-2" name="goClazz" value="${race.getId()}">Choose</button>
            <#else>
                <h5>Variety: </h5>
                <#list race.raceVarietiesSet as variety>
                    <h5>Variety name: </h5>
                    <h6><p class="text-justify"> ${variety.name} </p></h6>
                    <h5>Variety buffs: </h5>
                    <#list variety.buffs as buff>
                        <h6><p class="text-justify"> ${buff.getName()}: ${buff.getMod()}</p></h6>
                    </#list>
                    <h5>Variety abilities: </h5>
                    <#list variety.raceAbilitiesSet as ability>
                        <h6><p class="text-justify"> ${ability.name}: ${ability.description}</p></h6>
                    </#list>
                    <button type="submit" class="btn btn-outline-primary ml-2 mt-2" name="goClazz" value="${variety.getId()}">Choose</button>
                </#list>
        </#if>
        </form>
    </div>
</div>

</@c.page>