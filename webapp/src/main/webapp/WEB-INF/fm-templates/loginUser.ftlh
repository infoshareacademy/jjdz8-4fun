<#include "common/headerShort.ftlh">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - logowanie</h1>
    </div>
    <main role="main">
        <div class="container">
            <br>
            <hr>
            <div class="card bg-light">
                <article class="card-body mx-auto" style="max-width: 400px;">
                    <h4 class="card-title mt-3 text-center">Zaloguj się</h4>
                    <p class="text-center">Wypełnij poniższe pola aby pomyślnie się zalogować</p>
                    <p>
                        <a href="" class="btn btn-block btn-facebook"> <i class="fab fa-facebook-f"></i> Zaloguj przez
                            Facebooka</a>
                    </p>
                    <p class="divider-text">
                        <span class="bg-light">LUB</span>
                    </p>
                    <form method="post" action="/loginUser" accept-charset="utf-8">
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                            </div>
                            <input type="email" class="form-control" name="email" value="" title="Podaj email" placeholder="Email*" required
                                   autocomplete="off">
                        </div>
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                            </div>
                            <input type="password" class="form-control" name="password" value="" title="Podaj hasło" placeholder="Hasło*"
                                   required autocomplete="off">
                        </div>
                        <div id="login-error" class="error">
                            Wypełnij poprawnie wszystkie pola
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block"> Zaloguj się</button>
                        </div>
                        <p class="text-center">Nie masz konta? <a href="/createUser">Zarejestruj się </a></p>
                    </form>
                </article>
            </div>
        </div>
        <br><br>
</header>
        <footer style="position: relative;">
            <#include "common/copyright-footer.ftlh">
        </footer>
