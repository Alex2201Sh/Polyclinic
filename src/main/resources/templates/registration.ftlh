<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="mb-1">Добавление нового пользователя</div>
    <br>
    ${message?ifExists}
    <br>
    <@l.login "/registration" true />
</@c.page>