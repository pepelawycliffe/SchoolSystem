package com.example.roomjetpackcompose.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomjetpackcompose.data.dao.AmountDao
import com.example.roomjetpackcompose.data.dao.BookDao
import com.example.roomjetpackcompose.data.dao.CourseDao
import com.example.roomjetpackcompose.data.dao.FinanceDao
import com.example.roomjetpackcompose.data.dao.LectureDao
import com.example.roomjetpackcompose.domain.model.AmountEntity
import com.example.roomjetpackcompose.domain.model.Book
import com.example.roomjetpackcompose.domain.model.CourseEntity
import com.example.roomjetpackcompose.domain.model.FinanceEntity
import com.example.roomjetpackcompose.domain.model.LectureEntity

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