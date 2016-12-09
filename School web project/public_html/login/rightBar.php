    </ul>
    <ul class="nav navbar-nav navbar-right">

      <?php

      if ($_SESSION["type"] == "ADMIN")
          echo "<li><a href='page9.php'> Manage </a></li>";
      
      ?>

      <li><a href="page8.php"> Contact </a></li>
      <li><a href="../index.php"><span class="glyphicon glyphicon-user"></span> Logout </a></li>
      
    </ul>

  </div>
</nav>