<#import "parts/common.ftlh" as c>
<#import "parts/security.ftlh" as s>


<@c.page>

    <#if s.isUserADoctor>
        <div>Кабинет №${doctor.doctor.cabinet!''}</div>
        <div>Доктор ${doctor.passport.surname!''} ${doctor.passport.firstName!''}</div>
        <br><br>
    </#if>
    <p>
        <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#patients"
                aria-expanded="false" aria-controls="patients">
            Пациенты
        </button>
    </p>
    <div class="collapse" id="patients">
        <div class="card card-body">
            <table class="table">
                <thead>
                <tr>
                    <th>Пациент</th>
                    <th>Состояние здоровья</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <#list patients as user>
                    <tr>
                        <td>${user.passport.surname!''} ${user.passport.firstName!''}</td>
                        <td>${user.medicalCard.healthStatus!''} %</td>
                        <td></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <br>
    <p>
        <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#openTreatments"
                aria-expanded="false" aria-controls="openTreatments">
            Открытые обращения
        </button>
    </p>
    <div class="collapse" id="openTreatments">
        <div class="card card-body">
            <table class="table">
                <thead>
                <tr>
                    <th>Пациент</th>
                    <th>Состояние здоровья</th>
                    <th>Дата обращения</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <#list treatments as treatment>
                    <tr>
                        <#if treatment.isPatientSickNow(treatment)>
                            <td>${treatment.medicalCard.user.passport.surname!''} ${treatment.medicalCard.user.passport.firstName!''}</td>
                            <td>${treatment.medicalCard.healthStatus!''} %</td>
                            <td>${treatment.sickDate!''}</td>
                            <td><a href="/doctor/treatment/${treatment.id}">Лечить</a></td>
                        </#if>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <br>

</@c.page>