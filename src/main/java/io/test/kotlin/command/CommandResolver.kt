package io.test.kotlin.command

import io.test.kotlin.todo.TodoService

class CommandResolver(val command: Command?, val todoService: TodoService) {

    fun resolve() {
        when (command) {
            Command.ADD -> {
                print("   New todo: ")
                val note = readLine()!!
                todoService.addTodo(note)
            }
            Command.REMOVE -> {
                print("   Todo id: ")
                try {
                    val id = readLine()!!.toInt()
                    todoService.removeTodo(id)
                } catch (ex: Exception) {
                    when (ex) {
                        is NumberFormatException, is IndexOutOfBoundsException -> print("   Wrong input!!!")
                    }
                }
            }
            Command.DONE -> {
                print("   Todo id: ")
                try {
                    val id = readLine()!!.toInt()
                    todoService.getTodoById(id).markDone()
                } catch (ex: Exception) {
                    when (ex) {
                        is NumberFormatException, is IndexOutOfBoundsException -> print("   Wrong input!!!")
                    }
                }
            }
            Command.SHOW -> {
                println("   ALL TODOS")
                println(todoService.todo)
            }
            Command.EXIT -> {
                System.exit(0)
            }
            Command.HELP -> {
                showAllHelp()
            }
            null -> {
            }
        }
    }

    private fun showAllHelp() {
        println("   a              add todo \n" +
                "   r [id]         remove todo with id \n" +
                "   d [id]         mark todo with id as done/undone \n" +
                "   s              show all todos \n\n" +
                "   h              help \n" +
                "   exit           exit")
    }
}