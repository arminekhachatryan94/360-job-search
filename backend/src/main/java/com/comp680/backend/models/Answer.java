package com.comp680.backend.models;

import javax.persistence.ManyToOne;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import java.util.List;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.JoinTable;


@Entity
@Table(name="answers")
public class Answer {

    @Id
    @Column(name="answer_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="applicant_id", nullable=false)
    private long applicant_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="applicant_id",referencedColumnName="applicant_id",insertable=false, updatable=false)
    private Applicant applicant;

    @Column(name="question_id", nullable=false)
    private long question_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="question_id",referencedColumnName="question_id",insertable=false, updatable=false)
    private Question question;

    @Column(name="answer", nullable=false)
    private String answer;

    @Column(name="created_at", nullable=false)
    private Date created_at;

    @PrePersist
    protected void onCreated() {
      created_at = new Date();
    }

    public Date getCreatedAt(){
        return this.created_at;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswer(String answer){
        this.answer=answer;
    }

    public Question getQuestion(){
        return question;
    }

    public void setQuestion(Question question){
        this.question=question;
    }

    public Applicant getApplicant(){
        return applicant;
    }

    public void setApplicant(Applicant applicant){
        this.applicant=applicant;
    }
}