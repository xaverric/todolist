package io.test.kotlin.todo

interface Todo {

    val getTodoList: MutableList<TodoItem>

    fun addItem(todoItem: TodoItem)

    fun deleteItem(id: Int)

    fun getItemById(id: Int): TodoItem
}