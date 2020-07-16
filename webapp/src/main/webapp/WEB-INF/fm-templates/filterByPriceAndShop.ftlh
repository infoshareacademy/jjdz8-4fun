<#include "common/headerShort.ftlh">
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - wyszukaj po cenie</h1>
    </div>
    <main role="main">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <div class="ANPform-style-2-heading" style="width: 800px">Wyświetlenie produktów pogrupowanych
                            sklepami po podanej cenie jako filtr
                        </div>
                        <form method="get" action="/filterByPriceAndShop" accept-charset="utf-8">
                            <label>
                                <span style="width: 800px"> Podaj minimalną cenę po jakiej chcesz filtrować produkty </span>
                                <input id="priceMin" type="range" name="priceMin" min="0" max="10000" step="50"
                                       value="${priceMin ! 5000}"/>
                                <p>Wybrana wartość minimalna:
                                    <span id="priceSpanMin"> </span>
                                </p>
                                <span style="width: 800px"> Podaj maksymalną cenę po jakiej chcesz filtrować produkty </span>
                                <input id="priceMax" type="range" name="priceMax" min="0" max="10000" step="50"
                                       value="${priceMax ! 5000}"/>
                                <p>Wybrana wartość maksymalna:
                                    <span id="priceSpanMax"> </span>
                                </p>
                            </label>
                            <input type="submit" style="background: #009961" value="Szukaj">
                        </form>
                    </div>
                </div>
            </div>
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
                    <#if productsMap??>
                        <tbody>
                        <ul>
                            <p>Wynik wyszukiwania:</p>
                            <#list productsMap as shop, products>
                                <td colspan="6" class="tdGreen"><strong> Produkty sklepu ${shop} </strong>:
                                    <ol>
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
                                </td>
                            </#list>
                        </ul>
                        </tbody>
                    </#if>
            </table>
            <#if productsMap??>
            <#else>
                <p class="emptyResults"> Brak produktów </p>
            </#if>
        </div>
    </main>
</header>

<#include "common/copyright-footer.ftlh">

<script>
    $(document).ready(function () {

        const $valueSpan = $('#priceSpanMin');
        const $value = $('#priceMin');
        $valueSpan.html($value.val() / 100 + " zł");
        $value.on('input change', () => {

            $valueSpan.html($value.val() / 100 + " zł");
        });
    });
</script>

<script>
    $(document).ready(function () {

        const $valueSpan = $('#priceSpanMax');
        const $value = $('#priceMax');
        $valueSpan.html($value.val() / 100 + " zł");
        $value.on('input change', () => {

            $valueSpan.html($value.val() / 100 + " zł");
        });
    });
</script>