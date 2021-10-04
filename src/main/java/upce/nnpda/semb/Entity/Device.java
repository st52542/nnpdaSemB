package upce.nnpda.semb.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45, nullable = false,unique = true)
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private Set<ListOfDevices> listOfDevices;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ListOfDevices> getListOfDevices() {
        return listOfDevices;
    }

    public void setListOfDevices(Set<ListOfDevices> listOfDevices) {
        this.listOfDevices = listOfDevices;
    }

}
