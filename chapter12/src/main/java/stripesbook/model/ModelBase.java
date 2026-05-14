package stripesbook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public abstract class ModelBase {
	@Id
	@GeneratedValue
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
