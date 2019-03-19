package training.endava.app.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="NUMAR_DE_TELEFON")
public class NumarDeTelefon implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Integer id;

    @Column(name = "numarDeTelefon")
    private String numarDeTelefon;

    @Transient
    private Integer cifraMagica;

    public NumarDeTelefon() {
    }

    public NumarDeTelefon(Integer id, String numarDeTelefon) {
        this.id = id;
        this.numarDeTelefon = numarDeTelefon;
    }

    public Integer getCifraMagica() {
        cifraMagica = 0;
        for(char c : numarDeTelefon.toCharArray()){
            try{
                int cifra = (int) c;
                cifraMagica += cifra;
            }catch (Exception e){

            }
        }
        return cifraMagica%10;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumarDeTelefon() {
        return numarDeTelefon;
    }

    public void setNumarDeTelefon(String numarDeTelefon) {
        this.numarDeTelefon = numarDeTelefon;
    }
}
