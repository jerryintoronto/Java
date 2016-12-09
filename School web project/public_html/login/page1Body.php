
<div><h2>Steps AJAX Operation</h2></div>


<button type="button" onclick="loadDoc('a')">Step 1</button>
<br>
<div id="a"></div><br>
<button type="button" onclick="loadDoc('b')">Step 2</button>
<br>
<div id="b"></div><br>
<button type="button" onclick="loadDoc('c')">Step 3</button>
<br>
<div id="c"></div><br>
<button type="button" onclick="loadDoc('d')">Step 4</button>
<br>
<div id="d"></div><br>
<button type="button" onclick="loadDoc('e')">Step 5</button>
<br>
<div id="e"></div><br>
<button type="button" onclick="loadDoc('f')">Step 6</button>
<br>
<div id="f"></div><br>
<button type="button" onclick="loadDoc('g')">Step 7</button>
<br>
<div id="g"></div><br><br>


<script>
//1. client event occurs 
function loadDoc(p) {
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
      document.getElementById(p).innerHTML = x.responseText;
    }
  };

  //4. make asynchronous request to the webserver 
  x.open("GET", "page1Supplement.php?q=" + p, true);
  x.send();

}

</script>


<p><i>
Using AJAX to load PHP script, passing variable using GET method
</i></p>

