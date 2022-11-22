package vn.edu.iuh.fit.se.thubonggiareapis.dto;

public abstract class AbstractDTO {
    private long id;

    public AbstractDTO() {
        super();
    }

    public AbstractDTO(long id) {
        super();
        this.id = id;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AbstractUserDTO [id=" + id + "]";
    }


}
