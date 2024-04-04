data class Task(val name: String, var isCompleted: Boolean = false)

fun main(){
    // Initialize an empty list to store tasks
    val taskList = mutableListOf<Task>()

    // Loop to interact with the user
    while (true){
        println("Choose an option:")
        println("1. Add Task")
        println("2. Mark Task as Complete")
        println("3. View Tasks")
        println("4. Exit")

        // Get User input
        val choice = readlnOrNull()?.toIntOrNull()

        // To add task name
        when (choice) {
            1 -> {
                println("Enter Task Name:")
                val taskName = readlnOrNull()
                if (!taskName.isNullOrEmpty()){
                    val newTask = Task(taskName)
                    taskList.add(newTask)
                    println("Task '$taskName' is added")
                } else {
                    println("মনু সঠিক কাজের নাম দিয়ে আবার চেষ্টা কর")

                }
            }

            // To mark task as complete
            2 -> {
                if (taskList.isNotEmpty()){
                    println("Select the index of the task to mark as complete:")
                    val index = readlnOrNull()?.toIntOrNull()
                    if (index != null && index in taskList.indices){
                        val task = taskList[index]
                        task.isCompleted = true
                        println("Task '${task.name}' is successfully marked as completed.")
                    } else {
                        println("Invalid Index. Please try again.")
                    }

                } else {
                    println("No Task is available to mark as complete.")
                }
            }


            3 -> {
                if (taskList.isNotEmpty()) {
                    println("Task:")
                    for((index, task)in taskList.withIndex())  {
                        println("${index + 1}. ${task.name} - ${if (task.isCompleted) "Completed" else "Incomplete"}")
                    }
                } else {
                    println("No Task Available")
                }
            }


            4 -> {
                println("Exiting The Program")
                return
            }
            else -> {
                println("Invalid Choice. Please enter a number between 1 and 4.")
            }




        }
    }
}