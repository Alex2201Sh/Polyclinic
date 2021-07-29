<#import "parts/common.ftlh" as c>
<#import "parts/security.ftlh" as s>

<@c.page>

    <#if s.isAdmin>
        <a href="/admin/users">Список пользователей</a>
        <br>
        <a href="/admin/passports">Список пасспортов</a>
    </#if>

</@c.page>