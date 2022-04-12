<#import "parts/common.ftlh" as c>
<@c.page>
    <h4><font color="#dc143c">${messageEr!""}</font></h4>

    <form method="post">
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