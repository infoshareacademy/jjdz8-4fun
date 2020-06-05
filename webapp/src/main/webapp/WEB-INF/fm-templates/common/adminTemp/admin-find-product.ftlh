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
            <label><span>Nazwa </span><input type="text" class="ANPinput-field" name="name" value=""/></label></br>
            <label><span>Producent </span><input type="text" class="ANPinput-field" name="brand" value=""/></label></br>
            <label><span>Cena </span><input type="text" class="ANPinput-field" name="price" value=""
                                            pattern="[0-9]{1-10}"
                                            title="Wartość liczbowa podana w groszach"/></label></br>
            <label><span>Kaloryczność </span><input type="text" class="ANPinput-field" name="calories" value=""
                                                    pattern="[0-9]{1-10}" title="Wartość liczbowa"/></label></br>
            <label><span>Sklep</span><select name="shop" class="ANPselect-field">
                    <option value="AUCHAN">AUCHAN</option>
                    <option value="PIOTRiPAWEŁ">PIOTRiPAWEŁ</option>
                    <option value="TESCO">TESCO</option>
                </select></label>
            <label><span>Kategoria</span><select name="category" class="ANPselect-field"></br>
                    <option value="WARZYWA">WARZYWA</option>
                    <option value="OWOCE">OWOCE</option>
                    <option value="NABIAŁ">NABIAŁ</option>
                </select></label>
            <label><span> </span><input type="submit" value="Zapisz Produkt"/></label></br>
            </form>
        </div>
    </div>
    <form method="get" action="admin-edit-product">
        <input type="submit" name="return" value="return"/><br/><br/>
    </form>
</header>
</body>
<#include "../copyright-footer.ftlh">
</html>