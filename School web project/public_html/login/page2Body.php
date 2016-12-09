<!DOCTYPE html>
<html>

<head>
<style>
table {
    font-family: arial, sans-serif;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>

<body>
<h2>Topics of 334</h2>

<button type="button" onclick="ajaxLoad()">Show</button>
<br><br>
<div id="here"></div><br>


<script>
//1. client event occurs 
function ajaxLoad(p) {
  //2. XMLHTTpRequest object is created 
  var x = new XMLHttpRequest();

  //3. Configuring the object 
  x.onreadystatechange = function() {  //callback function 

    //6. callback function is true
    if (x.readyState == 4 && x.status == 200) {
      //readyState 4: request finished and response is ready
      //status	200: "OK"

      //5. returns string from txt file - x.responseText; 
      //7. updates HTML via .innerHTML 
      document.getElementById("here").innerHTML = x.responseText;
    }
  };

  //4. make asynchronous request to the webserver 
  x.open("GET", "page2Supplement.php", true);
  x.send();

}





</script>




<p><i>
Using AJAX to load PHP script which processes <a href="page2.xml">xml file</a> into a table.
</i></p>
