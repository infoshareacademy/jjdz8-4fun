<#include "common/headerShort.ftlh">

<header class="jumbotron">
    <div class="container">
        <h1 class="display-3">Shopping list - wyszukaj po kategorii</h1>
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
                    <div class="ANPform-style-2-heading">Filtorwnie produktów po kategorii</div>
                    <form method="get" action="/filterUserProductsByCategory" accept-charset="utf-8">
                        <label><span>Kategoria</span><select name="category" class="ANPselect-field">
                                <option selected value="Wybierz">WYBIERZ KATEGORIĘ</option>
                                <option value="${nabial}">NABIAŁ</option>
                                <option value="${owoce}">OWOCE</option>
                                <option value="${warzywa}">WARZYWA</option>
                            </select></label>
                        <input type="submit" value="Szukaj">
                    </form>
                </div>
            </div>
        </div>
        <#include "common/searchResults.ftlh">
    </div>
</main>

<#include "common/copyright-footer.ftlh">