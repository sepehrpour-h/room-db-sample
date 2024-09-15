package com.sepehrpour.sampleroomdatabasecompose

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "counter_table")
data class CounterEntity(
    @PrimaryKey val id: Int = 0,
    val value: Int
)
