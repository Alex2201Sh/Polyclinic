<#import "../parts/common.ftlh" as c>
<#import "../parts/pager.ftlh" as p>


<@c.page>

    <div>
        <form action="/admin" method="get">
            <div class="form-group row">
                <div class="col-sm-4">
                    <button class="btn btn-outline-info btn-sm" type="submit">Назад</button>
                </div>
            </div>
        </form>
    </div>

    Список заболеваний
    <a href="/admin/diseases/add">Добавить заболевание</a>
    <br>
    <#if page.totalPages gt 1>
        <@p.pager url page />
    </#if>
    <div class="card card-body">
        <table class="table table-hover table-sm table-responsive">
            <thead>
            <tr>
                <th scope="col">Наименование заболевания</th>
                <th scope="col">Описание</th>
            </tr>
            </thead>
            <tbody>
            <#list page.content as disease>
                <tr>
                    <th scope="row"><a href="/admin/diseases/${disease.id}">${disease.getName()}</a></th>
                    <td>${disease.getDescription()}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <#if page.totalPages gt 1>
        <@p.pager url page />
    </#if>
</@c.page>