<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Логин:</label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="введите логин"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пароль:</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="введите пароль"/>
            </div>
        </div>

        <#if isRegisterForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">email:</label>
                <div class="col-sm-6">
                    <input type="email" name="email" class="form-control" placeholder="email"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Номер телефона:</label>
                <div class="col-sm-6">
                    <input type="tel" name="phoneNumber" class="form-control" placeholder="номер телефона"/>
                </div>
            </div>
        </#if>

        <#if !isRegisterForm><a href="/registration">Добавление нового пользователя</a></#if>
        <button class="btn btn-primary" type="submit">
            <#if isRegisterForm>Создать<#else>Войти</#if>
        </button>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

    </form>

</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Выйти</button>
    </form>
</#macro>