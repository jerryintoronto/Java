<?php
$xml=simplexml_load_file("page2.xml") or die("Error: Cannot create object");

echo "<table><tr><th>Week</th><th>Subject</th></tr>"; 

for ($x =0; $x < 12; $x++)
{
    //get attribute values
    echo "<tr><td>" . $xml->week[$x]['category'] . "</td>";
   
    //get node values
    echo "<td>" . $xml->week[$x]->subject . "</td></tr>";
}

echo "</table>";

?> 
