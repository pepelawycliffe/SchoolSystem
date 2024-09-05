package ro.alexmamo.roomjetpackcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "amountTB")
data class Amount(
    @PrimaryKey(autoGenerate = false)
    var amountId:String,
    var courseId:String,
    var amount:Int
)
