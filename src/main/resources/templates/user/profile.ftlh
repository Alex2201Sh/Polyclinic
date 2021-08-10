<#import "../parts/common.ftlh" as c>

<@c.page>
    <h5>${username!''}</h5>
    <form method="post">
        <p>
            <button class="btn btn-info" type="button" data-bs-toggle="collapse" data-bs-target="#profile"
                    aria-expanded="false" aria-controls="profile">
                Профиль пользователя
            </button>
        </p>
        <div class="collapse" id="profile">
            <div class="card card-body">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Пароль:</label>
                    <div class="col-sm-6">
                        <input type="password" name="password" class="form-control" placeholder="новый пароль"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">email:</label>
                    <div class="col-sm-6">
                        <input type="email" name="email" class="form-control" placeholder="новый email"
                               value="${email!}"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Номер телефона:</label>
                    <div class="col-sm-6">
                        <input type="tel" name="phoneNumber" class="form-control" placeholder="новый номер телефона"
                               value="${phoneNumber!}"/>
                    </div>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-primary" type="submit">Сохранить</button>
        </div>

    </form>

    <br>

    <#if user.isUserHasPassport(user)>
        <form action="/user/passport" method="get">
            <button class="btn btn-primary" type="submit">Редактировать паспорт</button>
        </form>
    <#else>
        <form action="/user/passport" method="get">
            <button class="btn btn-primary" type="submit">Добавить паспортные данные</button>
        </form>
    </#if>

</@c.page>

