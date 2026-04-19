package com.example.taskdesk.task.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * JPA-Entity für die Persistenz von Tasks.
 *
 * Wir verwenden hier bewusst kein separates Domain Model,
 * sondern ein vereinfachtes, sauberes Persistenzmodell.
 *
 * Für dieses Lernprojekt ist das ein guter Kompromiss:
 * wenig Boilerplate, aber trotzdem klare Struktur.
 */
@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
public class TaskEntity {

    /**
     * Primärschlüssel.
     *
     * Long ist hier bewusst pragmatisch gewählt:
     * - gut lesbar
     * - einfach im Debugging
     * - für dieses Projekt völlig ausreichend
     *
     * Die Datenbank übernimmt die ID-Erzeugung.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Kurzer Titel der Task.
     */
    @Column(nullable = false, length = 255)
    private String title;

    /**
     * Freitext-Beschreibung.
     */
    @Column(length = 1000)
    private String description;

    /**
     * Fachlicher Status der Task.
     *
     * @Enumerated(EnumType.STRING) ist wichtig:
     * Das Enum wird als lesbarer String in der DB gespeichert,
     * also z. B. "TODO" statt 0, 1 oder 2.
     *
     * Das ist robuster und verständlicher als ORDINAL.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private TaskStatus status;

    /**
     * JPA benötigt einen parameterlosen Konstruktor.
     */
    public TaskEntity() {
    }

    /**
     * Komfort-Konstruktor für einfache Objekterzeugung,
     * z. B. bei Testdaten.
     */
    public TaskEntity(String title, String description, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    /**
     * Kein Setter für ID.
     *
     * Die ID soll nicht von außen gesetzt werden,
     * sondern von der Persistenzschicht.
     */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}