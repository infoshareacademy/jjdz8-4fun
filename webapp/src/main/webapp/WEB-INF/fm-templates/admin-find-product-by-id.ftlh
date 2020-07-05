<#include "common/headerShort.ftlh">
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - (admin) wyszukaj po ID</h1>
    </div>
    </br>
    <main role="main">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <div class="ANPform-style-2-heading">(admin) Wyszukiwanie produktu po numerze ID</div>
                        <form method="get" action="/admin-find-product-by-id" accept-charset="utf-8">
                            <#if errorMessage??>
                                <span style="color: #ff0000;">${errorMessage}</span><br/><br/>
                            </#if>
                            <#if product??>
                                <ul>
                                    <li>Product ID: ${product.id}</li>
                                    <li>Name: ${product.name}</li>
                                    <li>Brand: ${product.brand}</li>
                                    <li>Price: ${user.price}</li>
                                    <li>Calories: ${product.calories}</li>
                                    <li>Shop: ${product.shop}</li>
                                </ul>
                            </#if>
                            <input type="submit" style="background: #009961" value="Szukaj">
                        </form>
                    </div>
                </div>
            </div>
            <#include "common/searchResults.ftlh">
        </div>
    </main>
</header>

<#include "common/copyright-footer.ftlh">