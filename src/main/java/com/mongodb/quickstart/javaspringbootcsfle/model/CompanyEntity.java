package com.mongodb.quickstart.javaspringbootcsfle.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.EncryptionAlgorithms;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Encrypted;

import java.util.List;

/**
 * This is the entity class for the "companies" collection.
 * The SpEL expression of the @Encrypted annotation is used to determine the DEK's keyId to use for the encryption.
 *
 * @see com.mongodb.quickstart.javaspringbootcsfle.components.EntitySpelEvaluationExtension
 */
@Document("companies")
@Encrypted(keyId = "#{mongocrypt.keyId(#target)}")
public class CompanyEntity {
    @Id
    private ObjectId id;
    private String name;
    @Encrypted(algorithm = EncryptionAlgorithms.AEAD_AES_256_CBC_HMAC_SHA_512_Deterministic)
    private Long money;



    @Encrypted(algorithm = EncryptionAlgorithms.AEAD_AES_256_CBC_HMAC_SHA_512_Random)
    private List<PersonEntity> persons;

    public CompanyEntity() {
    }

    public CompanyEntity(ObjectId id, String name, Long money, List<PersonEntity> persons) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" + "id=" + id + ", name='" + name + '\'' + ", money='" + money + '\'' + '}';
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
    public List<PersonEntity> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonEntity> persons) {
        this.persons = persons;
    }
}
