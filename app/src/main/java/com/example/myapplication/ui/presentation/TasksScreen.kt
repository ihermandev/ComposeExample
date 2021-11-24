package com.example.myapplication.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.database.Task
import com.example.myapplication.ui.viewmodel.EditTaskScreenViewModel
import com.example.myapplication.ui.viewmodel.MyViewModelFactory
import com.example.myapplication.ui.viewmodel.NewTaskScreenViewModel
import com.example.myapplication.ui.viewmodel.TasksScreenViewModel

@Composable
fun TasksScreen(vmf: MyViewModelFactory, onTaskClicked: (Task) -> Unit) {
    val vm: TasksScreenViewModel = viewModel(factory = vmf)
    val tasks = vm.getTasks().observeAsState()
    tasks.value?.let { list ->
        TaskList(list) { task ->
            onTaskClicked(task)
        }
    }
}

@Composable
fun NewTaskScreen(vmf: MyViewModelFactory, onTaskAdded: () -> Unit) {
    val vm: NewTaskScreenViewModel = viewModel(factory = vmf)
    Column {
        TaskEditor(Task(name = "", complete = false), onTaskChange = {
            vm.addTask(it)
            onTaskAdded()
        })
    }
}


@Composable
fun EditTaskScreen(vmf: MyViewModelFactory, taskId: Long, onTaskAdded: () -> Unit) {
    val vm: EditTaskScreenViewModel = viewModel(factory = vmf)
    val task = vm.getTask(taskId).observeAsState()
    Column {
        task.value?.let {
            TaskEditor(it, onTaskChange = { task ->
                vm.saveTask(task)
                onTaskAdded()
            })
        }
    }
}

