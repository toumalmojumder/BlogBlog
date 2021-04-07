package com.toumal.blogblog.Data

import androidx.lifecycle.LiveData

class RBlogRepository(private val rBlogDao: RBlogDao) {

    val readAllData: LiveData<List<RBlog>> = rBlogDao.getAllRBlog()


    suspend fun insertRBlog(rBlog: RBlog){
        return  rBlogDao.insertRBlog(rBlog)
    }
}