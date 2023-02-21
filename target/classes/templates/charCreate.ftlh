<#import "parts/common.ftlh" as c>
<@c.page>
<#--    <input type="text" name="charName" class="form-control" placeholder="Name"/>-->

    <#list charEns as charEn>
        <br> ${charEn}
        <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="${charEn}" value="">
        <option selected>0</option>
        <#list characteristics as characteristic>
            <option>${characteristic}</option>
        </#list>
        </select>
    </#list>





    <div> Выберете свою расу</div>
    <select class="custom-select mr-sm-2" id="raceSelect" name="race" value="" onchange="foo()" >
        <option selected>Races</option>
        <#list races as race>
            <option>${race.getName()}</option>
        </#list>
    </select>

    <div class="result"></div>

    <script>
        var races = [<#list races as race>${race}, </#list>]
        function foo()
        {
            //console.log()(races.find()
            let raceSelectEl = document.getElementById('raceSelect')
            console.log(raceSelectEl.value)
            races.forEach(el){
                if (el.getName() == raceSelectEl.value){
                    console.log(el.getDescription())
                }
        }

            // console.log(races.length)
<#--            let races = '${races}'-->
<#--            // races.forEach(r => {console.log(r.getName())})-->
<#--&lt;#&ndash;            <#list races as race>&ndash;&gt;-->
<#--&lt;#&ndash;                <#if race.getName() = el.value>&ndash;&gt;-->
<#--&lt;#&ndash;            </#list>&ndash;&gt;-->

<#--            &lt;#&ndash;console.log('${}')&ndash;&gt;-->
        }


    </script>




<#--    <script>const selectElement = document.querySelector('.race');-->

<#--            selectElement.addEventListener('change', (event) => {-->
<#--                const result = document.querySelector('.result');-->
<#--                result.textContent = `${event.target.value}`;-->
<#--            });-->
<#--    </script>-->








    <div> Выберете свой класс
        <select class="custom-select mr-sm-2" id="classSelect" name="class" value="">
            <option selected>Classes</option>
            <#list clazzes as clazz>
                <option>${clazz.getName()}</option>
            </#list>
        </select>
    </div>










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
</@c.page>