<header id="header" class="fixed-top ">
    <button type="button" class="mobile-nav-toggle d-lg-none"><i class="icofont-navigation-menu"></i></button>

    <div class="container-fluid">

        <div class="row justify-content-center">
            <div class="col-xl-9 d-flex align-items-center justify-content-between">
                <h1 class="logo"><a href="/home">4-FUN</a></h1>
                <!-- Uncomment below if you prefer to use an image logo -->
                <!-- <a href="index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

                <nav class="nav-menu d-none d-lg-block">
                    <ul>
                        <li class="active"><a href="/home">Strona główna</a></li>
                        <li><a href="/about">O nas</a></li>
                        <li><a href="/about">Usługi</a></li>
                        <li class="drop-down"><a href="">Wyszukaj wszystkie produkty</a>
                            <ul>
                                <li><a href="/filterUserProductsByCategory">Po kategorii</a></li>
                                <li><a href="/filterUserProductsByCalories">Po kaloryce</a></li>
                                <li><a href="/filterByPriceAndShop">Po cenie i pogrupuj po sklepie</a></li>
                            </ul>
                        </li>
                        <li><a href="#portfolio">Portfolio</a></li>
                        <li class="drop-down"><a href="#pricing">Lista zakupow</a>
                            <ul>
                                <li><a href="/addToShoppingList">Dodaj produkt do listy zakupów</a></li>
                                <li><a href="/showShoppingList">Wyświetl listę zakupów</a></li>
                            </ul>
                        </li>
                        <li><a href="#contact">Kontakt</a></li>
                    </ul>
                </nav><!-- .nav-menu -->
                <div class="aWrap">
                    <p class="hello"> Użytkowniku jesteś zalogowany jako ${email}
                        <a href="/logout" class="get-started-btn scrollto">Wyloguj</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</header><!-- End Header -->
