package com.mongodb.quickstart.javaspringbootcsfle.configuration;

import com.mongodb.quickstart.javaspringbootcsfle.model.CompanyEntity;
import com.mongodb.quickstart.javaspringbootcsfle.model.PersonEntity;

import java.util.List;

/**
 * Information about the encrypted collections in the application.
 * As I need the information in multiple places, I decided to create a configuration class with a static list of
 * the encrypted collections and their information.
 */
public class EncryptedCollectionsConfiguration {
    public static final List<EncryptedEntity> encryptedEntities = List.of(
            new EncryptedEntity("test", "persons", PersonEntity.class, "personDEK"),
            new EncryptedEntity("test", "companies", CompanyEntity.class, "companyDEK"));
}
