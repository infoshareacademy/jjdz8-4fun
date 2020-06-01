<#include "headerShort.ftlh">
<body>
<header class="jumbotron" >
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Lista produktów</h1>
    </div>
</header>
<div>
    <ul>
        <#list products as product>
            <li>Name: ${product.name}</li>
            <li>Brand: ${product.brand}</li>
            <li>Calories: ${product.calories}</li>
            <li>Shop: ${product.shop}</li>
            <li>Product Category: ${(product.productCategory)!}</li>
            <#sep><br/></#sep>
        </#list>
    </ul>
</div>

</body>
<#include "copyright-footer.ftlh">
</html>