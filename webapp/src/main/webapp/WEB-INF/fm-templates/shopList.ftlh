<#include "common/headerShort.ftlh">
<body>
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Lista sklepów</h1>
    </div>
</header>
<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th scope="col"></th>
        <th scope="col"></th>
        <th scope="col">Id</th>
        <th scope="col"></th>
        <th scope="col">Nazwa</th>
        <th scope="col"></th>
        <th scope="col">Edytuj</th>
        <th scope="col">Usuń</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <#list shops as shop>
    <tr>
        <th scope="col"></th>
        <th scope="col"></th>
        <th scope="row">${(shop.id)!}</th>
        <th scope="col"></th>
        <th>${shop.shop}</th>
        <th scope="col"></th>
        <th>
            <div class="col-md-6">
                <div class="ANPform-style-2">
                    <form method="get" action="findShopById?id=${shop.id}">
                        <button type="submit" name="id"
                                style="background: #575C60; color: white; padding: 8px 15px 8px 15px; border: none; border-radius: 3px; margin-top: 0; margin-bottom: 0;"
                                value="${shop.id}">Edytuj
                        </button>
                    </form>
                </div>
            </div>
        </th>
        <th>
            <div class="col-md-6">
                <div class="ANPform-style-2">
                    <form method="post" action="deleteShop?id=${shop.id}">
                        <button type="submit" name="id"
                                style="background: #575C60; color: white; padding: 8px 15px 8px 15px; border: none; border-radius: 3px; margin-top: 0; margin-bottom: 0;"
                                value="${shop.id}">Usuń
                        </button>
                    </form>
                </div>
            </div>
        </th>
    </tr>
    </#list>
    </tbody>
</table>
</body>
<#include "common/copyright-footer.ftlh">
</html>