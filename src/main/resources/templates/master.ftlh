<#import "parts/common.ftlh" as c>
<@c.page>
    <h3><font color="#dc143c"> ${noMessage!""}</font></h3>

    <div class="container">
    <div class="row">
    <div class="col-sm">
    <div><h3>Максим Резник (Mr. Lampa)</h3></div>
    <div class="col-auto my-1">
    <div class="col-sm-8"><h6><p class="text-justify">Большинство игр на сервере проходили под ведением этого мастера.
            Собрав вокруг себя группу почетателей Максим каждую неделю проводит
            ваншоты, привлекая все больше игроков в своей яркий и продуманный мир.
            Открыв наше расписание в с полной уверенностью сможете найти одну-две
                игры Mr. Lampa.</p></h6></div></div>
        <img src="https://sun9-44.userapi.com/impg/NrTB_n_dghUwB0ehqP4gEC9stN-objuybLhedg/XLzZEyyoX3g.jpg?size=720x720&quality=96&sign=3aa57fc0408e37495d643aa888fff5bc&type=album" height="400" width="400">

        <h5>Средняя оценка мастера: ${grade1!""}</h5>

    <h5>Отзывы:</h5>
        <div class="col-sm-8 mb-5"><h6><p class="text-justify">
    <#list messages as message>
        <#if message.number = 1>
        <div>
            <strong>${message.getAuthor()}</strong>
            <span>${message.text}</span>
        </div>
        </#if>
    </#list>
                </div>



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

        <div class="mt-5"><h3>Никита Шишкин (Шишак)</h3></div>
        <div class="col-auto my-1">
            <div class="col-sm-8"><h6><p class="text-justify">Мастер, который поможет погрузиться в атмосферу фэнтезийного мира
                        Dungeons & Dragons и многое расскажет, о его тайнах, особенностях, полетической структуре и правилах.</p></h6></div></div>
        <img src="https://sun9-8.userapi.com/impg/W5Sx0eNF4NIULgvdNHZzxy5xdGftokkfmc3clw/Nw9YSIgSjlI.jpg?size=1439x1439&quality=95&sign=f47581c90468b57cfabb76826704c189&type=album" height="400" width="400">

        <h5>Средняя оценка мастера: ${grade2!""}</h5>


    <h5>Отзывы:</h5>
        <div class="col-sm-8 mb-5"><h6><p class="text-justify">
    <#list messages as message>
        <#if message.number = 2>
            <div>
                <strong>${message.getAuthor()}</strong>
                <span>${message.text}</span>
            </div>
        </#if>
    </#list>
                </div>
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
            <div><h3>Дюнин Иван (Хозяин Таверны)</h3></div>
            <div class="col-auto my-1">
                <div class="col-sm-8"><h6><p class="text-justify">Мастер с 4-летним стажем, обладающий познаниями в более 10 системах.
                            За его плечами лежит не мало модулей и квестов, побежденных драконов и разгаданных тайн. Если вы жаждите настоящего темного фэнтези, то
                            обращайтесь к нему. Не прогадаете!</p></h6></div></div>
            <img src="https://sun9-63.userapi.com/impg/Dm2K0vrHRZplvTgMluPTdxvMksSivirN-VO0mQ/a3AMROJu-i8.jpg?size=1099x1099&quality=95&sign=989e9d26d12987eda45f564540292232&type=album" height="400" width="400">

            <h5>Средняя оценка мастера: ${grade3!""}</h5>

    <h5>Отзывы:</h5>
            <div class="col-sm-8 mb-5"><h6><p class="text-justify">
    <#list messages as message>
        <#if message.number = 3>
            <div>
                <strong>${message.getAuthor()}</strong>
                <span>${message.text}</span>
            </div>
        </#if>
    </#list>
</div>
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
        <input type="number" min="1" max="10" name="gr" required>
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
            <img src="https://sun9-66.userapi.com/impg/5mbJQg2H2L6b579e8kELBXjRPyLE7vtUJhYUXw/UIqGjdZO_m4.jpg?size=1637x1638&quality=95&sign=a98d29e6e3859128334d418fde963c06&type=album" height="400" width="400">

            <h5>Средняя оценка мастера: ${grade4!""}</h5>

    <h5>Отзывы:</h5>
            <div class="col-sm-8 mb-5"><h6><p class="text-justify">
    <#list messages as message>
        <#if message.number = 4>
            <div>
                <strong>${message.getAuthor()}</strong>
                <span>${message.text}</span>
            </div>
        </#if>
    </#list>
                    </div>

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