/**
 * Created by patrick on 14-10-15.
 */

var foo = 42
var bar =42
var foo_str = "42"
var bar_str ="bar"

console.log(foo==bar)
console.log(foo===bar)
console.log(foo==foo_str)
console.log(foo===foo_str)  /* why false */
console.log(foo==bar_str)

/*
JS only have one type Number which is 64 bit, it is same as JAVA 32bit
no separate type in JS, so 1 equals 1.0
 */

var num1 = 1;
var num2 = 1.0
/*
yes it is true
 */
console.log(num1===num2);

/*
 operator: +,-,*,/
 modulus: %
 increment ++
 decrement --
*/
var a = 1 ;
var c = a++;
console.log("a:"+a);
console.log("c:"+c);



