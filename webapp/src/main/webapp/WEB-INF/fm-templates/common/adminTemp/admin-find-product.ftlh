<#include "../headerShort.ftlh">
<body>
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Wyszukaj produkt do edycji</h1>
    </div>

    <#if errorMessage??>
        <span style="color: #ff0000;">${errorMessage}</span><br></br>
    </#if>
    <#if product??><h1>${product.name}</h1>
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
    <div class="col-md-6">
        <div class="ANPform-style-2">
            <div class="ANPform-style-2-heading">Edycja produktu</div>
            <form method="put" action="/admin-edit-product?id=${product.id} accept-charset=" utf-8
            ">
            <label><span>Nazwa </span><input type="text" class="ANPinput-field" name="name" value="${product.name}"/></label></br>
            <label><span>Producent </span><input type="text" class="ANPinput-field" name="brand" value="${product.brand}"/></label></br>
            <label><span>Cena </span><input type="text" class="ANPinput-field" name="price" value="${product.price}"
                                            pattern="[0-9]{1-10}"
                                            title="Wartość liczbowa podana w groszach"/></label></br>
            <label><span>Kaloryczność </span><input type="text" class="ANPinput-field" name="calories" value="${product.calories}"
                                                    pattern="[0-9]{1-10}" title="Wartość liczbowa"/></label></br>
            <label><span>Sklep</span><select name="shop" class="ANPselect-field">
                    <option id="AUCHAN" value="AUCHAN">AUCHAN</option>
                    <option id="PIOTRiPAWEŁ" value="PIOTRiPAWEŁ">PIOTRiPAWEŁ</option>
                    <option id="TESCO" value="TESCO">TESCO</option>
                </select></label>
            <label><span>Kategoria</span><select name="category" class="ANPselect-field"></br>
                    <option id="WARZYWA" value="WARZYWA">WARZYWA</option>
                    <option id="OWOCE" value="OWOCE">OWOCE</option>
                    <option id="NABIAŁ" value="NABIAŁ">NABIAŁ</option>
                </select></label>
            <label><span> </span><input type="submit" value="Zapisz Produkt"/></label></br>
            </form>
        </div>
    </div>
    <form method="get" action="admin-edit-product">
        <input type="submit" name="return" value="return"/><br/><br/>
    </form>
</header>
<script>
    function checkSelected() {
        document.getElementById("${product.shop}").selected = "true";
        document.getElementById("${product.productCategory}").selected = "true";
    }
    checkSelected();
</script>
</body>
<#include "../copyright-footer.ftlh">
</html>