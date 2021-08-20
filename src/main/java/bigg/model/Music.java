package bigg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(max = 800)
    @Pattern(regexp = "^[a-zA-z0-9]+$")
    private String songName;
    @NotEmpty
    @Size(max = 300)
    @Pattern(regexp = "^[a-zA-z0-9]+$")
    private String singer;
    @NotEmpty
    @Size(max = 1000)
    @Pattern(regexp = "^[a-zA-z0-9,]+$")
    private String type;

    public Music() {
    }

    public Music(String songName, String singer, String type) {
        this.songName = songName;
        this.singer = singer;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
