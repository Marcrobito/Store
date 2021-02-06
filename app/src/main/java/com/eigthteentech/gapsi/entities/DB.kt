package com.eigthteentech.gapsi.entities

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [QueryEntity::class], version = 1)
abstract class DB : RoomDatabase() {
    abstract val itemDAO: QueriesDAO
}
