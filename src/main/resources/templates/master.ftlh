<#import "parts/common.ftlh" as c>

<@c.page>
    <h3><font color="#dc143c"> ${noMessage!""}</font></h3>

    <div class="container">
    <div class="row">
    <div class="col-sm">
    <div><h3>Максим Резик (Mr. Lampa)</h3></div>
    <div class="col-auto my-1">
    <div class="col-sm-8"><h6><p class="text-justify">Большинство игр на сервере проходили под ведением этого мастера.
            Собрав вокруг себя группу почетателей Максим каждую неделю проводит
            ваншоты, привлекая все больше игроков в своей яркий и продуманный мир.
            Открыв наше расписание в с полной уверенностью сможете найти одну-две
                игры Mr. Lampa.</p></h6></div></div>
<#--    <img src="https://sun9-53.userapi.com/impg/c857328/v857328805/1ef16d/Xk8gMPD6GaQ.jpg?size=762x1080&quality=96&sign=820d160d8ac21caa6df32fc865f617dd&type=album">-->
<#--        <iframe width="560" height="315" src="https://www.youtube.com/embed/AdLXmE4rjy4?autoplay=1&mute=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>        <h5>Средняя оценка мастера: ${grade1!""}</h5>-->
    <h5>Отзывы:</h5>
    <#list messages as message>
        <#if message.number = 1>
        <div>
            <strong>${message.getAuthor()}</strong>
            <span>${message.text}</span>
        </div>
        </#if>
    </#list>



    <#if exist1 = false>
        <div>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="number" value="1"/>
        <div class="col-auto my-1">
            <div class="col-sm-8">
                <input type="text" name="mess" class="form-control sm-3" placeholder="Enter your message"/>
            </div>
        </div>
        Введите вашу оценку мастера от 1 до 10:
        <input type="number" min="1" max="10" name="gr">
        <button type="submit" class="btn btn-primary ml-2 mt-1">Create</button>
    </form>
        </div>
    </#if>


    <div class="mt-5"><h3></h3></div>
    <div><h6></h6></div>
    <h5>Средняя оценка мастера: ${grade2!""}</h5>

    <h5>Отзывы:</h5>
    <#list messages as message>
        <#if message.number = 2>
            <div>
                <strong>${message.getAuthor()}</strong>
                <span>${message.text}</span>
            </div>
        </#if>
    </#list>

    <#if exist2 = false>
        <div>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="number" value="2"/>
        <div class="col-auto my-1">
            <div class="col-sm-8">
                <input type="text" name="mess" class="form-control sm-3" placeholder="Enter your message"/>
            </div>
        </div>
        Введите вашу оценку мастера от 1 до 10:
        <input type="number" min="1" max="10" name="gr">
        <button type="submit" class="btn btn-primary ml-2 mt-1">Create</button>
    </form>
    </div>
    </#if>
    </div>
        <div class="col-sm">
    <div><h3>Никита Шишкин (Шишак)</h3></div>
    <div><h4>Описание третьего мастера</h4></div>
    <h5>Средняя оценка мастера: ${grade3!""}</h5>

    <h5>Отзывы:</h5>
    <#list messages as message>
        <#if message.number = 3>
            <div>
                <strong>${message.getAuthor()}</strong>
                <span>${message.text}</span>
            </div>
        </#if>
    </#list>

    <#if exist3 = false>
        <div>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="number" value="3"/>
        <div class="col-auto my-1">
            <div class="col-sm-8">
                <input type="text" name="mess" class="form-control sm-3" placeholder="Enter your message"/>
            </div>
        </div>
        Введите вашу оценку мастера от 1 до 10:
        <input type="number" min="1" max="10" name="gr">
        <button type="submit" class="btn btn-primary ml-2 mt-1">Create</button>
    </form>
    </div>
    </#if>


    <div class="mt-5"><h3>Василий Салов (Рагнар)</h3></div>
    <div class="col-auto my-1">
    <div class="col-sm-8"><h6><p class="text-justify">На сервере DiceHead игры Рагнара не проходят, однако вы всегда
            можете ознакомиться с его лекциями, которые еженедельно выкладываются
            на нашем канале YouTube. За свои 7 выступлений Василий успел поделиться
            с людьми полезными советами о создании мира, домашних правил и
            поговорить о выгорании игроков и мастеров.</p></h6></div></div>
    <h5>Средняя оценка мастера: ${grade4!""}</h5>

    <h5>Отзывы:</h5>
    <#list messages as message>
        <#if message.number = 4>
            <div>
                <strong>${message.getAuthor()}</strong>
                <span>${message.text}</span>
            </div>
        </#if>
    </#list>

    <#if exist4 = false>
        <div>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="number" value="4"/>
        <div class="col-auto my-1">
            <div class="col-sm-8">
                <input type="text" name="mess" class="form-control sm-3" placeholder="Enter your message"/>
            </div>
        </div>
        Введите вашу оценку мастера от 1 до 10:
        <input type="number" min="1" max="10" name="gr">
        <button type="submit" class="btn btn-primary ml-2 mt-1">Create</button>
    </form>
    </div>
    </#if>
    </div>
    </div>
    </div>
</@c.page>