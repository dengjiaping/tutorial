<?php
/**
 * Created by PhpStorm.
 * User: patrick
 * Date: 14-10-16
 * Time: 下午11:35
 */

     echo "hello world";
     $color= "test";
     echo $color."hello world";
   	 echo "hello world";

 /**
  * variable
  */

$x = 10;
$y =20;
$z = $x+$y;
echo $z;

/**
 * variable scope
 * 1. local
 * 2. global
 * 3. static
 */
$a =10 ; //global variable*

function myTest(){
    $y =90; //local variable
    echo "<p>local variable </p>";
    echo "<br>";
    global $a;
    echo "variable y is : $a";
}

myTest();
echo "<p>global variable:</p>";
echo "variable x is $x";
echo "variable y is $x";

function test2(){
    global $x;
    static $xx =100;
    $x=100;
    echo $x;
    echo $xx++;
}

echo "<p>".test2()."</p>";
echo "<p>".test2()."</p>";
echo "<p>".test2()."</p>";
/**
 * Get GLOBALS
 */

  echo $GLOBALS['y'];
?>
