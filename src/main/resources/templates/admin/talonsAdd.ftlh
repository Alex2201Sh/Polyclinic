<#import "../parts/common.ftlh" as c>

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

    Добавление талонов в базу

    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/admin/talons" class="form-inline">
                <div class="col-sm-4">
                    <select class="custom-select" name="doctor">
                        <#if doctor??>
                            <#list doctors as user>
                                <option
                                        <#if doctor.id==user.doctor.id>selected</#if>
                                        value="${user.doctor.id}">${user.passport.surname!''}</option>
                            </#list>
                        <#else>
                            <option></option>
                            <#list doctors as user>
                                <option
                                        <#if doctorid??>selected</#if>
                                        value="${user.doctor.id}">${user.passport.surname!''}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
                <#if doctor??>
                    <button type="submit" class="btn btn-light ml-2">Изменить</button>
                <#else>
                    <button type="submit" class="btn btn-primary ml-2">Далее</button>
                </#if>
            </form>

            <#if doctor??>
                <form method="post" action="/admin/talons">
                    <div class="col-sm-4">
                        <label>Дата:</label>
                        <input type="date" name="date">
                    </div>
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <input type="hidden" value="${doctor.id!''}" name="doctor">
                    <div class="col-sm-4">
                        <button class="btn btn-primary" type="submit">Сохранить</button>
                    </div>

                </form>
            </#if>
        </div>
    </div>
</@c.page>
