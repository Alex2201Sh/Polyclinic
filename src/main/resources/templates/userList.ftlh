<#import "parts/common.ftlh" as c>
<#import "parts/security.ftlh" as s>


<@c.page>
Список пользователей

<table class="table">
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
        <th>Passport</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td>${user.role}</td>
        <td><a href="/admin/users/${user.id}">edit user profile</a></td>
        <#if user.isUserHasPassport(user)><td>${user.passport.id!''}</td></#if>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>