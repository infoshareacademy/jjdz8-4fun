<#include "common/headerShort.ftlh">

<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - dodawanie nowego Sklepu lub Kategorii</h1>
    </div>
    </br></br></br></br></br>
    <main role="main">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <div class="ANPform-style-2-heading">Dodanie nowej Kategorii</div>
                        <form method="post" action="/db_addShopOrCategory" accept-charset="utf-8">
                            <label><span>Nowa Kategoria:</span><input type="text"
                                                                      class="ANPinput-field"
                                                                      name="nameCategory" value=""
                                                                      required/></label>
                            <label><span> </span><input type="submit" style="background: #009961"
                                                        value="Zapisz Produkt"/></label>
                        </form>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <div class="ANPform-style-2-heading">Dodanie nowego Sklepu</div>
                        <form method="post" action="/db_addShopOrCategory" accept-charset="utf-8">
                            <label><span>Nowy Sklep:</span><input type="text"
                                                                  class="ANPinput-field"
                                                                  name="nameShop" value=""
                                                                  required/></label>
                            <label><span> </span><input type="submit" style="background: #009961"
                                                        value="Zapisz Produkt"/></label>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>
</header>

<#include "common/copyright-footer.ftlh">
