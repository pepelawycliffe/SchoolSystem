package com.example.roomjetpackcompose.data.repository


import com.example.roomjetpackcompose.data.dao.CourseDao
import com.example.roomjetpackcompose.domain.model.CourseEntity
import com.example.roomjetpackcompose.domain.repository.CourseRepository


class CourseRepositoryImpl(
    private val courseDao: CourseDao
) : CourseRepository {

    override fun getCourses() = courseDao.getCourses()

    override suspend fun getCourseById(id: Int) = courseDao.getCourseById(id)

    override suspend fun insertCourse(courseEntity: CourseEntity) = courseDao.addCourse(courseEntity)

    override suspend fun updateCourse(courseEntity:CourseEntity) = courseDao.updateCourse(courseEntity)

    override suspend fun deleteCourse(courseEntity: CourseEntity) = courseDao.deleteCourse(courseEntity)
}