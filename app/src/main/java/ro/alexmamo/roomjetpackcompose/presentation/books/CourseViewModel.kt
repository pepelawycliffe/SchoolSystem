package ro.alexmamo.roomjetpackcompose.presentation.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ro.alexmamo.roomjetpackcompose.domain.model.CourseEntity
import ro.alexmamo.roomjetpackcompose.domain.repository.CourseRepository
import javax.inject.Inject




@HiltViewModel
class CourseViewModel @Inject constructor(
    private val repo: CourseRepository
) : ViewModel() {
    val courseEntitys = repo.getCourses()

    fun addCourse(courseEntity: CourseEntity) = viewModelScope.launch {
        repo.insertCourse(
            courseEntity = courseEntity
        )
    }

    fun deleteCourse(courseEntity: CourseEntity) = viewModelScope.launch {
        repo.deleteCourse(
            courseEntity = courseEntity
        )
    }
}