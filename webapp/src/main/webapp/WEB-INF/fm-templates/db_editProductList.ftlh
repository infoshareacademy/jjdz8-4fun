<#include "common/headerShort.ftlh">
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - edycja ilości</h1>
    </div>

    <#if errorMessage??>
    <span style="color: #ff0000;">${errorMessage}</span><br/><br/>
    <#else>
    <main role="main">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h3>${(product.productName)!}</h3>
                    <ul>
                        <li>Id: ${(product.id)!}</li>
                        <li>Name: ${(product.productName)!}</li>
                        <li>Brand: ${(product.productBrand)!}</li>
                        <li>Price: ${(product.productPrice)!}</li>
                        <li>Calories: ${(product.productCalories)!}</li>
                        <li>Shop: ${(product.productShop)!}</li>
                        <li>Product Category: ${(product.productCategory)!}</li>
                        <li>Amount: ${(product.productAmount)!}</li>
                    </ul>
                </div>
                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <div class="ANPform-style-2-heading">Edytuj ilość dla produktu: ${(product.productName)!}</div>
                        <form method="post" action="/db_editProductList?id=${productId}" accept-charset="utf-8">
                            <input type="hidden" id="custId" name="id" value="${(product.id)!}">
                            <label><span>Ilość</span><input
                                        type="number"
                                        min="1"
                                        max="20"
                                        step="1"
                                        class="ANPinput-field"
                                        name="amount"
                                        value="${(product.productAmount)!}"
                                        title="Wprowadź wartość od 1 do 20"
                                        required/></label>
                            <label><span> </span><input type="submit" style="background: #009961"
                                                        value="Zapisz Zmiany"/></label>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>
</header>

</#if>

<#include "common/copyright-footer.ftlh">
</html>