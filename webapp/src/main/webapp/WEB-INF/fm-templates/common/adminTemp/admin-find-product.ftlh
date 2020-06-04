<#include "../headerShort.ftlh">
<body>
<header class="jumbotron" >
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Wyszukaj produkt do edycji</h1>
    </div>

<#if errorMessage??>
    <span style="color: #ff0000;">${errorMessage}</span><br></br>
</#if>
<#if product??><h1>${product.name}</h1>
    <ul>
        <li>Id: ${product.id}</li>
        <li>Name: ${product.name}</li>
        <li>Brand: ${product.brand}</li>
        <li>Price: ${product.price}</li>
        <li>Calories: ${product.calories}</li>
        <li>Shop: ${product.shop}</li>
        <li>Product Category: ${(product.productCategory)!}</li>
    </ul>
</#if>
    <form method="get" action="admin-edit-product">
        <input type="submit" name="return" value="return"/><br/><br/>
    </form>
</header>
</body>
<#include "../copyright-footer.ftlh">
</html>