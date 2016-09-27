

<h2>Adding and Removing Items</h2>
<br>What would you like to add?<br>


<!-- we add to our foodList from the value of the following input -->    
<input type="text" value="food" id="addFood" />

<!-- we call addToFood(); through the following button  -->    
<input type="submit" value="Add more!!!" onClick="addToFood();">

<!-- The list of food is displayed in the following div -->    
<div id="foods"></div>

<script>
var foodList = [];

function addToFood () {
    var addFood = document.getElementById('addFood').value;
    foodList.push(addFood);

    for (i = 0; i < foodList.length; i++)   {
        var newFood = "<a href='#' onClick='removeRecord(" + i + ");'>X</a> " + foodList[i] + " <br>";
    };
    document.getElementById('foods').innerHTML += newFood;
}


function removeRecord (i) {

    // define variable j with equal to the number we got from removeRecord
    var j = i;

    // define and create a new temporary array
    var tempList = [];

    // empty newFood
    // at the end of the function we "refill" it with the new content
    var newFood = "";
    for (var i = 0; i < foodList.length; i++) {
        if(i != j) {

    // we add all records except the one == to j to the new array
    // the record eual to j is the one we've clicked on X to remove
            tempList.push(foodList[i]);
        } 
    };

    // make redefine foodList by making it equal to the tempList array
    // it should be smaller with one record
    foodList = tempList;

    // re-display the records from foodList the same way we did it in addToFood()
    for (var i = 0; i < foodList.length; i++) {
        newFood += "<a href='#' onClick='removeRecord(" + i + ");'>X</a> " + foodList[i] + " <br>";
    };
    document.getElementById('foods').innerHTML = newFood;
}

</script>



</body>
</html>

