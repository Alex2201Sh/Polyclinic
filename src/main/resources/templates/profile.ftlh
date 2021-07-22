<#import "parts/common.ftlh" as c>

<@c.page>
    <h5>${username!''}</h5>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пароль:</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Новый пароль"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">email:</label>
            <div class="col-sm-6">
                <input type="email" name="email" class="form-control" placeholder="Новый email" value="${email!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Номер телефона:</label>
            <div class="col-sm-6">
                <input type="tel" name="phoneNumber" class="form-control" placeholder="Новый номер телефона"
                       value="${phoneNumber!''}"/>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Save</button>
    </form>
</@c.page>

