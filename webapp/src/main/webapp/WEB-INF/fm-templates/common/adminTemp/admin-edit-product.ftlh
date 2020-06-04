<#include "../headerShort.ftlh">
<body>
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Wyszukaj produkt do edycji</h1>
    </div>

    <h1>Find Product by ID</h1>
    <form method="get" action="admin-find-product-by-id">
        Id: <input type="text" name="id"/><br/><br/>
        <input type="submit" name="findById" value="find"/><br/><br/>
    </form>
    <h1>Find Product by Name</h1>
    <form method="get" action="admin-find-product-by-name">
        Id: <input type="text" name="name"/><br/><br/>
        <input type="submit" name="findByName" value="find"/><br/><br/>
    </form>

</header>
</body>
<#include "../copyright-footer.ftlh">
</html>