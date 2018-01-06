package io.test.kotlin.todo

import java.util.*

class TodoService {

    val todo: Todo = TodoImpl()

    fun addTodo(text: String) {
        todo.addItem(TodoItem(text, Date()))
        adjustTodoItemsIDs()
    }

    fun removeTodo(id: Int) {
        todo.deleteItem(id)
        adjustTodoItemsIDs()
    }

    fun getTodoById(id: Int): TodoItem {
        return todo.getItemById(id - 1)
    }

    private fun adjustTodoItemsIDs(){
        var id = 1;
        for (todoItem in todo.getTodoList){
            todoItem.id = id
            id = id.inc()
        }
    }
}