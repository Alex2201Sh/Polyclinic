<#import "../parts/common.ftlh" as c>

<@c.page>
    Редактор заболевания
    <br>
    <form action="/admin/diseases" method="post">
        <div class="container">
            <div class="row g-2">
                <div class="col-sm-6">
                    <label for="name" class="form-label">Наименование:</label>
                    <input type="text" name="name" class="form-control" id="name"
                           placeholder="наименование заболевания" value="${name}">
                </div>
                <br>
                <div class="col-sm-10">
                    <label for="description" class="form-label">Описание:</label>
                    <textarea class="form-control" name="description" id="description" rows="3">${description}
                    </textarea>
                </div>
                <br>
                <input type="hidden" value="${diseaseId}" name="diseaseId">
                <div class="col-sm-6">
                    <button class="btn btn-primary" type="submit">Сохранить</button>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
        </div>
    </form>

    <form action="/admin/diseases/${disease.id}/delete" method="get">
        <div class="container">
            <div class="row g-2">
                <br>
                <div class="col-sm-6">
                    <button class="btn btn-outline-danger" type="submit">Удалить</button>
                </div>
            </div>
        </div>
    </form>

</@c.page>
