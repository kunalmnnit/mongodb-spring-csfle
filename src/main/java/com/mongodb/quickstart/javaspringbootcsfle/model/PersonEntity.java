package com.mongodb.quickstart.javaspringbootcsfle.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.EncryptionAlgorithms;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Encrypted;
import org.springframework.data.mongodb.core.mapping.ExplicitEncrypted;

/**
 * This is the entity class for the "persons" collection.
 * The SpEL expression of the @Encrypted annotation is used to determine the DEK's keyId to use for the encryption.
 *
 * @see com.mongodb.quickstart.javaspringbootcsfle.components.EntitySpelEvaluationExtension
 */
//@Document("person")
@Encrypted(keyId = "#{mongocrypt.keyId(#target)}", algorithm = EncryptionAlgorithms.AEAD_AES_256_CBC_HMAC_SHA_512_Deterministic)
public class PersonEntity {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
//    @ExplicitEncrypted(algorithm = "AEAD_AES_256_CBC_HMAC_SHA_512-Deterministic")
    private String ssn;
//    @ExplicitEncrypted(algorithm = "AEAD_AES_256_CBC_HMAC_SHA_512-Random")
    private String bloodType;

    public PersonEntity() {
    }

    public PersonEntity(ObjectId id, String firstName, String lastName, String ssn, String bloodType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return "PersonEntity{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", ssn='" + ssn + '\'' + ", bloodType='" + bloodType + '\'' + '}';
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
