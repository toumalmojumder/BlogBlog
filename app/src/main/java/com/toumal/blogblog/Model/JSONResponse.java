package com.toumal.blogblog.Model;

public class JSONResponse {
    private Blog[] blogs;

    public JSONResponse() {
    }

    public JSONResponse(Blog[] blogs) {
        this.blogs = blogs;
    }

    public Blog[] getBlogs() {
        return blogs;
    }

    public void setBlogs(Blog[] blogs) {
        this.blogs = blogs;
    }
}
