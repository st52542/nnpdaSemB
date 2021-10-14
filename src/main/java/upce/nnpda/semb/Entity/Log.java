package upce.nnpda.semb.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Sensor sensor;
    @Column(length = 45)
    private Float measurement;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(length = 45)
    private Date timestamp;

    @PrePersist
    private void onCreate(){
        timestamp=new Date();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Float getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Float measurement) {
        this.measurement = measurement;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
