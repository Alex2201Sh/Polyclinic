<#import "parts/common.ftlh" as c>
<#import "parts/security.ftlh" as s>

<@c.page>

    <#if !s.known>
        <div class="container">
            <div class="row">
                <div class="col">
                    <form action="/login" method="get">
                        <div class="form-group row">
                            <div class="col-sm-4">
                                <button class="btn btn-success" type="submit">Войти</button>
                            </div>
                        </div>
                    </form>
                    <form action="/registration" method="get">
                        <div class="form-group row">
                            <div class="col-sm-4">
                                <button class="btn btn-warning" type="submit">Добавить пользователя</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col">
                    <h2 class="text-center">Привет, гость.</h2>
                    <h4 class="text-center font-italic">Приложение iPolyclinic</h4>
                </div>
            </div>
        </div>
    <#else>
        <form action="/info" method="get">
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-success" type="submit">Информация о поликлинике</button>
                </div>
            </div>
        </form>
        <form action="/news" method="get">
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-success" type="submit">Новости</button>
                </div>
            </div>
        </form>
        <form action="/useful" method="get">
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-success" type="submit">Полезная информация</button>
                </div>
            </div>
        </form>
        <form action="/user/profile" method="get">
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-success" type="submit">Профиль пользователя</button>
                </div>
            </div>
        </form>
    </#if>

</@c.page>