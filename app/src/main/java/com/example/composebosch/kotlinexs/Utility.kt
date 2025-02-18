package com.example.composebosch.kotlinexs

fun maxPricedItemValue( items: Collection<Item>):Float{
    return items.maxByOrNull { it.price }?.price ?: 0F

}