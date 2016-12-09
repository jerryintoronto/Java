<h2>HTML Injection Prevention</h2>

<br><li>Don't allow users to submit markup containing "form" and "formaction" attributes or transform them to bogus attributes. Avoid "id" attributes for forms as well as 
<br><li>User submitted markup should not contain "autofocus" attributes.
<br><li>Make sure only relative URIs, http URIs and correctly MIME-typed data URIs can be used for VIDEO poster attributes
<br><li>Make sure users cannot submit markup including the form, "onformchange" and "onforminput" attributes. Do not apply FORM elements with an "id" attribute.
<br><li>Avoid white-listing the "dirname" attribute in user generated content. The effects on existing forms are hard to predict and might cause privacy problems and information leaks.


<script > 
   function filter ()
   {
    var after = document.f.a.value; 

    after = after.replace(/\W+/g, " ")
    document.getElementById("out").innerHTML = after;
   }

</script>

<br><br><br>
<form name="f" action = " ">

Try form =, dirname=, etc to see filtering:

<br>
<input name="a" size= "50" placeholder="Using regex to filter out non-alpha-numerics" type="text"/>
<input type="button" value="Filter" onclick="filter()"/>

</table>
</form>

<h1 id = "out" ></h1>
