<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="google-signin-client_id" content="660232798468-dem9oq7ivf3nokhg0t80unddfnepr5fo.apps.googleusercontent.com">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


</head>

<style>
    #full page {
        height:100px;

    }
</style>

<body>

<div class = "container">

    <div class = "row" >

        <h1 class="display-1">5x5 Solo Queue</h1>

    </div>



    <table class="table table-inverse">
        <thead>
        <tr>
            <th>Rank</th>
            <th>Name</th>
            <th>Wins</th>
            <th>Losses</th>
        </tr>
        </thead>
    <?php
    /**
     * Created by PhpStorm.
     * User: J
     * Date: 2/4/2017
     * Time: 10:46 AM
     */

    $json = file_get_contents('https://na.api.pvp.net/api/lol/na/v2.5/league/challenger?type=RANKED_SOLO_5x5&api_key=c453691a-d560-4db6-9cbb-f7a7b6d1ee06');
    $obj = json_decode($json);

    $array =  $obj->entries;
    ?>

        <tbody>
        <tr>

    <?php

    $i = 1;
    foreach ($array as $row){
        echo "<tr><td>". $i . "</td><td>". $row ->playerOrTeamName . "</td><td>" . $row -> wins . "</td>  <td> " . $row->losses . '</td><tr>';
        $i++;
    }
    ?>
    </table>



</div>

</body>

<style>
    body {
        background-image: url("http://ddragon.leagueoflegends.com/cdn/img/champion/splash/Aatrox_0.jpg");
        background-image: linear-gradient(to bottom, rgba(0,0,0,0.6) 0%,rgba(0,0,0,0.6) 100%), url("http://ddragon.leagueoflegends.com/cdn/img/champion/splash/Aatrox_0.jpg");
        background-size: 100%;
</style>

<script>

</script>