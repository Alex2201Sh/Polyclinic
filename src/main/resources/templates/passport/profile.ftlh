<#import "../parts/common.ftlh" as c>

<@c.page>
    <h5>passport/profile</h5>
    <h5>${passportId!''}</h5>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Идентификационный номер пасспорта:</label>
            <div class="col-sm-6">
                <input type="text" name="passportId" class="form-control" placeholder="Идентификационный номер"
                       value="${passportId!''}"/>
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
            <label class="col-sm-2 col-form-label">address:</label>
            <div class="col-sm-6">
                <input type="text" name="address" class="form-control" placeholder="address"
                       value="${address!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">birthDate:</label>
            <div class="col-sm-6">
                <input type="date" name="birthDate" class="form-control" placeholder="birthDate"
                       value="${birthDate!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">birthPlace:</label>
            <div class="col-sm-6">
                <input type="text" name="birthPlace" class="form-control" placeholder="birthPlace"
                       value="${birthPlace!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">codeOfIssuingState:</label>
            <div class="col-sm-6">
                <input type="text" name="codeOfIssuingState" class="form-control" placeholder="codeOfIssuingState"
                       value="${codeOfIssuingState!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">dateOfIssue:</label>
            <div class="col-sm-6">
                <input type="date" name="dateOfIssue" class="form-control" placeholder="dateOfIssue"
                       value="${dateOfIssue!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">dateOfExpiry:</label>
            <div class="col-sm-6">
                <input type="date" name="dateOfExpiry" class="form-control" placeholder="dateOfExpiry"
                       value="${dateOfExpiry!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">nationality:</label>
            <div class="col-sm-6">
                <input type="text" name="nationality" class="form-control" placeholder="nationality"
                       value="${nationality!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">passportNumber:</label>
            <div class="col-sm-6">
                <input type="text" name="passportNumber" class="form-control" placeholder="passportNumber"
                       value="${passportNumber!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">sex:</label>
            <div class="col-sm-6">
                <input type="text" name="sex" class="form-control" placeholder="sex"
                       value="${sex!''}"/>
            </div>
        </div>


        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
</@c.page>

