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



    </#if>

</@c.page>