<#include "common/headerShort.ftlh">
<body>
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Wyszukaj produkt</h1>
    </div>

    <div class="col-md-6">
        <div class="ANPform-style-2">
            <div class="ANPform-style-2-heading">Wyszukaj produkt po ID</div>
            <form method="get" action="/admin-find-product-by-id" accept-charset="utf-8">
                Id: <input type="text" class="ANPinput-field" name="id"/><br/><br/>
                <input type="submit" name="findById" class="ANPinput-field ANPCC" style="background: #009961"
                       value="Szukaj"/><br/><br/>
            </form>
        </div>
    </div>
    <div class="col-md-6">
        <div class="ANPform-style-2">
            <div class="ANPform-style-2-heading">Wyszukaj produkt po Nazwie</div>
            <form method="get" action="/admin-find-product-by-name?" accept-charset="utf-8">
                Nazwa: <input type="text" class="ANPinput-field" name="name"/><br/><br/>
                <input type="submit" name="findByName" class="ANPinput-field" style="background: #009961"
                       value="Szukaj"/><br/><br/> (można wpisać fragment nazwy, wyszukuje pierwszy najbardziej pasujący
                wynik)
            </form>
        </div>
    </div>

</header>
</body>
<#include "common/copyright-footer.ftlh">
</html>