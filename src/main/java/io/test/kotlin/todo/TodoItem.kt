package io.test.kotlin.todo

import java.text.SimpleDateFormat
import java.util.*

class TodoItem(val text: String, val creationDate: Date) {

    var id: Int? = null
    var done: Boolean = false

    constructor(id: Int, text: String, creationDate: Date) : this(text, creationDate) {
        this.id = id
    }

    fun markDone() {
        done = done.not()
    }

    override fun toString(): String {
        var value = "   "+ id.toString() + " - " + SimpleDateFormat("dd.MM.yyyy").format(Date()) + ": " + text + "\n"
        if (done) {
            value = value.replace(Regex(".+"), "   " + id.toString() + " - ************ DONE ************")
        }
        return value
    }
}