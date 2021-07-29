<#import "../parts/common.ftlh" as c>

<@c.page>
    <form action="/user/" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Идентификационный номер пасспорта:</label>
            <div class="col-sm-6">
                <input type="text" name="passportId" class="form-control" placeholder="введите 14-значный ид.номер"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пароль:</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="введите пароль"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Номер телефона:</label>
            <div class="col-sm-6">
                <input type="tel" name="phoneNumber" class="form-control" placeholder="номер телефона"
                       value="${phoneNumber!''}"/>
            </div>
        </div>

        <button class="btn btn-primary" type="submit">Создать</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

    </form>
</@c.page>