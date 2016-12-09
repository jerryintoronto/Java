<?php

$q = $_GET['q'];

if ( $q == 'a')
    echo "client event occurs ";
else if ( $q == 'b')
    echo "XMLHTTpRequest object is created ";
else if ( $q == 'c')
    echo "configuring the object via .onreadystatechange";
else if ( $q == 'd')
    echo "make asynchronous request to the webserver via .open and .send";
else if ( $q == 'e')
    echo "returns string/XML via .responseText or .responseXML";
else if ( $q == 'f')
    echo "callback function runs when readyState == 4 && x.status == 200";
else if ( $q == 'g')
    echo "updates HTML via (example) document.getElementById('id_here').innerHTML";

echo "<br>";
    ?>
