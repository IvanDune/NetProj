<#import "parts/common.ftlh" as c>
<@c.page>
    <h3><font color="#dc143c"> ${noMessage!""}</font></h3>

    <div class="container row col-sm">
    <#list masters as master>
        <#assign foo = false>
<#--        Перенести самый первый див класс за цикл, чтобы не было смещения-->
        <div>
            <h3>${master.getNickname()}</h3>
        </div>
        <div class="col-auto my-1">
            <div class="col-sm-8"><h5>Описание: </h5>
                <h6><p class="text-justify">${master.getDescription()!"Без описания"}</p></h6></div></div>
        <h5>Средняя оценка мастера: ${master.getGrade()!"0"}</h5>
        <h5>Отзывы: </h5>
        <div class="col-sm-8 mb-5"><h6><p class="text-justify">


        <#list master.getReviews() as review>
            <div>
                <strong>${review.getAuthor()}</strong>
                <span>${review.getMessage()}</span>
            </div>
            <#if review.getAuthor()=userChannel.getLogin()>
                <#assign foo = true>
            </#if>

        </#list>


        <#if foo = false>
        <div>
            <form method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <input type="hidden" name="masterLogin" value="${master.getLogin()}"/>
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
    </#list>
</@c.page>