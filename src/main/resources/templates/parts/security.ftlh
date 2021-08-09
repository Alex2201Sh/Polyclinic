<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.isAdmin()
    isUserADoctor = user.isUserADoctor()
    isUserHasDoctorRole = user.isUserHasDoctorRole(user)
    isUserHasPassport = user.isUserHasPassport(user)
    isUserHasNullUsername = user.isUserHasNullUsername(user)
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    isUserADoctor = false
    isUserHasPassport = false
    isUserHasNullUsername = true
    >
</#if>