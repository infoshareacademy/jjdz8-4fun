<#if email??>
    <#if isAdmin?? && isAdmin>
        <#include "navigationForAdmin.ftlh">
    <#else>
        <#include "navigationForUser.ftlh">
    </#if>
<#else>
    <#include "navigationForGuest.ftlh">
</#if>

