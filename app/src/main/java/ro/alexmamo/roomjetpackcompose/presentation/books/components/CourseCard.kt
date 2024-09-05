package ro.alexmamo.roomjetpackcompose.presentation.books.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.domain.model.Book
import ro.alexmamo.roomjetpackcompose.domain.model.CourseEntity


@Composable
fun CourseCard(
    courseEntity: CourseEntity,
    deleteCourse: () -> Unit,
    updateCourse: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(
            start = 8.dp,
            end = 8.dp,
            top = 4.dp,
            bottom = 4.dp
        ).fillMaxWidth(),
        elevation = 3.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                CourseTitleText(
                    courseTitle = courseEntity.unitId
                )
                CourseText(
                    courseAuthor = courseEntity.unitName
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            EditCourseIcon(
                editCourse = updateCourse
            )
            DeleteCourseIcon(
                deleteCourse = deleteCourse
            )
        }
    }
}