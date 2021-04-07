package com.toumal.blogblog

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.toumal.blogblog.Data.RBlog
import com.toumal.blogblog.Data.RBlogDatabase
import com.toumal.blogblog.Data.RBlogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RBlogViewModel(application: Application):AndroidViewModel(application) {
     val readAllData:LiveData<List<RBlog>>
    private val repository : RBlogRepository

    init {
        val blgDao = RBlogDatabase.getDatabase(application).rBlogDao
        repository = RBlogRepository(blgDao)
        readAllData = repository.readAllData
    }

    fun addRBlog(rBlog: RBlog){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertRBlog(rBlog)
        }
    }


}