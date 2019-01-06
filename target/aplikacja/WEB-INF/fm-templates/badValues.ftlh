<html>
<head>
    <meta charset="utf-8">
    <title> Aplikacja </title>
<style>
   .tlo {
       font-family: Helvetica DejaVu Sans Light;
       background-image: url("../../bg-bad.jpg");
       /*background-image: url(http://www.gannett-cdn.com/media/2015/07/03/StGeorge/StGeorge/635715299136416784-STG-uncle-sam-0704-01.jpg?width=1080&quality=50);*/
       background-position: center;
       background-repeat: no-repeat;
       background-size: cover;
   }

</style>

</head>

<body class="tlo">
<p>Maestro! Poprawne wartości wprowadzaj</p>

<form name="myForm" action=""  method="post">
    Liczba: <input type="text" name="number">
    <input type="submit" value="Potwierdź"></form>

</body>
<#include "footer.ftlh">
</html>