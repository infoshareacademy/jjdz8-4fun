<#include "common/headerShort.ftlh">
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - wyszukaj po kaloriach</h1>
    </div>
    </br>
    <main role="main">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <div class="ANPform-style-2-heading">Filtorwnie produktów po kaloryczności</div>

                        <form method="get" action="/db_filterUserProductsByCalories" accept-charset="utf-8">
                            <p>
                                <span>Wybierz przedział: </span>
                            </p>
                            <br/>
                            <label><span>MIN: </span><input type="text"
                                                                class="ANPinput-field"
                                                                pattern="[0-9]{1,10}"
                                                                name="min" value="0"
                                /></label>
                            <label><span>MAX: </span><input type="text"
                                                                class="ANPinput-field"
                                                                pattern="[0-9]{1,10}"
                                                                name="max" value="0"
                                /></label><br>
                            <input type="submit" style="background: #009961" value="Szukaj">
                        </form>
                    </div>
                </div>
            </div>
            <#include "common/db_searchResults.ftlh">
        </div>
    </main>
</header>

<#include "common/copyright-footer.ftlh">