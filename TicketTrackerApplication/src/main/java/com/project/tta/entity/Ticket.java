package com.project.tta.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")

public class Ticket

{
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "description")
    private String description;


    @Column(name = "createon")
    private String createon;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCreateon() {
		return createon;
	}


	public void setCreateon(String createon) {
		this.createon = createon;
	}
	
	public Ticket()
	{
		
	}


	public Ticket(Long id, String title, String description, String createon) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createon = createon;
	}

}