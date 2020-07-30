<#include "common/headerShort.ftlh">
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - wyszukaj po kaloriach</h1>
    </div>
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
                            <input ${firstChoiceSelected!} type="radio" id="firstRange" name="calories"
                                                           value="${firstRange}">
                            <label for="firstRange">0-150 kcal/100g</label><br>
                            <input ${secondChoiceSelected!} type="radio" id="secondRange" name="calories"
                                                            value="${secondRange}">
                            <label for="secondRange">151-300 kcal/100g</label><br>
                            <input ${thirdChoiceSelected!} type="radio" id="thirdRange" name="calories"
                                                           value="${thirdRange}">
                            <label for="thirdRange">od 301 kcal/100g</label><br>
                            <input type="submit" style="background: #009961" value="Szukaj">
                        </form>
                    </div>
                </div>
            </div>
            <#include "common/searchResults.ftlh">
        </div>
    </main>
</header>

<#include "common/copyright-footer.ftlh">