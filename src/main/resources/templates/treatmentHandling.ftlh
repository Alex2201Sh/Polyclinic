<#import "parts/common.ftlh" as c>

<@c.page>
    <div><h3>Диагноз и дата выписки</h3></div>

    <form method="post" action="/doctor/treatment">
        <div class="form-group row">
            <div class="col-sm-10">
                <label>Диагноз:</label>
                <select class="custom-select" name="disease">
                    <#if treatment.disease??>
                        <#list diseases as disease>
                            <option
                                    <#if disease.id==treatment.disease.id>selected</#if>
                                    value="${disease.id}">${disease.name!''}</option>
                        </#list>
                    <#else>
                        <option></option>
                        <#list diseases as disease>
                            <option
                                    value="${disease.id}">${disease.name!''}</option>
                        </#list>
                    </#if>
                </select>
            </div>
            <div class="col-sm-4">
                <label>Даты выписки</label>
                <input type="date" name="recoverDate" class="form-control" value="${treatment.recoverDate!''}"/>
            </div>
            <div class="col-sm-4">
                <label>Оценка состояния здоровья, %</label>
                <input type="number" name="healthStatus" class="form-control"
                       value="${treatment.medicalCard.healthStatus!''}"/>
            </div>
            <input type="hidden" value="${treatment.id}" name="treatment">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
        </div>

        <div class="form-group row">
            <div class="col-sm-4">
                <button class="btn btn-primary" type="submit">Сохранить</button>
            </div>
        </div>
    </form>


</@c.page>
