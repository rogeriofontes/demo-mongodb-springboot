package br.com.uaijug.demomongo.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post {

	@Id
	private String postId;
	
	@TextIndexed
	private String title;

	private String content;

	@Indexed
	private User author;
	
	//private String url;
	
	/*{
		   _id: POST_ID
		   title: TITLE_OF_POST, 
		   description: POST_DESCRIPTION,
		   by: POST_BY,
		   url: URL_OF_POST,
		   tags: [TAG1, TAG2, TAG3],
		   likes: TOTAL_LIKES, 
		   comments: [	
		      {
		         user:'COMMENT_BY',
		         message: TEXT,
		         dateCreated: DATE_TIME,
		         like: LIKES 
		      },
		      {
		         user:'COMMENT_BY',
		         message: TEXT,
		         dateCreated: DATE_TIME,
		         like: LIKES
		      }
		   ]
		}*/
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
