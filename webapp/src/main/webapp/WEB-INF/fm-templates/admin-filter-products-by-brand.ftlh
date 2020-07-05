<#include "common/headerShort.ftlh">
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - (admin) wyszukaj produkty po marce</h1>
    </div>
    </br>
    <main role="main">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <div class="ANPform-style-2-heading">(admin) Filtorwnie produktów po marce</div>
                        <form method="get" action="/admin-filter-products-by-brand" accept-charset="utf-8">
                            <label>
                                <span>Kategoria</span>
                                <select name="category" class="ANPselect-field">
                                    <option selected value="Wybierz">WYBIERZ KATEGORIĘ</option>
                                    <option value="${dairy}">NABIAŁ</option>
                                    <option value="${fruits}">OWOCE</option>
                                    <option value="${veggies}">WARZYWA</option>
                                </select>
                            </label>
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