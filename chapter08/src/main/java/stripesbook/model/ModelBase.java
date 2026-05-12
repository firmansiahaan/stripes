package stripesbook.model;

public abstract class ModelBase {
    private Integer id;
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @Override
    public boolean equals(Object obj) {
        try { return id.equals(((ModelBase) obj).getId()); }
        catch (Exception exc) { return false; }
    }
    @Override
    public int hashCode() {
        return 31 + ((id == null) ? 0 : id.hashCode());
    }
}
