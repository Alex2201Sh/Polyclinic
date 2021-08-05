<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="card-columns">
        <#list informations as information>
            <div class="card my-3" data-id="${information.id}">
                <div class="m-2">
                    <span>${information.text!''}</span><br/>
                    <i>#${information.tag!''}</i>
                </div>
            </div>
        </#list>
    </div>
</@c.page>