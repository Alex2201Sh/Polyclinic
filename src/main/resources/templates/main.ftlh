<#import "parts/common.ftlh" as c>
<#import "parts/security.ftlh" as s>

<@c.page>

    <#if s.isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
           aria-controls="collapseExample">
        </a>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="text" class="form-control" name="text" placeholder="Введите сообщение"/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="tag" placeholder="Тэг">
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Добавить</button>
                    </div>
                </form>
            </div>
        </div>
    </#if>
</@c.page>