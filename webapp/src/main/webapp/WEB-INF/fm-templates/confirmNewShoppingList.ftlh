<#include "common/headerShort.ftlh">

<header class="jumbotron">
    <div class="container">
        <h1 class="display-3">Shopping list</h1>
        <p>
            Strona 4Fun
        </p>
    </div>
</header>

<main role="main">
    <div class="container">
        <div class="row justify-content-center">
            <h2> Produkt został dodany do listy zakupów </h2>
            <th>
                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <form method="get" action="/addToShoppingList">
                            <button >Powróć do listy produktów
                            </button>
                        </form>
                    </div>
                </div>
            </th>
        </div>
    </div>
</main>

<#include "common/copyright-footer.ftlh">
