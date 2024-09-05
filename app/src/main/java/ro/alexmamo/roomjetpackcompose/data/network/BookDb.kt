package ro.alexmamo.roomjetpackcompose.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import ro.alexmamo.roomjetpackcompose.data.dao.BookDao
import ro.alexmamo.roomjetpackcompose.data.dao.CourseDao
import ro.alexmamo.roomjetpackcompose.domain.model.Book
import ro.alexmamo.roomjetpackcompose.domain.model.CourseEntity

@Database(
    entities = [Book::class,
        CourseEntity::class
               ],
    version = 1,
//    exportSchema = false
)
abstract class BookDb : RoomDatabase() {
    abstract val bookDao: BookDao
    abstract val courseDao: CourseDao
}