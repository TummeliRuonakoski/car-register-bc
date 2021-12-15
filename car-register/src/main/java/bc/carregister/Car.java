package bc.carregister;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends AbstractPersistable<Long>{

    @Column
    private int serialnumber;

    @Column
    private String registrationnumber;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private int made;

    @ManyToMany
    private List<Owner> owners = new ArrayList<>();
    
}
