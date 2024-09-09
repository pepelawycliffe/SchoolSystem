package com.example.roomjetpackcompose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.example.roomjetpackcompose.data.dao.AmountDao
import com.example.roomjetpackcompose.data.dao.BookDao
import com.example.roomjetpackcompose.data.dao.CourseDao
import com.example.roomjetpackcompose.data.dao.FinanceDao
import com.example.roomjetpackcompose.data.dao.LectureDao
import com.example.roomjetpackcompose.data.network.BookDb
import com.example.roomjetpackcompose.data.repository.AmountRepositoryImpl
import com.example.roomjetpackcompose.data.repository.BookRepositoryImpl
import com.example.roomjetpackcompose.data.repository.CourseRepositoryImpl
import com.example.roomjetpackcompose.data.repository.FinanceRepositoryImpl
import com.example.roomjetpackcompose.data.repository.LectureRepositoryImpl
import com.example.roomjetpackcompose.domain.repository.BookRepository
import com.example.roomjetpackcompose.domain.repository.CourseRepository
import com.example.roomjetpackcompose.domain.repository.AmountRepository
import com.example.roomjetpackcompose.domain.repository.FinanceRepository
import com.example.roomjetpackcompose.domain.repository.LectureRepository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBookDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        BookDb::class.java,
        "schoolDB"
//        BOOK_TABLE
    ).build()

    @Provides
    fun provideBookDao(
        bookDb: BookDb
    ) = bookDb.bookDao

    @Provides
    fun provideCourseDao(
        bookDb: BookDb
    )=bookDb.courseDao

    @Provides
    fun provideCourseRepository(
        courseDao: CourseDao
    ):CourseRepository = CourseRepositoryImpl(
        courseDao=courseDao
    )

    @Provides
    fun provideAmountDao(
        bookDb: BookDb
    )=bookDb.amountDao

    @Provides
    fun provideAmountRepository(
        amountDao: AmountDao
    ):AmountRepository = AmountRepositoryImpl(
        amountDao=amountDao
    )

    @Provides
    fun provideBookRepository(
        bookDao: BookDao
    ): BookRepository = BookRepositoryImpl(
        bookDao = bookDao
    )

    @Provides
    fun provideFinanceDao(
        bookDb: BookDb
    )=bookDb.financeDao

    @Provides
    fun provideFinanceRepository(
        financeDao: FinanceDao
    ): FinanceRepository = FinanceRepositoryImpl(
        financeDao = financeDao
    )
    @Provides
    fun provideLectureDao(
        bookDb: BookDb
    )=bookDb.lectureDao

    @Provides
    fun providelectureRepository(
        lectureDao: LectureDao
    ): LectureRepository = LectureRepositoryImpl(
        lectureDao = lectureDao
    )

}