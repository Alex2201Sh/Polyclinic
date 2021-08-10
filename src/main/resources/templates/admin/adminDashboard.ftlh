<#import "../parts/common.ftlh" as c>
<#import "../parts/security.ftlh" as s>

<@c.page>

    <#if s.isAdmin>
        <form action="/admin/users" method="get">
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-success" type="submit">Пользователи</button>
                </div>
            </div>
        </form>
        <form action="/admin/passports" method="get">
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-success" type="submit">Справочник паспортов</button>
                </div>
            </div>
        </form>
        <form action="/admin/diseases" method="get">
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-success" type="submit">Справочник заболеваний</button>
                </div>
            </div>
        </form>
        <form action="/admin/talons" method="get">
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-success" type="submit">Добавить талоны в базу</button>
                </div>
            </div>
        </form>

    <#else>
        <div>Доступ только для Администратора</div>
    </#if>

</@c.page>