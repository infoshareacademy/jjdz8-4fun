<#include "common/headerShort.ftlh">
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - edycja produktu</h1>
    </div>

    <#if errorMessage??>
    <span style="color: #ff0000;">${errorMessage}</span><br/><br/>
    <#else>
    <main role="main">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h3>${(product.name)!}</h3>
                    <ul>
                        <li>Id: ${(product.id)!}</li>
                        <li>Name: ${(product.name)!}</li>
                        <li>Brand: ${(product.brand)!}</li>
                        <li>Price: ${(product.price)!}</li>
                        <li>Calories: ${(product.calories)!}</li>
                        <li>Shop: ${(product.shop)!}</li>
                        <li>Product Category: ${(product.productCategory)!}</li>
                    </ul>
                    <div class="col-md-6">
                        <div class="ANPform-style-2">
                            <form method="get" style="float: left" action="productList">
                                <input type="submit" name="" style="background: #009961"
                                       value="Powrót"/><br/><br/>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <div class="ANPform-style-2-heading">Edytuj ${(product.name)!}</div>
                        <form method="post" action="/editProduct?id=${productId}" accept-charset="utf-8">
                            <input type="hidden" id="custId" name="id" value="${(product.id)!}">
                            <label><span>Nazwa</span><input type="text"
                                                            class="ANPinput-field"
                                                            name="name" value="${(product.name)!}"
                                /></label>
                            <label><span>Producent</span><input type="text"
                                                                class="ANPinput-field"
                                                                name="brand" value="${(product.brand)!}"
                                /></label>
                            <label><span>Cena</span><input type="number"
                                                           class="ANPinput-field"
                                                           name="price" value="${(product.price)!}"
                                                           pattern="[0-9]{1-10}"
                                                           title="Wartość liczbowa podana w groszach"
                                /></label>
                            <label><span>Kaloryczność</span><input type="number"
                                                                   class="ANPinput-field"
                                                                   name="calories"
                                                                   value="${(product.calories)!}"
                                                                   pattern="[0-9]{1-10}"
                                                                   title="Wartość liczbowa"
                                                                   required/></label>
                            <label><span>Sklep</span><select name="shop" class="ANPselect-field">
                                    <#list shops as shop>
                                        <option value=${(shop.id)!}>${shop.shop}</option>
                                    </#list>
                                </select></label>
                            <label><span>Kategoria</span><select name="category" class="ANPselect-field">
                                    <#list categories as category>
                                        <option value=${(category.id)!}>${category.category}</option>
                                    </#list>
                                </select></label>
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