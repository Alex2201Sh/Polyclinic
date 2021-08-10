<#import "../parts/common.ftlh" as c>
<#import "../parts/security.ftlh" as s>


<@c.page>

    <div>
        <form action="/admin/users" method="get">
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-outline-info btn-sm" type="submit">Назад</button>
                </div>
            </div>
        </form>
    </div>

    <label>
        <h4>
            Редактор пользователя
        </h4>
    </label>
    <br>

    <div>
        <form action="/admin/users" method="post">

            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Логин:</label>
                            <div class="col-sm-4">
                                <input type="text" name="username" class="form-control" value="${user.username}"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Роль:</label>
                            <div class="col-sm-4">
                                <select class="custom-select" name="role">
                                    <#list roles as role>
                                        <option <#if role == user.role>selected</#if>
                                                value="${role}">${role}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Пароль:</label>
                            <div class="col-sm-4">
                                <input type="password" name="password" class="form-control" placeholder="новый пароль"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">email:</label>
                            <div class="col-sm-4">
                                <input type="email" name="email" class="form-control" value="${user.email!''}"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Номер телефона:</label>
                            <div class="col-sm-4">
                                <input type="text" name="phoneNumber" class="form-control"
                                       value="${user.phoneNumber!''}"/>
                            </div>
                        </div>
                        <input type="hidden" value="${user.id}" name="userId">
                        <input type="hidden" value="${_csrf.token}" name="_csrf">

                        <div class="form-group row">
                            <div class="col-sm-4">
                                <button class="btn btn-primary" type="submit">Сохранить</button>
                            </div>
                        </div>
                    </div>

                    <#if user.isUserHasDoctorRole(user)>
                        <div class="col">
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Отделение:</label>
                                <div class="col-sm-6">
                                    <select class="custom-select" name="department">
                                        <#list departments as department>
                                            <option <#if department == user.doctor.department>selected</#if>
                                                    value="${department}">${department}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Должность:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="position" class="form-control"
                                           value="${user.doctor.position!''}"
                                    />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Кабинет:</label>
                                <div class="col-sm-4">
                                    <input type="text" name="cabinet" class="form-control"
                                           value="${user.doctor.cabinet!''}"
                                    />
                                </div>
                            </div>
                        </div>
                    </#if>
                </div>
            </div>
        </form>
    </div>

    <#if user.isUserHasPassport(user)>
        <div>
            <form action="/admin/passports/${passport.id}" method="get">
                <div class="form-group row">
                    <div class="col-sm-4">
                        <button class="btn btn-outline-info btn-sm" type="submit">Редактировать паспорт</button>
                    </div>
                </div>
            </form>
        </div>
    </#if>

    <div>
        <form action="/admin/users/${user.id}/delete" method="get">
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-outline-danger" type="submit">Удалить</button>
                </div>
            </div>
        </form>
    </div>

</@c.page>
