<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <h4>Enter your login and password, please.</h4>
    <@l.login "/login" false/>
</@c.page>