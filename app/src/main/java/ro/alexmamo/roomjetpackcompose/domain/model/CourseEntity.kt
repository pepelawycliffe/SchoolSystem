package ro.alexmamo.roomjetpackcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
data class CourseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val unitId:String,
    val unitName:String,
    val lecture:String

)