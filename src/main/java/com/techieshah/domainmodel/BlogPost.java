package com.techieshah.domainmodel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BlogPost {

    public Integer id;
    public String name;
    public String tag;
    public String content;
    
    public BlogPost() {
        
    }
    public BlogPost(Integer id,String name,String tag,String content) {
        this();
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.content = content;
    }
}
