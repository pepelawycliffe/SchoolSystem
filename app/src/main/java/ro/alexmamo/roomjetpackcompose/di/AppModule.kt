package ro.alexmamo.roomjetpackcompose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ro.alexmamo.roomjetpackcompose.data.dao.AmountDao
import ro.alexmamo.roomjetpackcompose.data.dao.BookDao
import ro.alexmamo.roomjetpackcompose.data.dao.CourseDao
import ro.alexmamo.roomjetpackcompose.data.network.BookDb
import ro.alexmamo.roomjetpackcompose.data.repository.AmountRepositoryImpl
import ro.alexmamo.roomjetpackcompose.data.repository.BookRepositoryImpl
import ro.alexmamo.roomjetpackcompose.data.repository.CourseRepositoryImpl
import ro.alexmamo.roomjetpackcompose.domain.repository.BookRepository
import ro.alexmamo.roomjetpackcompose.domain.repository.CourseRepository
import ro.alexmamo.roomjetpackcompose.domain.repository.AmountRepository

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
}