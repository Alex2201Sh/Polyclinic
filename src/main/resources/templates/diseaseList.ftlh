<#import "parts/common.ftlh" as c>
<#import "parts/security.ftlh" as s>


<@c.page>
Список заболеваний

    <br>
    <a href="/admin/diseases/add">Добавить заболевание</a>
    <br>
<table class="table">
    <thead>
    <tr>
        <th>Наименование заболевания</th>
        <th>Описание</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list diseases as disease>
    <tr>
        <td>${disease.getName()}</td>
        <td>${disease.getDescription()}</td>
        <td><a href="/admin/diseases/${disease.id}">Редактировать</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>