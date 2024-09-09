package ro.alexmamo.roomjetpackcompose.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import ro.alexmamo.roomjetpackcompose.data.dao.AmountDao
import ro.alexmamo.roomjetpackcompose.data.dao.BookDao
import ro.alexmamo.roomjetpackcompose.data.dao.CourseDao
import ro.alexmamo.roomjetpackcompose.data.dao.FinanceDao
import ro.alexmamo.roomjetpackcompose.data.dao.LectureDao
import ro.alexmamo.roomjetpackcompose.domain.model.AmountEntity
import ro.alexmamo.roomjetpackcompose.domain.model.Book
import ro.alexmamo.roomjetpackcompose.domain.model.CourseEntity
import ro.alexmamo.roomjetpackcompose.domain.model.FinanceEntity
import ro.alexmamo.roomjetpackcompose.domain.model.LectureEntity

@Database(
    entities = [Book::class,
        CourseEntity::class,
        AmountEntity:: class,
        FinanceEntity::class,
        LectureEntity::class
               ],
    version = 1,
//    exportSchema = false
)
abstract class BookDb : RoomDatabase() {
    abstract val bookDao: BookDao
    abstract val courseDao: CourseDao
    abstract val amountDao: AmountDao
    abstract val financeDao: FinanceDao
    abstract val lectureDao: LectureDao
}