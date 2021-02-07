package com.eigthteentech.gapsi.entities

import android.content.ClipData.Item
import androidx.room.*


@Dao
interface QueriesDAO {
    @Insert
    fun insert(vararg query: QueryEntity?)

    @Update
    fun update(vararg query: QueryEntity?)

    @Delete
    fun delete(query: QueryEntity?)

    @Query("SELECT * FROM queries")
    fun getItems(): List<QueryEntity>

    @Query("SELECT * FROM queries WHERE name LIKE :name")
    fun getItem(name:String): List<QueryEntity>
}