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
                    <h3>${product.name}</h3>
                    <ul>
                        <li>Id: ${(product.id)!}</li>
                        <li>Name: ${product.name}</li>
                        <li>Brand: ${product.brand}</li>
                        <li>Price: ${product.price}</li>
                        <li>Calories: ${product.calories}</li>
                        <li>Shop: ${product.shop}</li>
                        <li>Product Category: ${(product.productCategory)}</li>
                        <li>Amount: ${(product.amount)!}</li>
                    </ul>
                </div>
                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <div class="ANPform-style-2-heading">Edytuj ilość dla: ${product.name}</div>
                        <form method="post" action="/editProductList?id=${productId}" accept-charset="utf-8">
                            <input type="hidden" id="custId" name="id" value="${product.id}">
                            <label><span>Nazwa</span><input type="text"
                                                            readonly="readonly"
                                                            class="ANPinput-field"
                                                            name="name" value="${product.name}"
                                /></label>
                            <label><span>Ilość</span><input
                                        type="number"
                                        min="1"
                                        max="20"
                                        step="1"
                                        class="ANPinput-field"
                                        name="amount"
                                        value="${product.amount}"
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