<#import "parts/common.ftlh" as c>

<@c.page>


    <div class=" col-sm col-auto my-1 ">
        <div class="col-sm-5">
            <h5>Class name: </h5>
            <h6><p class="text-justify">${clazz.name}</p></h6>
            <h5>Description:</h5>
            <h6><p class="text-justify"> ${clazz.description} </p></h6>
            <h5>Hit dice: </h5>
            <h6><p class="text-justify"> d${clazz.hitDice} </p></h6>
            <h5>Proficiencies: </h5>
            <h6>Armor: </h6>
            <#list clazz.pro_armor as pA>
                <h6><p class="text-justify"> ${pA.name()}: ${pA.equals()} </p></h6>
            </#list>
            <h6>Saves: </h6>
            <#list clazz.pro_saves as pSa>
                <h6><p class="text-justify"> ${pSa.name()}: ${pSa.equals()} </p></h6>
            </#list>
            <h6>Skills: </h6>
            <#list clazz.pro_skills as pSs>
                <h6><p class="text-justify"> ${pSs.name()}: ${pSs.equals()} </p></h6>
            </#list>
            <h6>Weapon: </h6>
            <#list clazz.pro_weapon as pW>
                <h6><p class="text-justify"> ${pW.name()}: ${pW.equals()} </p></h6>
            </#list>
            <h5>Abilities: </h5>
            <#list clazz.classAbilitiesSet as ability>
                <h6><p class="text-justify"> ${ability.name}: ${ability.description}</p></h6>
            </#list>
            <form method="post" action="goEnd">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <input type="hidden" name="classId" value="${clazz.getId()}"/>
                <select class="form-select" aria-label="Default select example" name="level">
                    <option selected>Choose level</option>
                    <#list 1..20 as lvl>
                        <option value=${lvl}>${lvl}</option>
                    </#list>
                </select>
                <button type="submit" class="btn btn-outline-primary ml-2 mt-2" name="goEnd" value="${clazz.getId()}">Choose</button>
<#--                <#if raceVariety==0>-->
<#--                    <button type="submit" class="btn btn-outline-primary ml-2 mt-2" name="goClazz" value="${race.getId()}">Choose</button>-->
<#--                <#else>-->
<#--                    <h5>Variety: </h5>-->
<#--                    <#list race.raceVarietiesSet as variety>-->
<#--                        <h5>Variety name: </h5>-->
<#--                        <h6><p class="text-justify"> ${variety.name} </p></h6>-->
<#--                        <h5>Variety buffs: </h5>-->
<#--                        <#list variety.buffs as buff>-->
<#--                            <h6><p class="text-justify"> ${buff.name()}: ${buff.equals()}</p></h6>-->
<#--                        </#list>-->
<#--                        <h5>Variety abilities: </h5>-->
<#--                        <#list variety.raceAbilitiesSet as ability>-->
<#--                            <h6><p class="text-justify"> ${ability.name}: ${ability.description}</p></h6>-->
<#--                        </#list>-->
<#--                        <button type="submit" class="btn btn-outline-primary ml-2 mt-2" name="goClazz" value="${variety.getId()}">Choose</button>-->
<#--                    </#list>-->
<#--                </#if>-->
            </form>
        </div>
    </div>

</@c.page>