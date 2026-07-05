# TaskFlow

TaskFlow ist eine Webanwendung zur Verwaltung von Aufgaben (Tasks). Nutzer können Aufgaben anlegen, bearbeiten, nach Priorität und Status filtern, durchsuchen und wieder löschen.

**Live-Demo:** [taskflow-frontend-tt8b.onrender.com](https://taskflow-frontend-tt8b.onrender.com)

## Tech-Stack

- **Frontend:** Vue 3 (`<script setup>`, TypeScript), Vite
- **Backend:** Spring Boot (Java 21), Spring Data JPA
- **Datenbank:** PostgreSQL
- **Hosting:** Render (Frontend, Backend und Datenbank)
- **Tests:** JUnit 5 + Mockito (Backend), Vitest + @vue/test-utils (Frontend)
- **CI/CD:** GitHub Actions (führt bei jedem Push automatisch alle Tests aus)

## Funktionen

### Aufgaben anlegen

Im Bereich "Neuen Task hinzufügen" einen Titel eingeben (Pflichtfeld), optional eine Beschreibung, und die Priorität wählen (Niedrig, Normal, Hoch). Der Status ist beim Anlegen immer "Offen". Mit einem Klick auf "Hinzufügen" wird die Aufgabe gespeichert und erscheint in der Liste "Deine Aufgaben".

### Aufgaben ansehen und Statistik

Oben zeigt die App drei Kennzahlen live an: die Gesamtanzahl aller Aufgaben, die Anzahl offener Aufgaben und die Anzahl erledigter Aufgaben.

### Suchen

Über das Suchfeld "Tasks nach Titel oder Beschreibung durchsuchen..." lässt sich die Liste live nach Stichwörtern filtern, die im Titel oder in der Beschreibung einer Aufgabe vorkommen.

### Nach Priorität filtern

Mit den Buttons "Alle", "Hoch", "Normal" und "Niedrig" wird die Liste auf Aufgaben der jeweiligen Priorität eingeschränkt.

### Status ändern (Erledigt/Offen)

Über die Checkbox links neben jeder Aufgabe kann der Status zwischen "Offen" und "Erledigt" umgeschaltet werden. Erledigte Aufgaben werden durchgestrichen dargestellt.

### Aufgabe bearbeiten

Über den Button "Bearbeiten" an einer Aufgabe können Titel und Beschreibung direkt in der Liste geändert werden. Mit "Speichern" werden die Änderungen übernommen.

### Aufgabe löschen

Über den Button "Löschen" wird eine einzelne Aufgabe entfernt. Über "Alle löschen" (oberhalb der Liste, erscheint sobald mindestens eine Aufgabe existiert) können alle Aufgaben auf einmal gelöscht werden – dies muss über einen Bestätigungsdialog nochmals bestätigt werden.