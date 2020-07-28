<#include "common/headerShort.ftlh">
<body>
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <div class="row justify-content-center">
            <h1 class="display-3" style="font-size: 40px">Lista zakupów</h1>
        </div>
    </div>
</header>
<table class="table table-striped table-green">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">User</th>
        <th scope="col">Nazwa</th>
        <th scope="col">Firma</th>
        <th scope="col">Cena</th>
        <th scope="col">Kalorie</th>
        <th scope="col">Sklep</th>
        <th scope="col">Kategoria</th>
        <th scope="col">Ilość</th>
        <th scope="col">Edytuj ilość</th>
        <th scope="col">Usuń</th>
        <th scope="col">Usuń całą listę</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <#list userProducts as userProduct>
    <tr>
        <th scope="row">${(userProduct.id)!}</th>
        <th>${userProduct.useridInt}</th>
        <th>${userProduct.productName}</th>
        <th>${userProduct.productBrand}</th>
        <th>${userProduct.productPrice}</th>
        <th>${userProduct.productCalories}</th>
        <th>${userProduct.productShop}</th>
        <th>${(userProduct.productCategory)!}</th>
        <th>${(userProduct.productAmount)}</th>
        <th>
            <div class="col-md-6">
                <div class="ANPform-style-2">
                    <form method="get" action="/db_editProductList?id=${userProduct.id}">
                        <button type="submit" name="id"
                                style="background: #575C60; color: white; padding: 8px 15px 8px 15px; border: none; border-radius: 3px; margin-top: 0; margin-bottom: 0;"
                                value="${userProduct.id}">Edytuj
                        </button>
                    </form>
                </div>
            </div>
        </th>
        <th>
            <div class="col-md-6">
                <div class="ANPform-style-2">
                    <form method="post" action="db_deleteFromShoppingList?id=${userProduct.useridInt}">
                        <button type="submit" name="id"
                                style="background: #575C60; color: white; padding: 8px 15px 8px 15px; border: none; border-radius: 3px; margin-top: 0; margin-bottom: 0;"
                                value="${userProduct.useridInt}">Usuń
                        </button>
                    </form>
                </div>
            </div>
        </th>
        <th>
            <div class="col-md-6">
                <div class="ANPform-style-2">
                    <form method="post" action="/db_deleteAllShoppingList">
                        <button type="submit" name="id"
                                style="background: #575C60; color: white; padding: 8px 15px 8px 15px; border: none; border-radius: 3px; margin-top: 0; margin-bottom: 0;"
                                value="${userProduct.useridInt}">Usuń całą listę
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