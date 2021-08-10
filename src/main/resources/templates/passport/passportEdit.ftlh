<#import "../parts/common.ftlh" as c>

<@c.page>
    <h3>Редактор пасспорта</h3>
    <form action="/admin/passports" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Личный номер пасспорта:</label>
            <div class="col-sm-6">
                <input type="text" name="personalNo" value="${passport.personalNo!''}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Имя:</label>
            <div class="col-sm-6">
                <input type="text" name="firstName" value="${passport.firstName!''}" placeholder="введите имя">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Фамилия:</label>
            <div class="col-sm-6">
                <input type="text" name="surname" value="${passport.surname!''}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Адрес:</label>
            <div class="col-sm-6">
                <input type="text" name="address" value="${passport.address!''}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата рождения:</label>
            <div class="col-sm-6">
                <input type="date" name="birthDate" value="${passport.birthDate!''}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Место рождения:</label>
            <div class="col-sm-6">
                <input type="text" name="birthPlace" value="${passport.birthPlace!''}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Код органа выдавшего паспорт:</label>
            <div class="col-sm-6">
                <input type="text" name="codeOfIssuingState"
                       value="${passport.codeOfIssuingState!''}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата выдачи:</label>
            <div class="col-sm-6">
                <input type="date" name="dateOfIssue" value="${passport.dateOfIssue!''}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата истечения срока действия:</label>
            <div class="col-sm-6">
                <input type="date" name="dateOfExpiry" value="${passport.dateOfExpiry!''}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Национальность:</label>
            <div class="col-sm-6">
                <input type="text" name="nationality" value="${passport.nationality!''}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Номер паспорта:</label>
            <div class="col-sm-6">
                <input type="text" name="passportNumber" value="${passport.passportNumber!''}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пол:</label>
            <div class="col-sm-2">
                <select class="custom-select" name="sex">
                    <#list sexValues as sex>
                        <option <#if sex == passport.sex>selected</#if>
                                value="${sex}">${sex}</option>
                    </#list>
                </select>
            </div>
        </div>
        <input type="hidden" value="${passport}" name="passport">
        <input type="hidden" value="${passport.id}" name="passportId">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
</@c.page>
