<#include "security.ftlh">
<#import "security.ftlh" as s>
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-b rand" href="/">iПоликлиника</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                   aria-expanded="false">
                    ИНФО
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <li class="nav-item">
                        <a class="nav-link" href="/info">Инфо о поликлинике</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/news">Новости</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/useful">Полезная <br> информация</a>
                    </li>
                </ul>
            </li>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile">Профиль</a>
                </li>

                <#if s.isUserHasPassport>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/patient">Кабинет <br> пациента</a>
                    </li>
                <#else>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="http://localhost:8080/user/passport" tabindex="-1"
                           aria-disabled="true" data-bs-toggle="tooltip"
                           title="Чтобы стать пациентом нужно заполнить паспортные данные">
                            Кабинет<br>пациента
                        </a>
                    </li>
                </#if>


            </#if>

            <#if s.isUserADoctor>
                <li class="nav-item">
                    <a class="nav-link" href="/doctor/patients">Кабинет <br> доктора</a>
                </li>
            </#if>
            <#if s.isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/doctor/patients">Кабинет <br> доктора</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin">Кабинет <br> администратора</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <#if s.known><@l.logout /></#if>
    </div>
</nav>