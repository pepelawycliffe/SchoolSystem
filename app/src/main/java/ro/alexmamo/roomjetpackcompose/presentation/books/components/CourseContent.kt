package ro.alexmamo.roomjetpackcompose.presentation.books.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ro.alexmamo.roomjetpackcompose.domain.model.Book
import ro.alexmamo.roomjetpackcompose.domain.model.CourseEntity
import ro.alexmamo.roomjetpackcompose.domain.repository.CourseEntitys

@Composable
fun CourseContent(
    padding: PaddingValues,
    courseEntitys: CourseEntitys,
    deleteCourse: (courseEntity:CourseEntity) -> Unit,
    navigateToUpdateCourseScreen: (id: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = courseEntitys
        ) { courseEntity ->
            CourseCard(
                courseEntity= courseEntity,
                deleteCourse = {
                    deleteCourse(courseEntity)
                },
                updateCourse = {
                    navigateToUpdateCourseScreen(courseEntity.id)
                }
            )
        }
    }
}