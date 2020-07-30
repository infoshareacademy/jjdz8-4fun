<#include "common/headerShort.ftlh">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - rejestracja</h1>
    </div>
    <main role="main">
        <div class="container">
            <br>
            <hr>
            <div class="card bg-light">
                <article class="card-body mx-auto" style="max-width: 400px;">
                    <h4 class="card-title mt-3 text-center">Stwórz konto</h4>
                    <p class="text-center">Wypełnij poniższe pola aby pomyślnie stworzyć konto</p>
                    <p class="divider-text">
                        <span class="bg-light"></span>
                    </p>
                    <form method="post" action="/createUser" accept-charset="utf-8">
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                            </div>
                            <input type="text" class="form-control" name="name" value="" title="Podaj imię" placeholder="Imię*" required>
                        </div>
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                            </div>
                            <input type="text" class="form-control" name="surName" value="" title="Podaj nazwisko" placeholder="Nazwisko*"
                                   required>
                        </div>
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                            </div>
                            <input type="email" class="form-control" name="email" value="" title="Podaj email" placeholder="Email*" required>
                        </div>
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
                            </div>
                            <input type="text" inputmode="numeric" class="form-control" name="phoneNumber" value="" pattern="[0-9]*"
                                   title="Podaj numer telefonu"
                                   placeholder="Numer telefonu*" required>
                        </div>
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                            </div>
                            <input type="password" class="form-control" name="password" value="" title="Podaj hasło" placeholder="Hasło*"
                                   required>
                        </div>
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                            </div>
                            <input type="password" class="form-control" name="confirmPassword" value="" title="Powtórz hasło" placeholder="Powtórz hasło*"
                                   required>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block"> Stwórz konto</button>
                        </div>
                        <p class="text-center">Masz już konto? <a href="/loginUser">Zaloguj się</a></p>
                    </form>
                </article>
            </div>
        </div>
        <br><br>
        <#include "common/copyright-footer.ftlh">
