package io.test.kotlin.command

enum class Command(val value: String){
    ADD("a"),
    REMOVE("r"),
    DONE("d"),
    SHOW("s"),
    HELP("h"),
    EXIT("exit")
}