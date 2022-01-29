<#include "security.ftlh">
<#macro login path isRegisterForm>

    <form action="${path}" method="post">

        <div class="form-group">
            <label class="col-sm-2 col-form-label col-form-label-sm"> User Name : </label>
            <div class="col-sm-5">
            <input type="text" name="username"class="form-control" placeholder="Login"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 col-form-label col-form-label-sm"> Password: </label>
            <div class="col-sm-5">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
            </div>
        </div>

        <#if path == "/registration">

            <div class="form-group">
                <label class="col-sm-2 col-form-label col-form-label-sm"> Nickname: </label>
                <div class="col-sm-5">
                <input type="text" name="nickname" class="form-control" placeholder="Nickname"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 col-form-label col-form-label-sm"> Email: </label>
                <div class="col-sm-5">
                <input type="text" name="email" class="form-control" placeholder="Email"/>
            </div>
            </div>
        </#if>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <#if !isRegisterForm><div class="mt-3"><a  href = "/registration">Add new user</a></div></#if>
        <button class="btn btn-primary mt-3" type="submit"><#if isRegisterForm>Create<#else>Sign In</#if></button>

    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit"><#if user??>Sign Out<#else>Log In</#if></button>
<#--        Не работает изменение кнопки-->
    </form>
</#macro>