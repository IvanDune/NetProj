<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>
        <@l.logout/>
    </div>

    <div><h2>Имя первого мастера</h2></div>
    <div><h4>Описание первого мастера</h4></div>

    <#list messages as message>
        <#if message.number = 1>
        <div>
        <span>${message.text}</span>
        <strong>${message.getAuthorName()}</strong>
        </div>
        </#if>
    </#list>

    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="number" value="1"/>
        <div><input type="text" name="mess" placeholder="Enter your message"/></div>
        <button type="submit">Send</button>
    </form>

    <div><h2>Имя второго мастера</h2></div>
    <div><h4>Описание второго мастера</h4></div>

    <#list messages as message>
        <#if message.number = 2>
            <div>
                <span>${message.text}</span>
                <strong>${message.getAuthorName()}</strong>
            </div>
        </#if>
    </#list>

    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="number" value="2"/>
        <div><input type="text" name="mess" placeholder="Enter your message"/></div>
        <button type="submit">Send</button>
    </form>

    <div><h2>Имя третьего мастера</h2></div>
    <div><h4>Описание третьего мастера</h4></div>

    <#list messages as message>
        <#if message.number = 3>
            <div>
                <span>${message.text}</span>
                <strong>${message.getAuthorName()}</strong>
            </div>
        </#if>
    </#list>

    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="number" value="3"/>
        <div><input type="text" name="mess" placeholder="Enter your message"/></div>
        <button type="submit">Send</button>
    </form>

    <div><h2>Имя четвертого мастера</h2></div>
    <div><h4>Описание четвертого мастера</h4></div>

    <#list messages as message>
        <#if message.number = 4>
            <div>
                <span>${message.text}</span>
                <strong>${message.getAuthorName()}</strong>
            </div>
        </#if>
    </#list>

    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="number" value="4"/>
        <div><input type="text" name="mess" placeholder="Enter your message"/></div>
        <button type="submit">Send</button>
    </form>

    <a href="/main">Here our main page</a>
    <p>
        <a href="/calendar">Here our calendar</a>
    </p>


</@c.page>