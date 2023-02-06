package com.example.learnkotlin

import java.util.UUID

public class Helper {
    public fun test(): String{
        print("Hello Test")
        return "test"
    }
}
val list = listOf("Kotlin","is","fun")
val count = list.count { currentString ->
    currentString.length == 3
}

enum class EntityType {
    EASY, MEDIUM, HARD
}

object EntityFactory {
    fun create(type:EntityType) : Any{
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.EASY -> TODO()
            EntityType.MEDIUM -> fun String.(msg:String): String = "this is medium $msg"
            EntityType.HARD -> fun String.(msg:String): String = "this is hard $msg"
        }
        return name
    };
}

fun responder(message: String): String {
    var response = EntityFactory.create(EntityType.EASY);
    if (response.toString().isNullOrBlank()) {
        return response.toString()
    }

    return "Sorry, I don't understand that.";
};

fun String.isBlank(): Boolean{
    try {
        this.isBlank()
    } catch(e: Exception){
        return false;
    }
    return true;
}

fun Any.isBlank(): Boolean{
    try {
        this.toString().isBlank()
    } catch(e: Exception){
        return false;
    }
    return true;
}

public fun Int.isOdd():Boolean {
    return this % 2 == 1
}

fun Int.isEven(): Boolean{
    return !this.isOdd()
}

fun print10Numbers() {
    for(i in 1..10){
        println(i)
    }
}

fun <T> List<T>.customCount(function: (T) -> Boolean): Int {
    var counter = 0
    for(string in this) {
        if(function(string)) {
            counter++
        }
    }
    return counter
}

object responses {
    fun create(request:String) : Any{
        val id = UUID.randomUUID().toString()
        val response = when(request){
            "get" -> return fun String.(msg:String): String = "TODO post $msg"
            "post" -> return fun String.(msg:String): String = "TODO post $msg"
            "delete" -> return fun String.(msg:String): String = "TODO delete function $msg"
            "update" -> return fun String.(msg:String): String = "TODO update function $msg"
            "option" -> return fun String.(msg:String): String = "TODO option $msg"
            else -> {
                "Invalid. No such request command."
            }
        }
        return response
    };
}

fun sayHello(): Unit {
    println("".getGreeting())
}

fun Any.getGreeting(): String{
    return "Hello World $this"
}