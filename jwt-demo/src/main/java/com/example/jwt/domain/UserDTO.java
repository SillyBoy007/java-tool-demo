package com.example.jwt.domain;

public class UserDTO {
    private Long id;
    private String open_id;

    @Override
    public String toString() {
        return "UserEo{" +
                "id=" + id +
                ", open_id='" + open_id + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }


}
