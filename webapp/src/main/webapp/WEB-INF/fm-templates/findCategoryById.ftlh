<#include "common/headerShort.ftlh">
<header class="jumbotron">
    <div class="container" style="height: 40px">
        <h1 class="display-3" style="font-size: 40px">Shopping list - edycja sklepu</h1>
    </div>

    <#if errorMessage??>
    <span style="color: #ff0000;">${errorMessage}</span><br/><br/>
    <#else>
    <main role="main">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h3>${(category.category)!}</h3>
                    <ul>
                        <li>Id: ${(category.id)!}</li>
                        <li>Name: ${(category.category)!}</li>
                    </ul>
                    <div class="col-md-6">
                        <div class="ANPform-style-2">
                            <form method="get" style="float: left" action="categoryList">
                                <input type="submit" name="" style="background: #009961"
                                       value="Powrót"/><br/><br/>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="ANPform-style-2">
                        <div class="ANPform-style-2-heading">Edytuj ${(category.category)!}</div>
                        <form method="post" action="/editCategory?id=${categoryId}" accept-charset="utf-8">
                            <input type="hidden" id="custId" name="id" value="${(category.id)!}">
                            <label><span>Nazwa</span><input type="text"
                                                            class="ANPinput-field"
                                                            name="name" value="${(category.category)!}"
                                /></label>
                            <label><span> </span><input type="submit" style="background: #009961"
                                                        value="Zapisz Zmiany"/></label>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>
</header>
</#if>
<#include "common/copyright-footer.ftlh">
</html>