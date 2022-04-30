<#import "parts/common.ftlh" as c>
<@c.page>
<form method="post" >
    <h5>Enter essence's name: </h5><input type="text" class="col-sm-5" name="nameEssence">
    <h5>Enter essence's HP: </h5><input type="number" min="-1" max="1000"class="col-sm-5" name="hpEssence">
    <h5>Enter essence's AC: </h5><input type="number" min="1" max="30" class="col-sm-5" name="acEssence">
    <h5>Enter essence's Initiative: </h5><input type="number" min ="1" max="30" class="col-sm-5" name="initEssence">
    <br><button type="submit" class="btn btn-primary ml-2 mt-1">Create</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
</form>

    <h4>Your battle</h4>
    <#if essencesSize != 0>
        <table class="table table-hover">
        <thead>
        <tr>
            <th class="align-middle text-center" >Name</th>
            <th class="align-middle text-center" >HP</th>
            <th class="align-middle text-center" >AC</th>
            <th class="align-middle text-center" >Init</th>
        </tr>
        </thead>
        <tbody>
        <#list essences as essence>
            <tr>
            <td class="align-middle text-center" >${essence.name}</td>
            <td class="align-middle text-center" >${essence.HP}</td>
            <td class="align-middle text-center" >${essence.baseAC}</td>
            <td class="align-middle text-center" >${essence.initiative}</td>
            </tr>

        </#list>
        </tbody>
        </table>
        <#else>
        No players
    </#if>

    <form method="post" action="game/refactor">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary ml-2 mt-1">Delete all</button>
    </form>

    <h4><font color="#dc143c">${messageEr!""}</font></h4>

    <form method="post" action="game/dice">
        <h6>Enter number of dice</h6>
        <div class="col-sm-8 my-1">
            <input type="number" min="1" name="numDice"  value="0">
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <br>

        <h6>Enter modifier</h6>
        <div class="col-sm-8 my-1">
            <input type="number" min="-20" max="20" name="modDice" value="0">
        </div>
        <select class="form-select" aria-label="Default select example" name="dice">
            <option selected>Choose dice</option>
            <option value="4">d4</option>
            <option value="6">d6</option>
            <option value="8">d8</option>
            <option value="10">d10</option>
            <option value="12">d12</option>
            <option value="20">d20</option>
            <option value="100">d100</option>
        </select>
        <button type="submit" class="btn btn-primary ml-2 mt-1">Create</button>

    </form>
    <h2>${answer!""}</h2>



</@c.page>