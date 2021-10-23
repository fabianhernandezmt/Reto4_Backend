package co.usa.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    
    @Column(length = 250)
    private String messageText;

    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties(value={"messages","reservations"})
    private Skate skate;
    
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties(value={"reservations","messages"}) 
    private Client client;
    
    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Skate getSkate() {
        return skate;
    }

    public void setSkate(Skate skate) {
        this.skate = skate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
   
}
