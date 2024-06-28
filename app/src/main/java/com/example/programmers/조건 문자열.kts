package com.example.programmers

val n = 20
val m = 30
val ineq = ">"
val eq = "="
var answer = 0

if (ineq == ">" && eq =="=") {if (n >= m) {answer = 1} else answer = 0}
else if (ineq == ">" && eq =="!") {if (n > m) {answer = 1} else answer = 0}
else if (ineq == "<" && eq =="=") {if (n <= m) {answer = 1} else answer = 0}
else if (ineq == "<" && eq =="!") {if (n < m) {answer = 1} else answer = 0}
println(answer)