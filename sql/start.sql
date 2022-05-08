-- delete tables 
DROP TABLE IF EXISTS vegetable;
DROP TABLE IF EXISTS fruit;
DROP TABLE IF EXISTS legume;

-- create tables again
CREATE TABLE vegetable (
    id INT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR UNIQUE NOT NULL, 
    description VARCHAR UNIQUE NOT NULL
);

CREATE TABLE fruit (
    id INT GENERATED ALWAYS AS IDENTITY
    name VARCHAR UNIQUE NOT NULL, 
    description VARCHAR UNIQUE NOT NULL
);

CREATE TABLE legume (
    id INT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR UNIQUE NOT NULL, 
    description VARCHAR UNIQUE NOT NULL
);

-- insert initial values
INSERT INTO vegetable(name, description)
VALUES
('onion', 'no baby no cry'),
('tomatoe', 'red and nice in a salad'),
('lettuce', 'always in your burger'),
('pepper', 'red and hot for chili');

INSERT INTO fruit(name, description)
VALUES
('apple', 'red or green but clean'),
('pomelo', 'nobody likes it'),
('orange', 'nice for a morning juice'),
('melon', 'fresh in summer');

INSERT INTO legume(name, description)
VALUES
('bean', 'java uses it a lot'),
('peanut', 'your elephant loves it'),
('lentil', 'metal 4 you ma friend'),
('chickpeas', 'your head is like it');
