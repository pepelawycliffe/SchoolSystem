package ro.alexmamo.roomjetpackcompose.presentation.update_book

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.EMPTY_STRING
import ro.alexmamo.roomjetpackcompose.domain.model.Book
import ro.alexmamo.roomjetpackcompose.domain.model.CourseEntity
import ro.alexmamo.roomjetpackcompose.domain.repository.BookRepository
import ro.alexmamo.roomjetpackcompose.domain.repository.CourseRepository
import javax.inject.Inject


@HiltViewModel
class UpdateCourseViewModel @Inject constructor(
    private val repo: CourseRepository
) : ViewModel() {
    var course by mutableStateOf(
        CourseEntity(0, EMPTY_STRING, EMPTY_STRING,
            EMPTY_STRING,

        )
    )
        private set

    fun getCourseById(id: Int) = viewModelScope.launch {
        course = repo.getCourseById(
            id = id
        )
    }

    fun updateCourseUnitId(unitId: String) {
        course = course.copy(
            unitId = unitId
        )
    }

    fun updateCourseUnitName(unitName: String) {
        course = course.copy(
            unitName = unitName
        )
    }
    fun updateCourseLecture(lecture: String) {
        course = course.copy(
           lecture = lecture
        )
    }
//    fun updateBookStudentName(studentName: String) {
//        book = book.copy(
//            studentName = studentName
//        )
//    }
//    fun updateBookCourse(course: String) {
//        book = book.copy(
//            course = course
//        )
//    }
//
    fun updateCourse() = viewModelScope.launch {
        repo.updateCourse(
            courseEntity = course
        )
    }
}