package com.eigthteentech.gapsi.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "queries")
data class QueryEntity (
    @PrimaryKey
    val id: Long,
    val name: String? = null
)