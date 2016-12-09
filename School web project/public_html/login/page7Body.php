

<i>Get MD5 Hex Value:</i> <br><br>

<form method="POST" action="<?php $_SERVER['PHP_SELF']; ?>">
    String: <input type="text" name="str">
    <button type="submit">Submit</button>
</form>


<?php
if (isset($_POST['str']))
{
    $str = $_POST['str'];
    echo "<br><b>32 character hex number:</b><br>" . md5($str);
}
?>
  
