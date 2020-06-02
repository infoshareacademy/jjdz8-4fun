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



            <form method="post" action="/addProduct" accept-charset="utf-8">
                Nazwa: <input type="text" name="name" required/><br/><br/>
                Producent: <input type="text" name="brand" required/><br/><br/>
                Cena: <input type="text" name="price" required/><br/><br/>
                Kaloryczność: <input type="text" name="calories" required/><br/><br/>

                Sklep: <select name="shop">
                    <option value="AUCHAN">AUCHAN</option>
                    <option value="PIOTRiPAWEŁ">PIOTRiPAWEŁ</option>
                    <option value="TESCO">TESCO</option>
                </select>
                Kategoria: <select name="category">
                    <option value="WARZYWA">WARZYWA</option>
                    <option value="OWOCE">OWOCE</option>
                    <option value="NABIAŁ">NABIAŁ</option>
                </select>
                <input type="submit" name="save" value="Zapisz Produkt"/><br/><br/>
            </form>
        </div>
    </div>
</main>

<#include "common/copyright-footer.ftlh">
