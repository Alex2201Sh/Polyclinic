<#import "parts/common.ftlh" as c>
<#import "parts/pager.ftlh" as p>

<@c.page>
    Список пользователей
    <br>
    <#if page.totalPages gt 1>
        <@p.pager url page />
    </#if>
    <div class="card card-body">
        <table class="table table-hover table-responsive">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th>Логин</th>
                <th>email</th>
                <th>Номер телефона</th>
                <th>Роль</th>
                <th>id Паспорта</th>
                <th>id Мед.карты</th>
                <th>Данные доктора <br> (если пользователь доктор)</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <#list page.content as user>
                <tr>
                    <th scope="row">
                        <a href="/admin/users/${user.id}">${user.id}</a>
                    </th>
                    <td>${user.username}</td>
                    <td>${user.email!''}</td>
                    <td>${user.phoneNumber!''}</td>
                    <td>${user.role}</td>
                    <td><#if user.isUserHasPassport(user)>
                            ${user.passport.id}
                        </#if>
                    </td>
                    <td><#if user.isUserHasMedicalCard(user)>
                            ${user.medicalCard.id}
                        </#if>
                    </td>
                    <td><#if user.isUserADoctor()>
                            id:${user.doctor.id}
                            кабинет:${user.doctor.cabinet}
                            <br>
                            отделение:${user.doctor.department}
                            <br>
                            должность:${user.doctor.position}
                        <#else>
                            <a href="/admin/users/${user.id}">${user.id}</a>
                        </#if>
                    </td>
                    <td></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <#if page.totalPages gt 1>
        <@p.pager url page />
    </#if>
</@c.page>