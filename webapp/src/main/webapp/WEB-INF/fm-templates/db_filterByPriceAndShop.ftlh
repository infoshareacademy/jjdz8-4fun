<#include "common/headerShort.ftlh">
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - wyszukaj po cenie</h1>
    </div>
    </br>
    <main role="main">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <div class="ANPform-style-2-heading" style="width: 800px">Wyświetlenie produktów pogrupowanych
                            sklepami po podanej cenie jako filtr
                        </div>
                        <form method="get" action="/db_filterByPriceAndShop" accept-charset="utf-8">
                            <label>
                                <span style="width: 800px"> Podaj maksymalną cenę po jakiej chcesz filtrować produkty </span>
                                <input id="price" type="range" name="price" min="0" max="10000" step="50" value="5000"/>
                                <span id="priceSpan"> Wybrana wartość: </span>
                            </label>
                            </br></br></br>
                            <input type="submit" style="background: #009961" value="Szukaj">
                        </form>
                    </div>
                </div>
            </div>
            <div class="row scrollList">
                    <ul>
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
                    </ul>
            </div>
        </div>
    </main>
</header>

<#include "common/copyright-footer.ftlh">

<script>
    $(document).ready(function () {

        const $valueSpan = $('#priceSpan');
        const $value = $('#price');
        $valueSpan.html($value.val() / 100 + " zł");
        $value.on('input change', () => {

            $valueSpan.html($value.val() / 100 + " zł");
        });
    });
</script>