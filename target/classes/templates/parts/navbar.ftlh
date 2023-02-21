<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="padding: 0.5rem 2rem">

    <a class="navbar-brand" >DiceHead</a>
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
                <a class="nav-link" href="/calendar">Calendar</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/master">Masters</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/profile">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/character">Character</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/game">Game</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="character/create">Create</a>
            </li>

            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>
            </#if>
        </ul>
    </div>

    <form class="form-inline mr-2 my-lg-0 ">

            <div class="navbar-text yx-3" style="margin-right: 0.5rem"><#if user??>${name}<#else>Please, login</#if></div>

    </form>

    <@l.logout/>




</nav>