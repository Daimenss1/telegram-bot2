-- liquibase formatted sql

-- changeset Daimenss:1
CREATE TABLE Notification (
                              id                  serial NOT NULL PRIMARY KEY,
                              chat_id             bigint NOT NULL,
                              notification_text   text NOT NULL,
                              notification_date   TIMESTAMP NOT NULL
)