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
        <#list shoppingListproducts as product>
    <tr>
        <th scope="row">${(product.id)!}</th>
        <th>${product.name}</th>
        <th>${product.brand}</th>
        <th>${product.price}</th>
        <th>${product.calories}</th>
        <th>${product.shop}</th>
        <th>${(product.productCategory)!}</th>
        <th>${(product.amount)}</th>
        <th>
            <div class="col-md-6">
                <div class="ANPform-style-2">
                    <form method="get" action="/editProductList?id=${product.id}">
                        <button type="submit" name="id"
                                style="background: #575C60; color: white; padding: 8px 15px 8px 15px; border: none; border-radius: 3px; margin-top: 0; margin-bottom: 0;"
                                value="${product.id}">Edytuj
                        </button>
                    </form>
                </div>
            </div>
        </th>
        <th>
            <div class="col-md-6">
                <div class="ANPform-style-2">
                    <form method="post" action="delete-fromShoppingList?name=${product.name}">
                        <button type="submit" name="id"
                                style="background: #575C60; color: white; padding: 8px 15px 8px 15px; border: none; border-radius: 3px; margin-top: 0; margin-bottom: 0;"
                                value="${product.id}">Usuń
                        </button>
                    </form>
                </div>
            </div>
        </th>
        <th>
            <div class="col-md-6">
                <div class="ANPform-style-2">
                    <form method="post" action="/deleteAllShoppingList">
                        <button type="submit" name="id"
                                style="background: #575C60; color: white; padding: 8px 15px 8px 15px; border: none; border-radius: 3px; margin-top: 0; margin-bottom: 0;"
                                value="${product.id}">Usuń całą listę
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