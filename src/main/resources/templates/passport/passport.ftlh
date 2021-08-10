<#import "../parts/common.ftlh" as c>

<@c.page>
    <h3>Редактор пасспорта</h3>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Личный номер пасспорта:</label>
            <div class="col-sm-6">
                <input type="text" name="personalNo" class="form-control" placeholder="Личный номер"
                       value="${personalNo!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Имя:</label>
            <div class="col-sm-6">
                <input type="text" name="firstName" class="form-control" placeholder="имя" value="${firstName!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Фамилия:</label>
            <div class="col-sm-6">
                <input type="text" name="surname" class="form-control" placeholder="фамилия"
                       value="${surname!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Адрес:</label>
            <div class="col-sm-6">
                <input type="text" name="address" class="form-control" placeholder="address"
                       value="${address!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата рождения:</label>
            <div class="col-sm-6">
                <input type="date" name="birthDate" class="form-control" placeholder="birthDate"
                       value="${birthDate!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Место рождения:</label>
            <div class="col-sm-6">
                <input type="text" name="birthPlace" class="form-control" placeholder="birthPlace"
                       value="${birthPlace!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Код органа выдавшего паспорт:</label>
            <div class="col-sm-6">
                <input type="text" name="codeOfIssuingState" class="form-control" placeholder="codeOfIssuingState"
                       value="${codeOfIssuingState!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата выдачи:</label>
            <div class="col-sm-6">
                <input type="date" name="dateOfIssue" class="form-control" placeholder="dateOfIssue"
                       value="${dateOfIssue!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Дата истечения срока действия:</label>
            <div class="col-sm-6">
                <input type="date" name="dateOfExpiry" class="form-control" placeholder="dateOfExpiry"
                       value="${dateOfExpiry!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Национальность:</label>
            <div class="col-sm-6">
                <input type="text" name="nationality" class="form-control" placeholder="nationality"
                       value="${nationality!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Номер паспорта:</label>
            <div class="col-sm-6">
                <input type="text" name="passportNumber" class="form-control" placeholder="passportNumber"
                       value="${passportNumber!''}"/>
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


        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
</@c.page>

