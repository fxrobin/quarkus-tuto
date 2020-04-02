package fr.fxjavadevblog.qjg;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
@ToString(of = { "id", "name" })

// CDI Annotation
@Dependent

// JPA Annotation
@Entity
public class VideoGame implements Serializable
{
    @Id
    @Inject
    @InjectedUUID // ask CDI to inject an brand new UUID via the UUID Producer.
    @Getter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Version
    @Getter
    private Long version;
}
