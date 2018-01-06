package io.test.kotlin

import io.test.kotlin.command.Command
import io.test.kotlin.command.CommandResolver
import io.test.kotlin.todo.TodoService

fun main(args: Array<String>) {
    showStartupHelp()
    val todoService = TodoService()
    while (true) {
        CommandResolver(findCommandByInput(readLine()!!), todoService).resolve()
    }
}

fun findCommandByInput(input: String): Command?{
    return Command.values().find { command -> command.value == input }
}

fun showStartupHelp(){
    println("   press 'h' for help")
}

