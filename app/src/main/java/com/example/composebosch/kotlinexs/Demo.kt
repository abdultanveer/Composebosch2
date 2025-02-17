package com.example.composebosch.kotlinexs

fun main() {
    val results = 39
    var numberOfBooks: Int? = null

    reformat("Today is a day like no other day", false, '_')
    reformat(wordSeparator = '_', str  = "str", divideByCamelHumps = false, )


    when (results) {
        0  -> println("No results")
        in 1..39 -> println("Got results!")
        else -> println("That's a lot of results!")

    }

}


fun reformat(str: String,
             divideByCamelHumps: Boolean,
             wordSeparator: Char,
             normalizeCase: Boolean = true){}

fun double(x: Int) = x * 2

