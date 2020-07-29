<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Nazwa</th>
        <th scope="col">Firma</th>
        <th scope="col">Cena</th>
        <th scope="col">Kalorie</th>
        <th scope="col">Sklep</th>
        <th scope="col">Kategoria</th>
    </tr>
    </thead>
    <tbody>
    <#if products??>
        <ol>
            <p>Wynik wyszukiwania:</p>
            <#list products as product>
                <tr>
                    <td> ${product.getName()} </td>
                    <td> ${product.getBrand()} </td>
                    <td> ${product.getPrice()} gr</td>
                    <td> ${product.getCalories()} kcal/100g</td>
                    <td> ${product.getShop()}</td>
                    <td> ${product.getProductCategory()}</td>
                </tr>
            </#list>
        </ol>
    </#if>
    </tbody>
</table>