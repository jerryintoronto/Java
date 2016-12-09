

<script type="text/javascript"> 
   function cal ()
   {
    var mark = parseFloat(f.a.value) * .2;
    mark += parseFloat(f.b.value) * .25; 
    mark += parseFloat(f.c.value) * .2; 
    mark += parseFloat(f.d.value) * .35; 

    document.getElementById("final").innerHTML = mark;
   }

</script>

<form name="f" action = " ">
<table>
<caption>Final Mark</caption>

<thead><th width="100" align="left">Items</th><th width="50" align="left">Mark</th><th width="100" align="left"></th></thead>

<tr><td>Assignments</td>
      <td><input name="a" type="text"/></td>
      </tr>

<tr><td>Midterm </td>
      <td><input name="b" type="text"/></td>
      </tr>

<tr><td>Project </td>
      <td><input name="c" type="text"/></td>
      </tr>

<tr><td>Final Exam </td>
      <td><input name="d" type="text"/></td>
      </tr>     

<td><input name="Total" type="button" value="Calculate" onclick="cal()"/>
      </td></tr>

</table>
</form>

<h1 id = "final" ></h1>
