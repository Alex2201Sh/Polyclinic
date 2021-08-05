<#import "parts/common.ftlh" as c>

<@c.page>
    <form action="/admin/diseases/add" method="post">
        <div class="container">
            <div class="row g-2">
                <div class="col-sm-6">
                    <label for="name" class="form-label">Наименование:</label>
                    <input type="text" name="name" class="form-control" id="name"
                           placeholder="наименование заболевания">
                </div>
                <br>
                <div class="col-sm-10">
                    <label for="description" class="form-label">Описание:</label>
                    <textarea class="form-control" name="description" id="description" rows="3"></textarea>
                </div>
                <br>
                <div class="col-sm-6">
                    <button class="btn btn-primary" type="submit">Создать</button>
                </div>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

    </form>
</@c.page>