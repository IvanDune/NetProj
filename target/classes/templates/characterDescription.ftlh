<#import "parts/common.ftlh" as c>
<@c.page>
    <form method="post" action="saveCharacter">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
<h4>Name: </h4>
    <h6><p class="text-justify">${character.name}</p></h6>

    <h5>Race name: </h5>
        <h6><p class="text-justify">${race.name}</p></h6>
        <h5>Race description:</h5>
        <h6><p class="text-justify"> ${race.description} </p></h6>
        <h5>Speed: </h5>
        <h6><p class="text-justify"> ${race.speed} </p></h6>
        <h5>Age: </h5>
        <h6><p class="text-justify"> ${race.age} </p></h6>
        <h5>Race buffs: </h5>
        <#list race.buffs as buff>
            <h6><p class="text-justify"> ${buff.name()}: ${buff.equals()}</p></h6>
        </#list>
        <h5>Race abilities: </h5>
        <#list race.raceAbilitiesSet as ability>
            <h6><p class="text-justify"> ${ability.name}: ${ability.description}</p></h6>
        </#list>


        <h5>Class name: </h5>
        <h6><p class="text-justify">${clazz.name}</p></h6>
        <h5>Class description:</h5>
        <h6><p class="text-justify"> ${clazz.description} </p></h6>
        <h5>Level:</h5>
        <h6><p class="text-justify"> ${character.getLevel()} </p></h6>
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
        <h5>Class abilities: </h5>
        <#list clazz.classAbilitiesSet as ability>
            <h6><p class="text-justify"> ${ability.name}: ${ability.description}</p></h6>
        </#list>
</@c.page>