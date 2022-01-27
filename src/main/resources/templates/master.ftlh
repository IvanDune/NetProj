<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>



    <div><h2>Имя первого мастера</h2></div>
    <div><h4>Описание первого мастера</h4></div>


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
            <div class="col-sm-5">
                <input type="text" name="mess" class="form-control sm-3" placeholder="Enter your message"/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary ml-2 mt-2">Create</button>
    </form>
        </div>
    </#if>


    <div><h2>Имя второго мастера</h2></div>
    <div><h4>Описание второго мастера</h4></div>


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
            <div class="col-sm-5">
                <input type="text" name="mess" class="form-control sm-3" placeholder="Enter your message"/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary ml-2 mt-2">Create</button>
    </form>
    </div>
    </#if>

    <div><h2>Имя третьего мастера</h2></div>
    <div><h4>Описание третьего мастера</h4></div>


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
            <div class="col-sm-5">
                <input type="text" name="mess" class="form-control sm-3" placeholder="Enter your message"/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary ml-2 mt-2">Create</button>
    </form>
    </div>
    </#if>

    <div><h2>Имя четвертого мастера</h2></div>
    <div><h4>Описание четвертого мастера</h4></div>


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
            <div class="col-sm-5">
                <input type="text" name="mess" class="form-control sm-3" placeholder="Enter your message"/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary ml-2 mt-2">Create</button>
    </form>
    </div>
    </#if>

</@c.page>