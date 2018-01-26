<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${id!""}</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="eureka/css/wro.css">

</head>

<body id="one">
<div class="container-fluid xd-container">
    <h1>Instance : ${id!""}</h1>
    <h1>Ip : ${ip!""}</h1>
    <h1>Application : ${appName!""}</h1>
    <h1>Context Path :  ${contextPath!""}</h1>
    <h1>Provider List</h1>
    <table id='providerMap' class="table table-striped table-hover">
        <thead>
        <tr>
            <th>ClassName</th>
            <th>Path</th>
        </tr>
        </thead>
        <tbody>
        <#list providerMap?keys as key>
        <tr>
            <td>${key}</td>
            <td>${providerMap[key]!""}</td>
        </tr>
        </#list>
        </tbody>
    </table>
    <h1>Consumer List</h1>
    <table id='consumerMap' class="table table-striped table-hover">
        <thead>
        <tr>
            <th>ClassName</th>
            <th>Path</th>
        </tr>
        </thead>
        <tbody>
        <#list consumerMap?keys as key>
        <tr>
            <td>${key}</td>
            <td>${consumerMap[key]!""}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
<script type="text/javascript" src="eureka/js/wro.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('table.stripeable tr:odd').addClass('odd');
        $('table.stripeable tr:even').addClass('even');
    });
</script>
</body>
</html>
