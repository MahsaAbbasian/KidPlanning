package com.hiq.kidplanning.authentication
import com.google.firebase.auth.FirebaseAuth


class FirebaseManager {
    companion object {
        // Access FirebaseAuth instance through this property
        val auth: FirebaseAuth = FirebaseAuth.getInstance()
    }
}