package com.techieshah;

import java.util.ArrayList;
import java.util.List;

import com.techieshah.domainmodel.BlogPost;

public class BlogPostRepository {
    public static List<BlogPost> blogPosts;
    static {
        blogPosts = new ArrayList<BlogPost>();
        blogPosts.add( new BlogPost( 1, "spring framework", "ws", "first example of rest web services" ) );
        blogPosts.add( new BlogPost( 2, "spring framework", "ws", "second example of rest web services" ) );
    }
}
