package com.hiq.kidplanning.parentDashboard

data class DashboardDataModel(
    var taskTodo: String,
    var comment: String,
    var isComplete: Boolean,
    var points: Int,
    var pictureID: Int
){}
