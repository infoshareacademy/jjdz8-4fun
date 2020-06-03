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
        <div class="row">
            <div class="col-md-6">
                <h3>Opis</h3>
                <p>Każdy z administratorów aplikacji, może dodać nowe produkty by były dostępne dla klientów.</p>
                <p>Dodanie kolejnych produktów ułatwi naszym uzytkownikom dokonanie wyboru podczas tworzenia listy zakupów.</p>
            </div>
            <div class="col-md-6">
                <div class="ANPform-style-2">
                    <div class="ANPform-style-2-heading">Dodanie nowego Produktu do listy wyboru</div>
                    <form method="post" action="/addProduct" accept-charset="utf-8">
                        <label><span>Nazwa <span class="ANPrequired">*</span></span><input type="text" class="ANPinput-field" name="name" value=""/></label>
                        <label><span>Producent <span class="ANPrequired">*</span></span><input type="text" class="ANPinput-field" name="brand" value=""/></label>
                        <label><span>Cena <span class="ANPrequired">*</span></span><input type="text" class="ANPinput-field" name="price" value="" pattern="[0-9]" title="Wartość liczbowa podana w groszach"/></label>
                        <label><span>Kaloryczność <span class="ANPrequired">*</span></span><input type="text" class="ANPinput-field" name="calories" value="" pattern="[0-9]" title="Wartość liczbowa"/></label>
                        <label><span>Sklep</span><select name="shop" class="ANPselect-field">
                                <option value="AUCHAN">AUCHAN</option>
                                <option value="PIOTRiPAWEŁ">PIOTRiPAWEŁ</option>
                                <option value="TESCO">TESCO</option>
                            </select></label>
                        <label><span>Kategoria</span><select name="category" class="ANPselect-field">
                                <option value="WARZYWA">WARZYWA</option>
                                <option value="OWOCE">OWOCE</option>
                                <option value="NABIAŁ">NABIAŁ</option>
                            </select></label>
                        <label><span> </span><input type="submit" value="Zapisz Produkt" /></label>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>

<#include "common/copyright-footer.ftlh">
