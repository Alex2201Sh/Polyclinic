<#import "parts/common.ftlh" as c>
<#import "parts/security.ftlh" as s>


<@c.page>
    Редактор пользователя
    <br>
    <form action="/admin/users" method="post">
        <input type="text" name="username" value="${user.username}">

        <#--        <#list roles as role>-->
        <#--            <div class="list_group">-->
        <#--                <label class="list-group-item">-->
        <#--                    <input class="form-check-input" type="radio" ${user.role?contains(role)?string("checked", "")}>-->
        <#--                    ${role}-->
        <#--                </label>-->
        <#--            </div>-->
        <#--        </#list>-->

        <#--        <#list roles as role>-->
        <#--            <div>-->
        <#--                <label><input type="checkbox"-->
        <#--                              name="${role}" ${user.role?contains(role)?string("checked", "")}>${role}</label>-->
        <#--            </div>-->
        <#--            <div class="form-check">-->
        <#--                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"-->
        <#--                        ${user.role?contains(role)?string("checked", "")}>-->
        <#--                <label class="form-check-label" for="flexRadioDefault2">-->
        <#--                    ${role}-->
        <#--                </label>-->
        <#--            </div>-->
        <#--        </#list>-->

        <div>
            <input type="text" name="role" value="${user.role}"><label>role</label>
        </div>
        <div>
            <input type="text" name="password" value="${user.password}"><label>password</label>
        </div>
        <div>
            <input type="email" name="email" value="${user.email!''}"><label>email</label>
        </div>
        <div>
            <input type="text" name="phoneNumber" value="${user.phoneNumber!''}"><label>phoneNumber</label>
        </div>

        <#if user.isUserHasPassport(user)>
            <input type="text" name="passportId" value="${passport.getId()!''}"><label>passportId</label>
        </#if>

        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <br>
        <button type="submit">Сохранить</button>
    </form>

    <form action="/admin/users/${user.id}/delete" method="get">
        <button type="submit">Удалить</button>
    </form>

</@c.page>
