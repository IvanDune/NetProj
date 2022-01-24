<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
    <a class="navbar-brand ml-5">DiceHead</a>
<#--    Отступ от левого края-->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main">Main</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/calendar">Calendar</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/master">Masters</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/profile">Profile</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>
            </#if>
        </ul>

        <div class="navbar-text">${name}</div>
        <@l.logout />

    </div>
</nav>