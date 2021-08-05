package by.it_academy.polyclinic.model;

import by.it_academy.polyclinic.model.enumeration.InfoType;

import javax.persistence.*;

@Entity
public class Information {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text",length = 9999)
    private String text;
    private String tag;
    private String filename;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private InfoType infoType;

    public Information(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Information() {
    }

    public InfoType getInfoType() {
        return infoType;
    }

    public void setInfoType(InfoType infoType) {
        this.infoType = infoType;
    }
}
