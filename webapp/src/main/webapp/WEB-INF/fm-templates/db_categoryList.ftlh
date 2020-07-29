<#include "common/headerShort.ftlh">
<body>
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Lista kategorii</h1>
    </div>
</header>
<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th scope="col"></th>
        <th scope="col"></th>
        <th scope="col">Id</th>
        <th scope="col"></th>
        <th scope="col">Nazwa</th>
        <th scope="col"></th>
        <th scope="col">Edytuj</th>
        <th scope="col">Usuń</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <#list categories as category>
    <tr>
        <th scope="col"></th>
        <th scope="col"></th>
        <th scope="row">${(category.id)!}</th>
        <th scope="col"></th>
        <th>${category.category}</th>
        <th scope="col"></th>
        <th>
            <div class="col-md-6">
                <div class="ANPform-style-2">
                    <form method="get" action="db_findCategoryById?id=${category.id}">
                        <button type="submit" name="id"
                                style="background: #575C60; color: white; padding: 8px 15px 8px 15px; border: none; border-radius: 3px; margin-top: 0; margin-bottom: 0;"
                                value="${category.id}">Edytuj
                        </button>
                    </form>
                </div>
            </div>
        </th>
        <th>
            <div class="col-md-6">
                <div class="ANPform-style-2">
                    <form method="post" action="db_deleteCategory?id=${category.id}">
                        <button type="submit" name="id"
                                style="background: #575C60; color: white; padding: 8px 15px 8px 15px; border: none; border-radius: 3px; margin-top: 0; margin-bottom: 0;"
                                value="${category.id}">Usuń
                        </button>
                    </form>
                </div>
            </div>
        </th>
    </tr>
    </#list>
    </tbody>
</table>
</body>
<#include "common/copyright-footer.ftlh">
</html>