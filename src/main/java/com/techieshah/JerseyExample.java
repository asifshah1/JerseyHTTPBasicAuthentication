package com.techieshah;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import com.techieshah.domainmodel.BlogPost;

/*
 * Author: https://techieshah.blogspot.com
 */

@Path("/")
public class JerseyExample {
  
    @GET
    public BlogPost get(@QueryParam("id") Integer id){
       
        for(BlogPost blogPost : BlogPostRepository.blogPosts) {
            if(blogPost.id == id) {
                return blogPost;
            }
        }
        return null;
    }
    
    @POST
    public String post( BlogPost blogPost){
        BlogPostRepository.blogPosts.add(blogPost);
        return "Blog Post saved successfully";
    }
    
    @PUT
    public String put(BlogPost updatedBlogPost) {
        for(BlogPost blogPost : BlogPostRepository.blogPosts) {
            if(blogPost.id == updatedBlogPost.id) {
               blogPost.name = updatedBlogPost.name;
               blogPost.tag = updatedBlogPost.tag;
               blogPost.content = updatedBlogPost.content;
            }
        }
        return "Blog Post updated successfully";
    }
    
    @DELETE
    public String delete(@QueryParam("id") Integer id){
        
        for(BlogPost blogPost : BlogPostRepository.blogPosts) {
            if(blogPost.id == id) {
                BlogPostRepository.blogPosts.remove( blogPost );
                break;
            }
        }
        return "Blog Post deleted successfully";
    }
}
