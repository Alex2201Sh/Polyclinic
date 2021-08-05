<#import "parts/common.ftlh" as c>
<#import "parts/security.ftlh" as s>

<@c.page>

    <#if !s.known>
        <h5>Привет, гость</h5>
        <div>Приложение iPolyclinic</div>
        <a href="/login">Войти</a>
        <br>
        <a href="/registration">Добавить пользователя</a>
        <br>
    </#if>

</@c.page>