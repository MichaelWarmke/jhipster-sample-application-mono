package com.mike.warmke;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.mike.warmke");

        noClasses()
            .that()
            .resideInAnyPackage("com.mike.warmke.service..")
            .or()
            .resideInAnyPackage("com.mike.warmke.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.mike.warmke.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
