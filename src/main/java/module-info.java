module com.example.demofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.bootstrapfx.core;

    requires jakarta.persistence;
    requires jakarta.cdi;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires jakarta.transaction;
    requires org.hibernate.commons.annotations;
    requires mysql.connector.j;
    requires net.bytebuddy;
    requires org.jboss.jandex;
    requires jakarta.activation;
    requires jakarta.xml.bind;
    requires org.glassfish.jaxb.core;
    requires org.glassfish.jaxb.runtime;

    opens com.example.demofx.view to javafx.fxml;
    opens com.example.demofx.entities to org.hibernate.orm.core;
    opens com.example.demofx;

    exports com.example.demofx;
    exports com.example.demofx.view;
}