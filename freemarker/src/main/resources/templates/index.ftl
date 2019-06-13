<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8"/>
    <title></title>
</head>
<body>
FreeMarker模板引擎
this is icloudit <br>
${name}
${sex}
<#if sex==1>
    男
<#elseif sex==2>
    女
<#else>
    其他

</#if>

<#list userlist as user>
    ${user}
</#list>

</body>
</html>