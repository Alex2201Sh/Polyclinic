<#import "../parts/common.ftlh" as c>
<#import "../parts/pager.ftlh" as p>

<@c.page>

    <div>
        <form action="/admin" method="get">
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-outline-info btn-sm" type="submit">Назад</button>
                </div>
            </div>
        </form>
    </div>

    Список паспортов
    <br>
    <#if page.totalPages gt 1>
        <@p.pager url page />
    </#if>
    <div class="card card-body">
        <table class="table table-hover table-sm table-responsive">
            <thead>
            <tr>
                <th scope="col">Логин</th>
                <th>id паспорта</th>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Адрес</th>
                <th scope="col">Дата рождения</th>
                <th scope="col">Место рождения</th>
                <th scope="col">Дата выдачи</th>
                <th scope="col">Дата окончания срока действия</th>
                <th scope="col">Код органа выдавшего документ</th>
                <th scope="col">Национальность</th>
                <th scope="col">Номер паспорта</th>
                <th scope="col">Личный номер</th>
                <th scope="col">Пол</th>
            </tr>
            </thead>
            <tbody>
            <#list page.content as passport>
                <tr>
                    <th scope="row">
                        <a href="/admin/passports/${passport.id}">${passport.getUser().getUsername()}</a>
                    </th>
                    <td>${passport.id}</td>
                    <td>${passport.firstName!''}</td>
                    <td>${passport.surname!''}</td>
                    <td>${passport.address!''}</td>
                    <td>${passport.birthDate!''}</td>
                    <td>${passport.birthPlace!''}</td>
                    <td>${passport.dateOfIssue!''}</td>
                    <td>${passport.dateOfExpiry!''}</td>
                    <td>${passport.codeOfIssuingState!''}</td>
                    <td>${passport.nationality!''}</td>
                    <td>${passport.passportNumber!''}</td>
                    <td>${passport.personalNo!''}</td>
                    <td>${passport.sex!''}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <#if page.totalPages gt 1>
        <@p.pager url page />
    </#if>
</@c.page>