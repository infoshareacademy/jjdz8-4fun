<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome-user-ftlh</title>
</head>
<body>
<h1>Welcome <strong>${user ! "visitor"}!</strong></h1>
<#if user??><h1>Welcome ${user}!</h1></#if>
<#--comment example not visible on production ;
# cuts of comment from html-->

</body>
</html>