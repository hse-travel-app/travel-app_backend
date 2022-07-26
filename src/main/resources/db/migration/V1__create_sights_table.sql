CREATE TABLE sights
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(256) NOT NULL,
    latitude    FLOAT        NOT NULL,
    longitude   FLOAT        NOT NULL,
    description VARCHAR(256) NOT NULL,
    siteLink    VARCHAR(256),
    openTime    VARCHAR(64),
    closeTime   VARCHAR(64),
    price       INT
);

CREATE TABLE bars
(
    forAdults BOOL NOT NULL
) INHERITS (sights);

CREATE TABLE cafes
(
    foodType VARCHAR(64)
) INHERITS (sights);

CREATE TABLE museums
(
    discountForChildren BOOL NOT NULL
) INHERITS (sights);

CREATE TABLE streets
(
    history VARCHAR(512) NOT NULL
) INHERITS (sights);

CREATE TABLE users
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(64)  NOT NULL,
    login     VARCHAR(64)  NOT NULL UNIQUE,
    password  VARCHAR(128) NOT NULL,
    authority VARCHAR(64)  NOT NULL
);
