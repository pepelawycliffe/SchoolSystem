package com.example.roomjetpackcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "amount_table")
data class AmountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var amountId:String,
    var courseId:String,
    var amount:String
)
