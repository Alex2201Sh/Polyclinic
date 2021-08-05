<#import "parts/common.ftlh" as c>

<@c.page>
    Запись к врачу


    <form action="/user/patient/newtreatment" method="post">

        <input type="text" name="doctorSurname"><label>Доктор</label>
        <br>
        <input type="date" name="sickDate"><label>Дата обращения</label>
        <br>


        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Записаться</button>
    </form>
</@c.page>
