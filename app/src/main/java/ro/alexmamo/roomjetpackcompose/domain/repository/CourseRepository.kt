package ro.alexmamo.roomjetpackcompose.domain.repository

import kotlinx.coroutines.flow.Flow
import ro.alexmamo.roomjetpackcompose.domain.model.CourseEntity


typealias CourseEntitys = List<CourseEntity>

interface CourseRepository {
    fun getCourses(): Flow<CourseEntitys>

    suspend fun getCourseById(id: Int): CourseEntity

    suspend fun insertCourse(courseEntity: CourseEntity)

    suspend fun updateCourse(courseEntity: CourseEntity)

    suspend fun deleteCourse(courseEntity: CourseEntity)
}