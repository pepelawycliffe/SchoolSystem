package com.example.roomjetpackcompose.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import com.example.roomjetpackcompose.domain.model.CourseEntity
import com.example.roomjetpackcompose.domain.repository.CourseEntitys

@Dao
interface CourseDao {
    @Query("SELECT * FROM course_table ORDER BY id ASC")
    fun getCourses(): Flow<CourseEntitys>

    @Query("SELECT * FROM course_table WHERE id = :id")
    suspend fun getCourseById(id: Int): CourseEntity

    @Insert(onConflict = IGNORE)
    suspend fun addCourse(courseEntity: CourseEntity)

    @Update
    suspend fun updateCourse(courseEntity: CourseEntity)

    @Delete
    suspend fun deleteCourse(courseEntity: CourseEntity)
}