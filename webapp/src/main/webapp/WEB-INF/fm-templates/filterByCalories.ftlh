<#include "common/headerShort.ftlh">

<header class="jumbotron" xmlns="http://www.w3.org/1999/html">
    <div class="container">
        <h1 class="display-3">Shopping list - wyszukaj po kaloriach</h1>
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
                    <div class="ANPform-style-2-heading">Filtorwnie produktów po kaloryczności</div>
                    <form method="get" action="/filterUserProductsByCalories" accept-charset="utf-8">
                        <p>
                        <span>Wybierz przedział: </span>
                            </p>
                        <br/>
                                <input ${przedzialPierwszySelected!} type="radio" id="przedzialPierwszy" name="calories" value="${przedzialPierwszy}">
                                <label for = "przedzialPierwszy" >0-150 kcal/100g</label><br>
                                <input ${przedzialDrugiSelected!} type="radio" id="przedzialDrugi" name="calories" value="${przedzialDrugi}">
                                <label for = "przedzialDrugi">151-300 kcal/100g</label><br>
                                <input ${przedzialTrzeciSelected!} type="radio" id="przedzialTrzeci" name="calories" value="${przedzialTrzeci}">
                                <label for = "przedzialTrzeci">301-450 kcal/100g</label><br>
                        <input type="submit" value="Szukaj">
                    </form>
                </div>
            </div>
        </div>
        <#include "common/searchResults.ftlh">
    </div>
</main>

<#include "common/copyright-footer.ftlh">