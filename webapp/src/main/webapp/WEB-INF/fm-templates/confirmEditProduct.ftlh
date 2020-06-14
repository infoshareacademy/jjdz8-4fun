<#include "common/headerShort.ftlh">

<header class="jumbotron">
    <div class="container">
        <h1 class="display-3">Shopping list</h1>
        <p>
            Strona 4Fun
        </p>
    </div>
</header>

<main role="main">
    <div class="container">
        <div class="row justify-content-center">
            <h2> :) Nowy produkt został zedytowany. :) </h2>
        </div>
        <div class="col-md-6">
            <#if product??><h3>${product.name}</h3>
                <ul>
                    <li>Id: ${(product.id)!}</li>
                    <li>Name: ${product.name}</li>
                    <li>Brand: ${product.brand}</li>
                    <li>Price: ${product.price}</li>
                    <li>Calories: ${product.calories}</li>
                    <li>Shop: ${product.shop}</li>
                    <li>Product Category: ${(product.productCategory)!}</li>
                </ul>
            </#if>
        </div>
    </div>
</main>

<#include "common/copyright-footer.ftlh">
