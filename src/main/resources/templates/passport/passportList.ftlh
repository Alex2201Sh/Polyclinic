<#import "../parts/common.ftlh" as c>

<@c.page>
    Список пасспортов

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Username</th>
            <th scope="col">id</th>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
        </tr>
        </thead>
        <tbody>
        <#list passports as passport>
            <tr>
                <#if passport.isPassportHasOwner(passport)>
                    <td scope="row">${passport.getUser().getUsername()}</td>
                <#else>
                    <td></td>
                </#if>
                <td scope="row">${passport.id}</td>
                <td>${passport.firstName!''}</td>
                <td>${passport.surname!''}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>