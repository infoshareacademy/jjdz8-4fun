<#include "../headerShort.ftlh">
<body>
<header class="jumbotron" >
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Lista produktów</h1>
    </div>

<div>
    <ul>
        <#list products as product>
            <li>Id: ${product.id}</li>
            <li>Name: ${product.name}</li>
            <li>Brand: ${product.brand}</li>
            <li>Price: ${product.price}</li>
            <li>Calories: ${product.calories}</li>
            <li>Shop: ${product.shop}</li>
            <li>Product Category: ${(product.productCategory)!}</li>
            <form method="post" action="admin-delete-product?id=${product.id}">
                <input type="submit" name="findById" value="delete"/><br/><br/>
            </form>
            <#sep><br/></#sep>
        </#list>
    </ul>
</div>
</header>
</body>
<#include "../copyright-footer.ftlh">
</html>