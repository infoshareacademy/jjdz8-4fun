<!DOCTYPE html>
<html>
<head>
    <title>shoppinglist - znajdz produkt po numerze id</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/wwr/css/find-facilities-by-patient.css">
</head>
<body class="bg-light">
<#include "common/headerShort.ftlh">
<main>
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">Wyszukiwanie produktu po numerze id</h1>
            <div class="lead">
                <form name="adminfindingproductbyid">
                    <p>
                        <input class="patientNameInput" type="text" name="patient-surname"
                               placeholder="Wpisz id produtu">
                        <button type="submit" class="patientNameInputButton btn btn-primary btn-sm my-2 my-sm-0">Szukaj</button>
                    </p>
                </form>
                <p>
                    <#if selectedPatients??>
                    <#if selectedPatients?size == 0>Nie znaleziono takiego pacjenta.
                    <#else>Najbliższe placówki rehabilitacyjne dla pacjenta:
                </p>
                <#list selectedPatientsFacilities as patient, facilities>
                    <p class="font-weight-bold">${patient.surname}, ${patient.name}</p>
                    <ul>
                        <#if facilities?has_content>
                            <#list facilities as facility>
                                <li class="facility"><span class="facility-span"
                                                           title="Kliknij, aby zobaczyć szczegóły">${facility.name}</span>
                                    <ul class="facility-details">
                                        <li>Adres: ul. ${facility.address.street}, ${facility.address.postalCode?c?substring(0,2)}-${facility.address.postalCode?c?substring(2)} ${facility.address.city}</li>
                                        <li><#if facility.services?size == 0>Brak wprowadzonych usług<#else>Usługi: ${facility.services?join(", ")}</#if></li>
                                        <li>Kontakt: tel. ${facility.address.phone}</li>
                                    </ul>
                                </li>
                            </#list>
                        <#else>
                            <li>Brak placówek w mieście zamieszkania</li>
                        </#if>
                    </ul>
                </#list>
                </#if>
                </#if>
            </div>
        </div>
    </div>
</main>

<#include "../copyright-footer.ftlh">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script src="/wwr/js/find-facilities-by-patient.js"></script>

</body>
</html>