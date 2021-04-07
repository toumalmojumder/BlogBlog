package com.toumal.blogblog.Data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.ParcelField
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "blog_table")
data class RBlog (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "id")
    val id : Int,

    @ColumnInfo(name = "title")
    val title: String? = null,

    @ColumnInfo(name = "description")
    val description: String? = null,

    @ColumnInfo(name = "cover_photo")
    val cover_photo: String? = null,

    @ColumnInfo(name = "categories")
    val categories: String? = null,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "avatar")
    val avatar: String? = null,

    @ColumnInfo(name = "profession")
    val profession: String? = null
):Parcelable