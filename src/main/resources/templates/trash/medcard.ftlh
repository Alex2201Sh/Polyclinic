<#--<#import "parts/common.ftlh" as c>-->
<#--<#import "parts/security.ftlh" as s>-->


<#--<@c.page>-->

<#--    <div> Медицинская карта пользователя ${medicalCard.getUser().getUsername()}</div>-->

<#--    <div>Состояние здоровья ${medicalCard.healthStatus} %</div>-->

<#--    <table class="table">-->
<#--        <thead>-->
<#--        <tr>-->
<#--            <th>№ обращения</th>-->
<#--            <th>Заболевание</th>-->
<#--            <th>Заболел</th>-->
<#--            <th>Выздоровел</th>-->
<#--            <th>Доктор</th>-->

<#--        </tr>-->
<#--        </thead>-->
<#--        <tbody>-->
<#--        <#list treatments as treatment>-->
<#--            <tr>-->
<#--                <td>${treatment.id!''}</td>-->
<#--                <td>${treatment.disease.name!''}</td>-->
<#--                <td>${treatment.sickDate!''}</td>-->
<#--                <td>${treatment.recoverDate!''}</td>-->
<#--                <td>${treatment.getDoctor().getUser().getPassport().getSurname()!''}</td>-->
<#--            </tr>-->
<#--        </#list>-->
<#--        </tbody>-->
<#--    </table>-->
<#--</@c.page>-->