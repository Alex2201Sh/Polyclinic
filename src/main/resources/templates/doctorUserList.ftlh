<#import "parts/common.ftlh" as c>
<#import "parts/security.ftlh" as s>


<@c.page>
    <table class="table">
        <thead>
        <tr>
            <th>Пациент</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <div>Пациенты</div>
        <#list patients as user>
            <tr>
                <td>${user.passport.surname!''}</td>
                <td>${user.passport.firstName!''}</td>
                <td></td>
            </tr>
        </#list>
        </tbody>
    </table>

    <table class="table">
        <thead>
        <tr>
            <th>Гость</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <div>Гости</div>
        <#list guests as user>
            <tr>
                <td>${user.username}</td>
                <td></td>
                <td></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>