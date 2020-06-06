<#include "common/headerShort.ftlh">

<header class="jumbotron">
    <div class="container">
        <h1 class="display-3">Shopping list - wyszukaj po cenie</h1>
        <p>
            Strona 4Fun
        </p>
    </div>
</header>

<main role="main">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="ANPform-style-2">
                    <div class="ANPform-style-2-heading">Wyświetlenie sklepów po podanej cenie produktu jako filtr</div>
                    <form method="get" action="/filterByPriceAndShop" accept-charset="utf-8">
                                <label>
                                    <span> Podaj cenę <span class="ANPrequired">*</span>
                                    </span>
                                    <input id="price" type="range" name="price" min="0" max="10000" step="50" value="5000"/>
                                    <span id="priceSpan"> Wybrana wartość: </span>
                                </label>
                        <input type="submit" value="Szukaj">
                    </form>
                </div>
            </div>
        </div>
        <div class="row scrollList">
            <#if productsMap??>
                <ul>
                    <p>Wynik wyszukiwania:</p>
                    <#list productsMap as shop, products>
                        <li> <strong> Produkty sklepu ${shop} </strong>:
                            <ol>
                        <#list products as product>
                        <li>
                            <p> Nazwa: ${product.getName()} </p>
                            <p> Brand: ${product.getBrand()} </p>
                            <p> Cena: ${product.getPrice()}</p>
                            <p> Kaloryczność: ${product.getCalories()} kcal/100g </p>
                            <p> Sklep: ${product.getShop()}</p>
                            <p> Kategoria: ${product.getProductCategory()}</p>
                        </li>
                        </#list>
                            </ol>
                        </li>
                    </#list>
                </ul>
            </#if>
        </div>
    </div>
</main>

<#include "common/copyright-footer.ftlh">

<script>
    $(document).ready(function() {

        const $valueSpan = $('#priceSpan');
        const $value = $('#price');
        $valueSpan.html($value.val()/100 + " zł");
        $value.on('input change', () => {

            $valueSpan.html($value.val()/100 + " zł");
        });
    });
</script>