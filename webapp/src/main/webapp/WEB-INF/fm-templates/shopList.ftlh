<#include "common/headerShort.ftlh">
<body>
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Lista sklepow</h1>
    </div>
</header>
<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Nazwa</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <#list shops as shop>
    <tr>
        <th scope="row">${(shop.id)!}</th>
        <th>${shop.shop}</th>
    </tr>
    </#list>
    </tbody>
</table>
</body>
<#include "common/copyright-footer.ftlh">
</html>