<div class="row scrollList">
    <#if products??>
        <ol>
            <p>Wynik wyszukiwania:</p>
            <#if products??>
            <#list products as product>
                <li>
                    <p> Nazwa: ${product.getName()} </p>
                    <p> Brand: ${product.getBrand()} </p>
                    <p> Cena: ${product.getPrice()} gr </p>
                    <p> Kaloryczność: ${product.getCalories()} kcal/100g </p>
                    <p> Sklep: ${product.getShop()}</p>
                    <p> Kategoria: ${product.getProductCategory()}</p>
                </li>
            <#else><b>Brak Produktow do wyswietlenia</b>
            </#list>
            </#if>
        </ol>
    </#if>
</div>