package com.example.pfeesprit.entities;

public class CountTaskByStatusDTO {

    private Long DONE;
    private Long DOING;
    private Long TODO;
    public  CountTaskByStatusDTO() {
    }
    public CountTaskByStatusDTO(Long DONE, Long DOING, Long TODO) {
        this.DONE = DONE;
        this.DOING = DOING;
        this.TODO = TODO;
    }

    public Long getDONE() {
        return DONE;
    }

    public void setDONE(Long DONE) {
        this.DONE = DONE;
    }

    public Long getDOING() {
        return DOING;
    }

    public void setDOING(Long DOING) {
        this.DOING = DOING;
    }

    public Long getTODO() {
        return TODO;
    }

    public void setTODO(Long TODO) {
        this.TODO = TODO;
    }
}
