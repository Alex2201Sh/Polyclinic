<#import "../parts/common.ftlh" as c>

<@c.page>
    Запись к врачу

    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/user/patient/newtreatment" class="form-inline">
                <div class="col-sm-4">
                    <select class="custom-select" name="doctor">
                        <#if doctor??>
                            <#list doctors as user>
                                <option
                                        <#if doctor.id==user.doctor.id>selected</#if>
                                        value="${user.doctor.id}">
                                    ${user.passport.surname!''}
                                </option>
                            </#list>
                        <#else>
                            <option></option>
                            <#list ddd as doctor>
                                <option value="${doctor.id}">
                                    ${doctor.user.passport.surname!''}
                                </option>

                            </#list>
                        </#if>
                    </select>
                </div>
                <#if doctor??>
                    <button type="submit" class="btn btn-light ml-2">Изменить</button>
                <#else>
                    <button type="submit" class="btn btn-primary ml-2">Далее</button>
                </#if>
                <br>

            </form>
            <#if doctor??>
                <form method="post" action="/user/patient">
                    <div class="col-sm-6">
                        <select class="custom-select" name="talon">
                            <#list talons as talon>
                                <option
                                        value="${talon.id}">${talon.talonDate} ${talon.talonTime}</option>
                            </#list>
                        </select>
                    </div>
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <input type="hidden" value="${doctor.id}" name="doctor">
                    <br>
                    <div class="form-group row">
                        <div class="col-sm-4">
                            <button class="btn btn-primary" type="submit">Сохранить</button>
                        </div>
                    </div>
                </form>
            </#if>
        </div>
    </div>
</@c.page>
