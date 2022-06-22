CREATE TABLE sights
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(256) NOT NULL,
    xCoordinate FLOAT        NOT NULL,
    yCoordinate FLOAT        NOT NULL,
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