<#include "common/headerShort.ftlh">
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - edycja produktu</h1>
    </div>

    </br>
    <main role="main">
        <div class="container">
            <div class="row">
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
                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <div class="ANPform-style-2-heading">Edytuj ${product.name}</div>
                        <form method="post" action="/editProduct?id=${productId}" accept-charset="utf-8">
                            <input type="hidden" id="custId" name="id" value="${product.id}">
                            <label><span>Nazwa</span><input type="text"
                                                            class="ANPinput-field"
                                                            name="name" value="${product.name}"
                                /></label>
                            <label><span>Producent</span><input type="text"
                                                                class="ANPinput-field"
                                                                name="brand" value="${product.brand}"
                                /></label>
                            <label><span>Cena</span><input type="number"
                                                           class="ANPinput-field"
                                                           name="price" value="${product.price}"
                                                           pattern="[0-9]{1-10}"
                                                           title="Wartość liczbowa podana w groszach"
                                /></label>
                            <label><span>Kaloryczność</span><input type="number"
                                                                   class="ANPinput-field"
                                                                   name="calories"
                                                                   value="${product.calories}"
                                                                   pattern="[0-9]{1-10}"
                                                                   title="Wartość liczbowa"
                                                                   required/></label>
                            <label><span>Sklep</span><select name="shop" class="ANPselect-field">
                                    <option id="AUCHAN" value="AUCHAN">AUCHAN</option>
                                    <option id="PIOTRiPAWEŁ" value="PIOTRiPAWEŁ">PIOTRiPAWEŁ</option>
                                    <option id="TESCO" value="TESCO">TESCO</option>
                                </select></label>
                            <label><span>Kategoria</span><select name="category" class="ANPselect-field">
                                    <option id="WARZYWA" value="WARZYWA">WARZYWA</option>
                                    <option id="OWOCE" value="OWOCE">OWOCE</option>
                                    <option id="NABIAŁ" value="NABIAŁ">NABIAŁ</option>
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
<script>
    function checkSelected() {
        document.getElementById("${product.shop}").selected = "true";
        document.getElementById("${product.productCategory}").selected = "true";
    }
    checkSelected();
</script>
<#include "common/copyright-footer.ftlh">
</html>