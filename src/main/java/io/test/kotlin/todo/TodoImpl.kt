package io.test.kotlin.todo

class TodoImpl : Todo {
    val todoList = mutableListOf<TodoItem>()

    override val getTodoList: MutableList<TodoItem>
        get() = todoList

    override fun addItem(todoItem: TodoItem) {
        todoList.add(todoItem)
    }

    override fun deleteItem(id: Int) {
        todoList.removeIf({ element -> element.id == id })
    }

    override fun getItemById(id: Int): TodoItem {
        return todoList.get(id)
    }

    override fun toString(): String {
        val value = StringBuilder()
        for (todoItem in todoList){
            value.append(todoItem.toString())
        }
        return value.toString()
    }

}
