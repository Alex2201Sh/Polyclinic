<#import "parts/common.ftlh" as c>
<#import "parts/security.ftlh" as s>

<@c.page>


    <p>
        <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#doctors"
                aria-expanded="false" aria-controls="doctors">
            Список врачей
        </button>
    </p>
    <div class="collapse" id="doctors">
        <div class="card card-body">

            <table class="table">
                <thead>
                <tr>
                    <th>Фамилия</th>
                    <th>Отделение</th>
                    <th>Должность</th>
                </tr>
                </thead>
                <tbody>
                <#list doctors as doctor>
                    <tr>
                        <td>${doctor.passport.surname!''} </td>
                        <td>${doctor.getDoctor().department!''}</td>
                        <td>${doctor.getDoctor().position!''}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>

    <p>
        <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#medcard"
                aria-expanded="false" aria-controls="medcard">
            Медицинская карта (история обращений)
        </button>
    </p>
    <div class="collapse" id="medcard">
        <div class="card card-body">

            <table class="table">
                <thead>
                <tr>
                    <th>Доктор</th>
                    <th>Заболел</th>
                    <th>Выздоровел</th>
                    <th>Диагноз</th>
                </tr>
                </thead>
                <tbody>
                <#list treatments as treatment>
                    <tr>
                        <#if treatment.isTreatmentHasDoctor(treatment)>
                            <td>${treatment.doctor.user.passport.surname} </td>
                        <#else>
                            <td></td>
                        </#if>
                        <td>${treatment.sickDate!''} </td>
                        <#if treatment.isPatientSickNow(treatment)>
                            <td>не выздоровел</td>
                        <#else>
                            <td>${treatment.recoverDate} </td>
                        </#if>

                        <#if !treatment.isTreatmentHasDisease(treatment)>
                            <td>нет диагноза</td>
                        <#else>
                            <td>${treatment.disease.name} </td>
                        </#if>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>

    <form action="/user/patient/newtreatment" method="get">
        <button class="btn btn-primary" type="submit">Новое обращение</button>
    </form>


</@c.page>