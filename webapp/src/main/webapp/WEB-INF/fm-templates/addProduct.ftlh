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



            <form method="post" action="/addProduct">
                Nazwa: <input type="text" name="name"/><br/><br/>
                Producent: <input type="text" name="brand"/><br/><br/>
                Cena: <input type="text" name="price"/><br/><br/>
                Kaloryczność: <input type="text" name="calories"/><br/><br/>

                Sklep: <select name="shop">
                    <option value="AUCHAN">AUCHAN</option>
                    <option value="PIOTRiPAWEŁ">PIOTRiPAWEŁ</option>
                    <option value="TESCO">TESCO</option>
                </select>
                Kategoria: <select name="category">
                    <option value="WARZYWA">WARZYWA</option>
                    <option value="OWOCE">OWOCE</option>
                    <option value="NABIAŁ">NABIAŁ</option>
                    <!-- NABIA&#321 ISO-8859-1-->
                </select>
                <input type="submit" name="save" value="save"/><br/><br/>
            </form>
        </div>
    </div>
</main>

<#include "common/copyright-footer.ftlh">
