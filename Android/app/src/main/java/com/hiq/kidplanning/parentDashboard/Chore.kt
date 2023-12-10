package com.hiq.kidplanning.parentDashboard

data class Chore(
    var task: String,
    var description: String = "No Description",
    var pictureID: Int = -1,
    var points: Int = 1,
    var complete: Boolean = false
)
