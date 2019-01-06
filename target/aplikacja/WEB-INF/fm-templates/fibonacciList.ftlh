<html>
<head>
    <meta charset="utf-8">
    <title> Aplikacja </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"/>

</head>
<body>

<p>Wartość w ciągu Fibonacci'ego dla Twojej liczby: ${FibonacciValue}</p>

<main>
    <#if FibonacciList??>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Numbers</th>
            </tr>
            </thead>
            <tbody>
            <#list FibonacciList as lists>
                <tr>
                    <td>
                        ${lists}
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
</main>

</body>
</html>