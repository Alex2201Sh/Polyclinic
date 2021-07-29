<#import "../parts/common.ftlh" as c>

<@c.page>
    Редактор пасспорта
    <form action="/admin/passports" method="post">
        <input type="text" name="passportId" value="${passport.id}"><label>passportId</label>
        <br>
        <input type="text" name="firstName" value="${passport.firstName!''}"><label>firstName</label>
        <br>
        <input type="text" name="surname" value="${passport.surname!''}"><label>surname</label>
        <br>
        <input type="text" name="address" value="${passport.address!''}"><label>address</label>
        <br>
        <input type="date" name="birthDate" value="${passport.birthDate!''}"><label>birthDate</label>
        <br>
        <input type="text" name="birthPlace" value="${passport.birthPlace!''}"><label>birthPlace</label>
        <br>
        <input type="text" name="codeOfIssuingState" value="${passport.codeOfIssuingState!''}"><label>codeOfIssuingState</label>
        <br>
        <input type="date" name="dateOfIssue" value="${passport.dateOfIssue!''}"><label>dateOfIssue</label>
        <br>
        <input type="date" name="dateOfExpiry" value="${passport.dateOfExpiry!''}"><label>dateOfExpiry</label>
        <br>
        <input type="text" name="nationality" value="${passport.nationality!''}"><label>nationality</label>
        <br>
        <input type="text" name="passportNumber" value="${passport.passportNumber!''}"><label>passportNumber</label>
        <br>
        <input type="text" name="sex" value="${passport.sex!''}"><label>sex</label>
        <br>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Сохранить</button>
    </form>
</@c.page>
