<div class="row scrollList">
    <#if products??>
        <ol>
            <p>Wynik wyszukiwania:</p>
            <#list products as product>
                <li>
                    <p> Nazwa: ${product.getName()} </p>
                    <p> Brand: ${product.getBrand()} </p>
                    <p> Cena: ${product.getPrice()} gr </p>
                    <p> Kaloryczność: ${product.getCalories()} kcal/100g </p>
                    <p> Sklep: ${product.getShop()}</p>
                    <p> Kategoria: ${product.getProductCategory()}</p>
                </li>
            </#list>
        </ol>
    </#if>
</div>