<#import "parts/common.ftlh" as c>
<#import "parts/security.ftlh" as s>

<@c.page>

    <#if s.isAdmin>
        <p>
            <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#userList"
                    aria-expanded="false" aria-controls="userList">Пользователи
            </button>
        </p>
        <div class="collapse" id="userList">
            <div class="card card-body">
                <table class="table table-hover table-sm table-responsive">
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
                    <#list users as user>
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
                                </#if>
                            </td>
                            <td></td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
        <br>

        <p>
            <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#passportList"
                    aria-expanded="false" aria-controls="passportList">Паспорта
            </button>
        </p>
        <div class="collapse" id="passportList">
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
                    <#list passports as passport>
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
        </div>
        <br>

    <#else>
        <div>Доступ только для Администратора</div>
    </#if>

</@c.page>