package com.example.itunes_clone.utils.schedulers

import io.reactivex.Scheduler

interface BaseScheduler {
    fun io(): Scheduler
    fun main(): Scheduler
}